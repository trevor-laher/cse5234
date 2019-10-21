package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryServiceRemote;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.models.LineItem;
import edu.osu.cse5234.models.Order;
import edu.osu.cse5234.models.PaymentInfo;
import edu.osu.cse5234.models.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		InventoryServiceRemote invSrc = ServiceLocator.getInventoryService();
		Inventory inv = invSrc.getAvailableInventory();
		List<Item> invItems = inv.getInventory();
		List<LineItem> items = new ArrayList<LineItem>();
		
		for (Item invItem : invItems) {
			LineItem current = new LineItem();
			current.setItemName(invItem.getName());
			current.setItemNumber(invItem.getItemNumber());
			current.setDescription(invItem.getDescription());
			current.setPrice(invItem.getUnitPrice());
			current.setQuantity(invItem.getAvailableQuantity());
			items.add(current);
		}
		
		Order order = new Order();
		order.setLineItems(items);
		
		request.setAttribute("order", order);
		
		if(request.getSession().getAttribute("error") == null) {
			request.getSession().setAttribute("error", " ");
		}
		
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("order", order);
		request.getSession().removeAttribute("error");
		OrderProcessingServiceBean orderProcess = new OrderProcessingServiceBean();
		String redirect = "redirect:/purchase/paymentEntry";
		if(!orderProcess.validateItemAvailability(order)) {
			request.getSession().setAttribute("error", "There was an error in your order, please try again.");
			redirect = "redirect:/purchase";
		}
		return redirect;
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request) throws Exception {
		request.setAttribute("payment", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}

	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request) throws Exception {
		request.setAttribute("shipping", new ShippingInfo());
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:/purchase/viewOrder";
	}	

	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder() throws Exception {
		return "ViewOrder";
	}	

	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		OrderProcessingServiceBean orderProcess = new OrderProcessingServiceBean();
		String confirm = orderProcess.processOrder(order);
		request.getSession().setAttribute("order", order);
		request.getSession().setAttribute("confirm", confirm);
		return "redirect:/purchase/viewConfirmation";
	}	

	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation() throws Exception {
		return "Confirmation";
	}	

}