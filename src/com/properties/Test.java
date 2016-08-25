package com.properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws IOException{
		Properties p = new Properties();
		File file = new File("test.properties"); //将"test.properties"放入File类的对象中
		FileInputStream f = new FileInputStream(file);
		p.load(f);
		System.out.println("username:" + p.getProperty("username"));
		System.out.println("password:" + p.getProperty("password"));
	}
}
