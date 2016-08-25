package com.bankSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//银行类
public class Bank {
	public List<Customer> customers; //存放客户的信息
	public int customer_count; //记录客户的数量
	
	//银行只有一个
	private static Bank bank = new Bank();
	
	private Bank() {
		customers = new ArrayList<>();
	}
	
	//获取Bank类的单例
	public static Bank getBankInstance() {
		return bank;
	}
	
	//更新账户的余额
	public boolean update_Interest() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				for(Customer c : customers) {
					if(c!=null && c.getDepositCard()!=null && c.getDepositCard().getBalance()>0) {
						DepositCard d = c.getDepositCard();
						double balance = d.getBalance();
						//一个月的利息
						double rate = balance * d.getInterest(); 
						d.setBalance(balance + rate);
					}
				}
			}
		}, new Date(), 2000);   
		
		return true;
	}

	//给顾客开户
	public Customer addCustomer(Customer customer) {
		customers.add(customer);
		
		return customer;
	}

	//查找客户信息
	public  Customer getCustomer(String name, String password) {
		for(Customer c : customers) {
			if(c == null) {
				continue;
			} else {
				String cName = c.getName();
				String cPassword = c.getPassword();
				if(name.equals(cName) && password.equals(cPassword)) {
					return c;
				}
			}
		}
		
		return null;
	}
	
	// 修改客户信息
	public boolean updateCustomer(String name, String oldPassword, String newPassWord) {
		//先查找客户
		Customer  c = this.getCustomer(name, oldPassword);
		if(c == null) {
			throw new MyException("不存在此账户。。。");
		} else {
			c.setPassword(newPassWord);
			
			return true;
		}
	}
	
	// 获取当前客户数量
	public int get_CustomerCount() {
		return customers.size();
	}
	
}