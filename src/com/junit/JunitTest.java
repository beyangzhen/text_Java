package com.junit;

import org.junit.Ignore;
import org.junit.Test;


public class JunitTest {
	
	@Test
	public void Test1() {
		int a = 10;
		int b = 20;
		System.out.println(a + b);
	}
	
	@Test
	public void Test2() {
		int a = 20;
		int b = 30;
		System.out.println(a + b);
	}
	
	@Ignore //不参与junit单元测试
	public void Test3() {
		int a = 30;
		int b = 40;
		System.out.println(a + b);
	}
}
