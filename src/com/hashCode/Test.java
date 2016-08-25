package com.hashCode;
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		set1.add("d");
		Set<String> set2 = new HashSet<String>();
		set2.add("d");
		System.out.println(set1.hashCode());
		System.out.println(set2.hashCode());
		System.out.println("--------------------");
		
		String s1 = new String("123");
		String s2 = new String("123");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println("--------------------");
		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		System.out.println("--------------------");
		
		StringBuffer sb1 = new StringBuffer("123");
		StringBuffer sb2 = new StringBuffer("123");
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());
		System.out.println("--------------------");
		
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
	}
	
}
