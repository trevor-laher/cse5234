package edu.osu.cse5234.business;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.resource.cci.ConnectionFactory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import edu.osu.cse5234.business.view.InventoryServiceRemote;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.models.LineItem;
import edu.osu.cse5234.models.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	@PersistenceContext
	EntityManager entityManager;
	
	
    public OrderProcessingServiceBean() {
    }
        
    public String processOrder(Order order){
    	String confirmation = UUID.randomUUID().toString();
    	if (this.validateItemAvailability(order)) {
    		InventoryServiceRemote invService = ServiceLocator.getInventoryService();
        	List<Item> invItems = invService.getAvailableInventory().getInventory();
        	List<LineItem> items = order.getLineItems();
        	int itemsSize = items.size();
        	boolean valid = true;
        	int i = 0;
        	
        	while(i < itemsSize && valid) {
        		LineItem currentItem = items.get(i);
        		int invIndex = invItems.indexOf(currentItem);
        		if(invIndex != -1) {
        			Item invItem = invItems.get(invIndex);
        			int invItemCount = invItem.getAvailableQuantity();
        			int itemCount = currentItem.getQuantity();
        			valid = itemCount <= invItemCount;
        			if(valid) { 
        				int newCount = invItemCount - itemCount;
        				invItem.setAvailableQuantity(newCount);
        			}
        		} else {
        			valid = false;
        		}
        		i += 1;
        	}
        	invService.updateInventory(invItems);
        	//Add criteria to determine valid payment in another service
        	boolean validPayment = true;
        	if (validPayment && valid) {
        		order.getPayment().setConfirmationNumber(confirmation);
        		entityManager.persist(order);
            	entityManager.flush();
        	}
        	if(!valid | !validPayment) {
        		confirmation = "ERROR";
        	}
    	} else {
    		confirmation = "ERROR";
    	}
    	return confirmation;
    } 
    public boolean validateItemAvailability(Order order) {
    	InventoryServiceRemote invService = ServiceLocator.getInventoryService();
    	List<Item> invItems = invService.getAvailableInventory().getInventory();
    	List<LineItem> items = order.getLineItems();
    	int itemsSize = items.size();
    	boolean valid = true;
    	int i = 0;
    	
    	while(i < itemsSize && valid) {
    		LineItem currentItem = items.get(i);
    		Item invItem = invItems.get(i);
    		valid = currentItem.getQuantity() <= invItem.getAvailableQuantity();
    		i += 1;
    	}
    	return valid;
    }
}
