package com.treeSet;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		Set set = new TreeSet();
		//set.add(null);
		//set.add("123");
		set.add(new Person("a", "b"));
		set.add(new Person("a", "c"));
		set.add(new Person("b", "c"));
		set.add(new Person("b", "c"));
		for(Object o : set) {
			System.out.println(o);
		}
	}
}
