package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.models.Item;
import edu.osu.cse5234.models.Order;
import edu.osu.cse5234.models.PaymentInfo;
import edu.osu.cse5234.models.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Order ord = new Order();
		Item cat1 = new Item();
		Item cat2 = new Item();
		Item cat3 = new Item();
		Item cat4 = new Item();
		Item cat5 = new Item();
		
		cat1.setName("ragdoll");
		cat2.setName("munchkin");
		cat3.setName("scottish fold");
		cat4.setName("toyger");
		cat5.setName("bengal");
		
		cat1.setPrice("12");
		cat2.setPrice("200");
		cat3.setPrice("35");
		cat4.setPrice("78");
		cat5.setPrice("5000");
		
		cat1.setQuantity("11");
		cat2.setQuantity("1");
		cat3.setQuantity("111");
		cat4.setQuantity("11");
		cat5.setQuantity("1");
		
		ArrayList<Item> lst = new ArrayList<>();
		lst.add(cat1);
		lst.add(cat2);
		lst.add(cat3);
		lst.add(cat4);
		lst.add(cat5);
		
		ord.setItems(lst);
		
		request.setAttribute("order", ord);
		
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String paymentEntry() throws Exception {
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}

	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry() throws Exception {
		return "HelloJSP";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:/purchase/viewOrder";
	}	

	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder() throws Exception {
		return "HelloJSP";
	}	

	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/viewConfirmation";
	}	

	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation() throws Exception {
		return "HelloJSP";
	}	

}