package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Item
 */
@Stateless
@LocalBean
public class Item {
	
	private String name;
	private String price;
	private String quantity;
	
	/**
     * Default constructor. 
     */
    public Item() {
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
