package edu.osu.cse5234.business.view;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Comparator;

@Entity
@Table (name="ITEM")
public class Item implements Comparator, Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID")
	private int id;
	
	@Column (name="ITEM_NUMBER")
	private int itemNumber;
	
	@Column (name="NAME")
	private String name;
	
	@Column (name="DESCRIPTION")
	private String description;
	
	@Column (name="AVAILABLE_QUANTITY")
	private int availableQuantity;
	
	@Column (name="UNIT_PRICE")
	private double unitPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

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
}
