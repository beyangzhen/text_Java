package com.singleton;

public class Singleton {	
	/*饿汉式，线程安全的*/
	//static使一个类只有一个对象
	private static Singleton singleton = new Singleton();
		
	private Singleton() {
	}
		
	public static Singleton getInstance() {
		return singleton;
	}
	
	/*
	懒汉式
	private static Singleton singleton = null;
	private static Object obj = new Object();
			
	private Singleton() {
	}
			
	public static Singleton getInstance() {
		if(singleton == null) {
			synchronized(obj) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}
	*/
}
