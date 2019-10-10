package edu.osu.cse5234.business.view;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface InventoryServiceRemote {
	
	public Inventory getAvailableInventory();
    public boolean validateQuantity(List<Item> items);
    public boolean updateInventory(List<Item> items);

}
