package edu.osu.cse5234.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.InventoryServiceRemote;
public class ServiceLocator {

	public static OrderProcessingServiceBean getOrderProcessingService() {
		try {
	         return (OrderProcessingServiceBean) InitialContext.doLookup(
					"java:module/OrderProcessingServiceBean!edu.osu.cse5234.business.OrderProcessingServiceBean");
		} catch (NamingException ne) {
				throw new RuntimeException(ne);
		}
	}
	
	public static InventoryServiceRemote getInventoryService() {
		try {
			return (InventoryServiceRemote) InitialContext.doLookup(
	        		 "java:global/InventoryManagement-EJBEAR/InventoryManagement-EJB/InventoryService!edu.osu.cse5234.business.view.InventoryServiceRemote");
		} catch (NamingException ne) {
				throw new RuntimeException(ne);
		}

	}
	
}

	
