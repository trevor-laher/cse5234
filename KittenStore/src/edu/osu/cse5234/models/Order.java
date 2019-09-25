package edu.osu.cse5234.models;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 * Session Bean implementation class Order
 */
@Stateless
@LocalBean
public class Order {
	
	private ArrayList<Item> items;

    /**
     * Default constructor. 
     */
    public Order() {
        this.items = new ArrayList<Item>();
    }

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
