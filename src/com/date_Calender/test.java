package com.date_Calender;
import java.util.Calendar;
import java.util.Date;

public class test {
	public static void main(String[] args) {
		
		  Calendar cal = Calendar.getInstance();    
	//方式一
		  Date date = new Date(); 
		  cal.setTime(date); 
		  System.out.println(cal.get(Calendar.YEAR));
		  System.out.println(cal.get(Calendar.MONTH) + 1);// 月份计算是从0作为1开始的。
		  System.out.println(cal.get(Calendar.DATE));
		  System.out.println(cal.get(Calendar.HOUR));
		  System.out.println(cal.get(Calendar.MINUTE));
		  System.out.println(cal.get(Calendar.SECOND));
    //方式二
		  cal.set(2016, 6, 31);
		  System.out.println(cal.get(Calendar.YEAR));
		  System.out.println(cal.get(Calendar.MONTH) + 1);// 月份计算是从0作为1开始的。
		  System.out.println(cal.get(Calendar.DATE));
		  System.out.println(cal.get(Calendar.HOUR));
		  System.out.println(cal.get(Calendar.MINUTE));
		  System.out.println(cal.get(Calendar.SECOND));
	}
}
