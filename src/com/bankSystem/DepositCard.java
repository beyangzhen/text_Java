package com.bankSystem;

import com.bankSystem.Account;

//储蓄卡类
public class DepositCard implements Account {
	private double balance; //账户余额
	private double interest; //利息
	
	public DepositCard(double money) {
		this.balance = money;
	}
	
	//存钱
	public double add(double money) {
		if(money >=100) {
			balance += money;
			
			return getBalance();
		} else {
			throw new MyException("还是留着自己花!");
		}
	}
	
	//取钱
	public double del(double money) {
		if(money <= balance){
			balance -= money; 
			
			return getBalance();
		} else {
			throw new RuntimeException("余额不足!!!!");
		}
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
}