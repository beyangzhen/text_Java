package com.singleton;

public class TestSingleton {
	
	public static void main(String[] args) {
		//构造器私有化了，外部就不能直接new对象
		//Singleton singleton = new Singleton(); //会报错
		
		//singleton1和singleton2是同一个对象
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
	}

}
