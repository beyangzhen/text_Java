package com.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理 和 面向切面编程
 * */
public class TestDynamicProxy {
	
	public static void main(String[] args) {
		// 1.实例化被代理类对象，供代理类构造器使用
		TrainStation t = new TrainStation();
		// 2.创建实现InvacationHandler接口的类的对象，再将被代理类对象赋进去
		DynamicProxy dp1 = new DynamicProxy(t);
		// 3.获取代理类对象
		Ticket proxyT = (Ticket)dp1.getObject();
		// 4.转为执行重写的invoke()方法(InvocationHandler接口的方法)
		proxyT.sailTicket();
		System.out.println("-------------------------------");
		Bank b = new Bank();
		DynamicProxy dp2 = new DynamicProxy(b);
		Money proxyM = (Money)dp2.getObject();
		proxyM.save();
	}
}

interface Ticket {
	void sailTicket();
}

//被代理类1
class TrainStation implements Ticket {
	@Override
	public void sailTicket() {
		System.out.println("火车站售票大厅正在售票...");
	}
}

interface Money {
	void save();
}

//被代理类2
class Bank implements Money {
	@Override
	public void save() {
		System.out.println("银行存储中...");
	}
}

//动态代理类 (可以创建动态代理类对象的类，并不是真正的代理类)
class DynamicProxy implements InvocationHandler {
	//被代理类对象声明
	Object obj;
	
	//用外部已经创建的被代理类对象来实例化此被代理对象
	public DynamicProxy(Object obj) {
		this.obj = obj;
	}
	
	//产生代理类对象
	public Object getObject() {
		//生成的动态代理对象并不是InvocationHandler类型
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	//代理类对象调用被代理类的方法时，都会执行调用重写的invoke()方法(InvocationHandler接口的方法)
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//在代理真实对象前添加自己的操作 (面向切面编程，将不同模块中 "相同功能" 提取出来写这里)
        System.out.println("调用之前");
        
		Object returnValue = method.invoke(obj, args); //(面向切面编程，将不同模块中 "不同功能" 使用动态代理实现)
		
	    //在代理真实对象后添加自己的操作 (面向切面编程，将不同模块中 "相同功能" 提取出来写这里)
        System.out.println("调用之后");
		
		return returnValue;
	}
}