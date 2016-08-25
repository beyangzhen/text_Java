package com.udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

public class TestUDP {
	
	//发送方
	@Test
	public void sender() throws Exception {
		 // 用来发送和接收数据报包的套接字
		 DatagramSocket ds = new DatagramSocket();
		 byte[] b = "约么?".getBytes();
		 // 数据报包。 每个数据报的大小限制在64K内
		 DatagramPacket pack = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 9999);
		 // 发送数据报包
		 ds.send(pack);
		 ds.close();
	}
	
	//接收方
	@Test
	public void revice() throws Exception {
		DatagramSocket ds = new DatagramSocket(9999);
		byte[] b = new byte[10];
		DatagramPacket pack = new DatagramPacket(b,b.length);
		//接收数据报包
		ds.receive(pack);
		String str = new String(pack.getData(), 0, pack.getLength());
		System.out.println(str);
		ds.close();
	}
}