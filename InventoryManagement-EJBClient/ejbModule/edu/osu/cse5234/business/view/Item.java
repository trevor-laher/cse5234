package edu.osu.cse5234.business.view;

import java.io.Serializable;
import javax.ejb.Stateless;
import java.util.Comparator;

public class Item implements Comparator, Serializable{
	
	private String name;
	private String price;
	private String quantity;
	
	/**
     * Default constructor. 
     */
    public Item() {
    }
    
    public int compare(Object item1, Object item2) {
    	return 1;
    }
    
    public int equals(Item item1) {
    	if(this.getName().equals(item1.getName())) {
    		return 0;
    		}
    	else {
    			return 1;
    		}
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
