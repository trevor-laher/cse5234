package edu.osu.cse5234.models;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PaymentInfo
 */
@Stateless
@LocalBean
public class PaymentInfo {

	private String ccNumber;
	private String expiration;
	private String cvvCode;
	private String cardName;
    /**
     * Default constructor. 
     */
    public PaymentInfo() {
    }

}
