package com.treeSet;
public class Person implements Comparable{
	private String name;
	private String number;
	
	public Person(String name, String number) {
		this.name = name;
		this.number = number;
	}

	//相当于hashSet中的equals()
	@Override
	public int compareTo(Object o) {
		if(o instanceof Person) {
			Person c = (Person)o; //为了没传递参数时，在里面能使用Person类的成员(Object不能调用name和number)
			int i = this.name.compareTo(c.name); //表示比较name，按从小到大排列
			if(i == 0) {
				return this.number.compareTo(c.number); //再比较number，按从小到大排列
			} else {
				return i;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", number=" + number + "]";
	}
}