package edu.osu.cse5234.business;

import java.util.List;

import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryServiceRemote;
import edu.osu.cse5234.business.view.Item;
/**
 * Session Bean implementation class InventoryService
 */
@Stateless
public class InventoryService implements InventoryServiceRemote {

    /**
     * Default constructor. 
     */
    public InventoryService() {
       // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		Inventory inv = new Inventory();
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
		
		inv.addItem(cat1);
		inv.addItem(cat2);
		inv.addItem(cat3);
		inv.addItem(cat4);
		inv.addItem(cat5);
		
		return inv;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		return true;
	}
}
