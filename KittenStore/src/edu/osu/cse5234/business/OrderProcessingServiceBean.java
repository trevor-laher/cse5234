package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;

import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.models.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	String confirmation = UUID.randomUUID().toString();
    	if (this.validateItemAvailability(order)) {
    		InventoryService invService = ServiceLocator.getInventoryService();
        	List<Item> invItems = invService.getAvailableInventory().getInventory();
        	List<Item> items = order.getItems();
        	int itemsSize = items.size();
        	boolean valid = true;
        	int i = 0;
        	
        	while(i < itemsSize && valid) {
        		Item currentItem = items.get(i);
        		int invIndex = invItems.indexOf(currentItem);
        		if(invIndex != -1) {
        			Item invItem = invItems.get(invIndex);
        			int invItemCount = Integer.parseInt(invItem.getQuantity());
        			int itemCount = Integer.parseInt(currentItem.getQuantity());
        			valid = itemCount <= invItemCount;
        			if(valid) { 
        				int newCount = invItemCount - itemCount;
        				invItem.setQuantity("" + newCount);
        			}
        		} else {
        			valid = false;
        		}
        		i += 1;
        	}
        	invService.updateInventory(invItems);
        	if(!valid) {
        		confirmation = "ERROR";
        	}
    	} else {
    		confirmation = "ERROR";
    	}
    	return confirmation;
    } 
    public boolean validateItemAvailability(Order order) {
    	InventoryService invService = ServiceLocator.getInventoryService();
    	List<Item> invItems = invService.getAvailableInventory().getInventory();
    	List<Item> items = order.getItems();
    	int itemsSize = items.size();
    	boolean valid = true;
    	int i = 0;
    	
    	while(i < itemsSize && valid) {
    		Item currentItem = items.get(i);
    		int invIndex = invItems.indexOf(currentItem);
    		if(invIndex != -1) {
    			Item invItem = invItems.get(invIndex);
    			valid = Integer.parseInt(currentItem.getQuantity()) <= Integer.parseInt(invItem.getQuantity());
    		} else {
    			valid = false;
    		}
    		i += 1;
    	}
    	return valid;
    }
}
