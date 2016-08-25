package com.bankSystem;

//相对于银行来说，我们是客户
public class Customer {
	private String name;
	private String password;
	private BlueCard blueCard;
	private DepositCard depositCard;
	
	public Customer(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BlueCard getBlueCard() {
		return blueCard;
	}
	public void setBlueCard(BlueCard blueCard) {
		this.blueCard = blueCard;
	}
	public DepositCard getDepositCard() {
		return depositCard;
	}
	public void setDepositCard(DepositCard depositCard) {
		this.depositCard = depositCard;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + "]";
	}
	
}