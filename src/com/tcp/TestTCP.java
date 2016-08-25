package com.tcp;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;
// 客户端发送消息到服务端，服务端要返回一个消息到客户端，通知消息已收到
public class TestTCP {
	
	//服务端
	@Test
	public void service() throws Exception {
		//1. 服务端创建监听
		ServerSocket server = new ServerSocket(9999); //通过netstat -ano命令,查本地所有使用的端口号
		//2.等待客户连接,监听到客户端来访问时创建一个Socket
		Socket socket = server.accept();
		//3.接收客户端发送过来的消息
		InputStream is = socket.getInputStream();
		int len = 0;
		byte[] b = new byte[10];
		while((len=is.read(b)) != -1) {
			System.out.println(new String(b, 0, len));
		}
		//4.回发消息到客户端
		OutputStream os = socket.getOutputStream();
		os.write("已收到".getBytes());
		os.close();
		is.close();
		socket.close();
		server.close();
	}
	
	//客户端
	@Test
	public void client() throws Exception {
		//1. 客户端来找服务端
		Socket socket = new Socket(InetAddress.getByName("localhost"),9999);
		//2. 发送消息
		OutputStream os = socket.getOutputStream();
		os.write("我是客户端".getBytes());
		//3.通知服务端消息发送完毕
		socket.shutdownOutput();
		//4. 接收服务端发送的消息
		InputStream is = socket.getInputStream();
		int len = 0;
		byte[] b = new byte[10];
		while(-1 != (len=is.read(b))) {
			System.out.println(new String(b, 0, len));
		}
		os.close();
		socket.close();
	}
}