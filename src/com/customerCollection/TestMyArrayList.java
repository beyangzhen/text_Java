package com.customerCollection;

public class TestMyArrayList {
	public static void main(String[] args) {
		MyArrayList mal = new MyArrayList();
		mal.add('a');
		mal.add('b');
		mal.add('c');
		mal.add('d');
		mal.add('e');
		mal.remove(3);
		System.out.println("容器中当前元素个数为：" + mal.size());
		System.out.println("分别为：");
		for(int i=0; i<mal.size(); i++) {
			System.out.print(mal.get(i) + ",");
		}
	}
}
