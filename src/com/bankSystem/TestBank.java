package com.bankSystem;

import java.io.FileInputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestBank {
	public static void main(String[] args) throws Exception {
		Bank bank = Bank.getBankInstance();
		
		//读取配置文件的顾客信息
		Properties prop = new Properties();
		prop.load(new FileInputStream("customer.properties"));
		String name = prop.getProperty("name");
		String password = prop.getProperty("password");
		Customer customer = new Customer(name, password);
		
		//顾客账户
		Customer c = bank.addCustomer(customer);
		////////////////////储蓄卡////////////////////
		DepositCard depositCard = new DepositCard(50000);
		depositCard.setInterest(0.048);
		c.setDepositCard(depositCard);
		////////////////////信用卡/////////////////////
		BlueCard blueCard = new BlueCard(10000);
		c.setBlueCard(blueCard);
		
		//自动更新本金（利息）
		bank.update_Interest();
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setMinimumFractionDigits(4);
		while(true) {
			for(Customer cc : bank.customers) {
				if(null != cc.getDepositCard()) {
					DepositCard d = cc.getDepositCard();
					System.out.println("客户：" + cc.getName() + "\n储蓄卡账户余额：" + numberFormat.format(d.getBalance()));
				}
				if(null != cc.getBlueCard()) {
					BlueCard b = cc.getBlueCard();
					System.out.println("信用卡账户余额：" + numberFormat.format(b.getBalance()));
				}
			}
			
			Date date = new Date();
			SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = slf.format(date);
			System.out.println("--------" + time + "--------\n");
			Thread.sleep(2000);
		}
	}
}
