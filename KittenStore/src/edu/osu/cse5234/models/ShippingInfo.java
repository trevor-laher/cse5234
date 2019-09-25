package edu.osu.cse5234.models;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ShippingInfo
 */
@Stateless
@LocalBean
public class ShippingInfo {

	public String name;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String zip;
    
    public ShippingInfo() {
    }

}
