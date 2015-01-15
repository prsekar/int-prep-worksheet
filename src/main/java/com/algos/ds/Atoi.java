package com.algos.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Atoi {
	public static void main(String[] rags) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a",1);
		map.put("b",2);
		map.put("c",9);
		map.put("d",10);
		map.put("e",2);
		map.put("f",4);
		
		Set<Entry<String, Integer>> mapEntry = map.entrySet();
		List<Entry<String, Integer>> listEntry = new ArrayList<Map.Entry<String,Integer>>(mapEntry);
		Collections.sort(listEntry, new MapEntryCmp());
		for (Entry<String, Integer> entry : listEntry  ) {
			System.out.println(entry.getKey()+ " " + entry.getValue());
		}
	}
}

class MapEntryCmp implements Comparator<Entry<String, Integer>> {

	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		if (o1.getValue() < o2.getValue()) {
			return -1;	
		}
		else if (o1.getValue() > o2.getValue()) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

	
}