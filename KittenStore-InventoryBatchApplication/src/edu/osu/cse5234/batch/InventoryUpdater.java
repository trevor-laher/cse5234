package edu.osu.cse5234.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.sql.Array;

public class InventoryUpdater {
	
	public static void main(String[] args) {
		System.out.println("Starting Inventory Update ...");
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			udpateInventory(orderedItems, conn);udpateOrderStatus(newOrderIds, conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		return conn;
	}
	
	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = conn.createStatement().executeQuery("select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;}
	
	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds, Connection conn)  throws SQLException {
		// TODO Auto-generated method stub// This method returns a map of two integers. The first Integer is item ID, and                 
		// the second is cumulative requested quantity across all new orders;
		Map<Integer, Integer> itemMap = new HashMap<Integer, Integer>();
		int idSize = newOrderIds.size();
		if (idSize > 0){
			String query = "select CUSTOMER_ORDER_LINE_ITEM.item_number, CUSTOMER_ORDER_LINE_ITEM.quantity FROM CUSTOMER_ORDER INNER JOIN CUSTOMER_ORDER_LINE_ITEM ON CUSTOMER_ORDER_LINE_ITEM.customer_order_id_fk=CUSTOMER_ORDER.id AND (";
			int i = 0;
			for(Integer id : newOrderIds) {
				if(i > 0 && i<idSize-1) {
					query += " OR";
				}
				query += " CUSTOMER_ORDER.id=" + id;
				i += 1;
			}
			query += ")";
			ResultSet rset = conn.createStatement().executeQuery(query);
			
			ArrayList<Integer> itemNums = (ArrayList)rset.getArray("CUSTOMER_ORDER_LINE_ITEM.item_number");
			ArrayList<Integer> quantities = (ArrayList)rset.getArray("CUSTOMER_ORDER_LINE_ITEM.quantity");
			
			itemMap = createItemMap(itemNums, quantities);
		}
		return itemMap;
	}
	
	private static void udpateInventory(Map<Integer, Integer> orderedItems, Connection conn) throws SQLException {
		ResultSet rset = conn.createStatement().executeQuery("SELECT item_number, available_quantity FROM ITEM");
		ArrayList<Integer> itemNums = (ArrayList)rset.getArray("item_number");
		ArrayList<Integer> quantities = (ArrayList)rset.getArray("available_quantity");
		Map<Integer, Integer> itemMap = createItemMap(itemNums, quantities);
		for (Map.Entry<Integer, Integer> pair : orderedItems.entrySet()) {
			if(itemMap.containsKey(pair.getKey())) {
				itemMap.put(pair.getKey(), itemMap.get(pair.getKey()) - pair.getValue());
			}
		}
		int itemsSize = itemNums.size();
		for(int i=0;i<itemsSize;i++) {
			quantities.set(i, itemMap.get(itemNums.get(i)));
		}
		Object[] objectQuantities = quantities.toArray();
		Array sqlQuantities = conn.createArrayOf("INT", objectQuantities);
		rset.updateArray("available_quantity", sqlQuantities);
	}
	
	private static void udpateOrderStatus(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		String statement = "UPDATE CUSTOMER_ORDER SET STATUS='Processed' WHERE ";
		int count = 0;
		for(Integer id : newOrderIds) {
			if(count == 0) {
				statement += "WHERE id="+id;
			} else {
				statement += "OR id="+id;
			}
		}
		ResultSet rset = conn.createStatement().executeQuery(statement);
	}
	
	private static Map<Integer, Integer> createItemMap(ArrayList<Integer> itemNums, ArrayList<Integer> quantities) {
		Map<Integer, Integer> itemMap = new HashMap<Integer, Integer>();
		int itemsSize = itemNums.size();
		for(int i=0;i<itemsSize;i++) {
			int currentId = itemNums.get(i);
			int currentQuantity = itemNums.get(i);
			if(itemMap.containsKey(currentId)) {
				itemMap.put(currentId, itemMap.get(currentId) + currentQuantity);
			} else {
				itemMap.put(currentId, currentQuantity);
			}
		}
		return itemMap;
	}
}
