package com.bankSystem;

//信用卡类
public class BlueCard implements Account{
	private double balance; //账户余额
	private double quota; //信用卡的额度
	
	public BlueCard(double money) {
		this.balance = money;
	}
	
	//存钱
	public double add(double money) {
		if(money >=100) {
			setBalance(balance + money );
			return getBalance();
		} else {
			throw new MyException("还是留着自己花!");
		}
	}
	
	//取钱
	public double del(double  m){
		/**
		 * 自己存款 + 银行信用额度
		 * */
		if(m <= balance) {
			//取自己存款
			balance -= m;
			
			return (this.quota + balance - m);
		} else if(m <= (balance + this.quota)) {
			//取钱金额大于自己存款
			this.setQuota(this.quota - (m - balance));
			balance = 0;
			
			return (this.quota + balance - m);
		} else {
			throw new MyException("超过额度!!!!");
//			throw new RuntimeException("超过额度!!!!");
		}
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getQuota() {
		return quota;
	}
	public void setQuota(double quota) {
		this.quota = quota;
	}
}