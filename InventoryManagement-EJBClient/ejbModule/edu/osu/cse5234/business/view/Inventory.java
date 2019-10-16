package edu.osu.cse5234.business.view;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * Session Bean implementation class Inventory
 */
public class Inventory implements Serializable {

	List<Item> inventory;
    /**
     * Default constructor. 
     */
	
    public Inventory() {
    	inventory = new ArrayList<Item>(); 
    }
    public List<Item> getInventory() {
    	return this.inventory;
    }
    public void addItem(Item item) {
    	this.inventory.add(item);
    }

}
