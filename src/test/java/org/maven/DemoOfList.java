package org.maven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DemoOfList {
	
	public void listTest() {
		
		List<String> strList=new ArrayList<>();
		strList.add("John");
		strList.add("Ram");
		strList.add("Srinivas");
		strList.add("Raj");
		strList.add("Srinivas");
		
		System.out.println(strList.get(1));
		System.out.println(strList.get(4));
		System.out.println(strList.size());
		System.out.println("--------------------");
		strList.set(3, "Hari");
		
		for(String str:strList) {
			System.out.println(str);
		}
		
		System.out.println("--------------------");
		Collections.sort(strList);
		
		for(String str:strList) {
			System.out.println(str);
		}
		
		System.out.println("--------------------");
		
		Iterator<String> itr=strList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("--------------------");
	}

	public static void main(String[] args) {
		DemoOfList demoOfList=new DemoOfList();
		demoOfList.listTest();

	}
}
