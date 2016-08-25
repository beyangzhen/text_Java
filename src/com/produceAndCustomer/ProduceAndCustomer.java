package com.produceAndCustomer;

class Clerk {
    int number = 20;
	
	//生产的方法
	//wait()和notify()是成对出现在同步代码块
	public synchronized void addProduct() { //对Clerk来说还是同一个对象，有同步功能
		if(number >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName()+"：生产第"+(number+1)+"个产品");
			number ++;
			notifyAll(); //唤醒执行了wait()的消费者线程(唤醒对方线程)
		}
	}
	
	//销售的方法
	public synchronized void sailProduct() { //对Clerk来说还是同一个对象，有同步功能
		if(number <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName()+"：销售第"+number+"个产品");
			number --;
			notifyAll(); //唤醒执行了wait()的生产者线程(唤醒对方线程)
		}
	}
}

//生产者类
class Produce implements Runnable {
	Clerk clerk;
	
	public Produce(Clerk clerk) {
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.addProduct();
		}
	}
}

//消费者类
class Customer implements Runnable {
	Clerk clerk;
	
	public Customer(Clerk  clerk) {
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.sailProduct();
		}
	}
}

public class ProduceAndCustomer {
	public static void main(String[] args) {	
		Clerk clerk = new Clerk();
		
		Produce p = new Produce(clerk);
		Thread produce = new Thread(p);
		produce.setName("生产者");
		produce.start();
		
		Customer c = new Customer(clerk);
		Thread cus = new Thread(c);
		cus.setName("消费者");
		cus.start();
	}
}