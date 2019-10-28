package edu.osu.cse5234.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryServiceRemote;
import edu.osu.cse5234.business.view.Item;
/**
 * Session Bean implementation class InventoryService
 */
@Stateless
public class InventoryService implements InventoryServiceRemote {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private String itemQuery = "select i from Item i";

    /**
     * Default constructor. 
     */
    public InventoryService() {
       // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		Inventory inv = new Inventory();
		List<Item> dbItems = entityManager.createQuery(itemQuery, Item.class).getResultList();
		for (Item item : dbItems) {
			inv.addItem(item);
		}
		return inv;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		int i = 0;
		boolean valid = true;
		int itemsLen = items.size();
		Inventory inv = this.getAvailableInventory();
		List<Item> invItems = inv.getInventory();
		
		while (i < itemsLen && valid) {
			valid = invItems.get(i).getAvailableQuantity() >= items.get(i).getAvailableQuantity();
			i += 1;
		}
		return valid;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		return true;
	}
}
