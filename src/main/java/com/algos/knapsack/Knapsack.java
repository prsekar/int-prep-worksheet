package com.algos.knapsack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Knapsack {
	static HashMap<String, LinkedList<String>> itemsInRestaurents = new
			HashMap<String, LinkedList<String>>();
	static HashMap<String, HashMap<String, Double>>
		menuByRestaurent = new HashMap<String, HashMap<String, Double>>();

	public void insertToCache(String item, String rest) {
		LinkedList<String> list = null;
		if (itemsInRestaurents.containsKey(item)){
			list = itemsInRestaurents.get(item);
		} else {
			list = new LinkedList<String>();			
		}
		list.add(rest);
		itemsInRestaurents.put(item, list);
	}
	public void index(String filename) {
		try {
			String filepath = Knapsack.class.getClassLoader()
					.getResource(filename).getPath();
			BufferedReader bReader = new BufferedReader(new FileReader(
					new File(filepath)));
			String line = null;
			while ((line = bReader.readLine()) != null) {
				System.out.println(line);
				String[] data = line.split(",");
				Double price = new Double(data[1].trim()).doubleValue();
				String restId = data[0].trim();
				if (data.length > 3) {
					for (int i=2 ; i > data.length-1; i++) {
						insertToCache(data[i].trim(), restId);											
					}
				}
				HashMap<String, Double> menuItems = new HashMap<String, Double>();
				if (menuByRestaurent.containsKey(restId)) {
					menuItems = menuByRestaurent.get(restId);
				} else {
					menuItems = new HashMap<String, Double>();
				}
				menuItems.put(data[1].trim(), price);
				menuByRestaurent.put(data[0].trim(), menuItems);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double totalDinnerPrice(String restaurent, String[] dinnerPlan) {
		double totalPrice = -0.0;
		boolean sendFail = false;
		HashMap<String, Double> menu = menuByRestaurent.get(restaurent);
		for (String item : dinnerPlan) {
			if (menu.containsKey(item)){
				totalPrice += menu.get(item);
			}
			else {
				sendFail = true;
				break;
			}
		}
		if (sendFail) {
			//only when atleast one of the items not available
			return -0.0;
		} else {
			return totalPrice;
		}
	}
	private void printArray(String[] arr) {
		for (String s : arr) {
			System.out.print(s +" ");
		}
		System.out.println();
	}
	public void search(String[] dinnerplan) {
		double optimalPrice = 0.0;
		String optimalRest = null;
		printArray(dinnerplan);
		String searchRef = searchPlan(dinnerplan);
		if (searchRef != null) {
			LinkedList<String> list = itemsInRestaurents.get(searchRef);
			for (String restaurent : list) {
				double tp = totalDinnerPrice(restaurent, dinnerplan);
				if (tp != -0.0) {
					if (optimalPrice == 0.0 || optimalPrice > tp) {
						optimalPrice = tp;
						optimalRest = restaurent;	
					} else {
						// no op
					}
				}
			}
			System.out.println("Optimal price : " + optimalPrice + " rest : " + optimalRest );			
		}
		else {
			
		}
		
	}
	public String searchPlan(String[] dinnerplan) {
		String searchRef = null;
		int size = 0;
		for (String item : dinnerplan) {
			if (itemsInRestaurents.containsKey(item)) {
				// find the item which is least available in all rest.
				if (itemsInRestaurents.get(item).size() > size) {
					searchRef = item;
				}
				else {
					// go for next
					// no op
				}
			}
			else {
				System.out.println("Item " + item + " does not exist in this town. No dinner for u :)");
				//System.exit(0);
			}
		}
		System.out.println(" search plan returns " + searchRef);
		return searchRef;
		
	}
	public static void main(String[] args) {
		Knapsack knapsack = new Knapsack();
		knapsack.index("dataset.txt");
		knapsack.search(new String[] {"tofu_log"});
		knapsack.search(new String[] {"burger"});
		knapsack.search(new String[] {"burger1"});
		knapsack.search(new String[] {"tofu_log", "burger"});
	}

}

class Item {
	String id;
	Double price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}