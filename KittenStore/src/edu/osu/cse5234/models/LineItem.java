package edu.osu.cse5234.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="CUSTOMER_ORDER_LINE_ITEM")
public class LineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID")
	private int id;
	
	@Column (name="ITEM_ID")
	private int itemNumber;
	
	@Column (name="ITEM_NAME")
	private String itemName;
	
	//NOTE THAT THIS MY NOT BE A NECESSARY VAR FOR THE CLASS
	@Transient
	private double price;
	
	@Transient
	private String description;
	
	@Column (name="QUANTITY")
	private int quantity;

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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
