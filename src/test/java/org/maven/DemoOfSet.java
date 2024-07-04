package org.maven;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DemoOfSet {
	
	public void setTest() {
		
		Set<String> strSet=new HashSet<>();
		strSet.add("John");
		strSet.add("Ram");
		strSet.add("Srinivas");
		strSet.add("Raj");
		strSet.add("Srinivas");
		
		for(String str:strSet) {
			System.out.println(str);
		}
		System.out.println("--------------------");
		Set<Integer> treeSet=new TreeSet<>();
		treeSet.add(5);
		treeSet.add(6);
		treeSet.add(1);
		treeSet.add(5);
		treeSet.add(4);
		
		Iterator<Integer> itr=treeSet.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("--------------------");
		Set<Object> objSet=new HashSet<>();
		objSet.add("John");
		objSet.add("Ram");
		objSet.add("Srinivas");
		objSet.add(5);
		objSet.add(4);
		
		for(Object obj:objSet) {
			System.out.println(obj);
		}
		System.out.println("--------------------");
		
		Set<Object> objTreeSet=new TreeSet<>();
		objTreeSet.add("John");
		objTreeSet.add("Ram");
		objTreeSet.add("Srinivas");
		objTreeSet.add(5);
		objTreeSet.add(4);
		
		for(Object obj:objTreeSet) {
			System.out.println(obj);
		}
		System.out.println("--------------------");
	}

	public static void main(String[] args) {
		DemoOfSet demoOfSet=new DemoOfSet();
		demoOfSet.setTest();
	}
}
