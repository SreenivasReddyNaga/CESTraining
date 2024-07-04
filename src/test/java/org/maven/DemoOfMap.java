package org.maven;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DemoOfMap {

	public void testHashMap() {

		Map<Object, Object> empData = new HashMap<>();

		empData.put(123, "Ram");
		empData.put(234, "Saritha");
		empData.put(456, "Aman");
		empData.put(345, 2345);
		empData.put(789, "Rama");
		empData.put(567, "Leela");
		empData.put("dvhb", "Neha");
		empData.put(765, "Neha");
		empData.put(null, "NullKey");
		empData.put(null, "NullKey2");
		empData.put(null, null);
		empData.put(235, null);

		System.out.println("Map value " + empData.get(345));

		for (Map.Entry<Object, Object> mData : empData.entrySet()) {
			System.out.println(mData.getKey() + " " + mData.getValue());
		}
	}

	public void testTreeMap() {

		Map<Integer, String> empData = new TreeMap<>();

		empData.put(123, "Ram");
		empData.put(234, "Saritha");
		empData.put(456, "Aman");
		empData.put(345, "Lavanya");
		empData.put(789, "Rama");
		empData.put(567, "Leela");
		empData.put(765, "Neha");
		empData.put(765, "Neha");
		/*
		 * empData.put(null, "NullKey"); empData.put(null, "NullKey2");
		 * empData.put(null, null);
		 */
		empData.put(235, null);
		empData.put(546, null);

		System.out.println("Map value " + empData.get(345));

		for (Map.Entry<Integer, String> mData : empData.entrySet()) {
			System.out.println(mData.getKey() + " " + mData.getValue());
		}

	}

	public static void main(String[] args) {
		DemoOfMap demoOfMap = new DemoOfMap();
		demoOfMap.testHashMap();
		
		demoOfMap.testTreeMap();
	}
}
