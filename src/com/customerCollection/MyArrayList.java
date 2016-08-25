package com.customerCollection;
import java.util.Arrays;

public class MyArrayList {
	
	private int count = 0; //当前容器中元素个数
	private int maxSize = 10; //容器最大容量
	private Object[] array = new Object[maxSize];
	private Object[] arrayTemp = null;
	//List list = new ArrayList();
	
	public void add(Object o) {
		array[count] = o;
		count ++;
		if(count >= array.length) {
			maxSize *= 2;
			arrayTemp = Arrays.copyOf(array, maxSize);
			array = arrayTemp;
		}
	}
	
	public Object get(int index) {
		if(index >= count) {
			throw new RuntimeException("The index:" + index + " is out of band."); 
		}
		
		return array[index];
	}
	
	public void remove(int index) {
		if(index >= count) {
			throw new RuntimeException("The index:" + index + " is out of band."); 
		}
		//移除位置之后每位元素前移一位
		for(int i=index; i<maxSize-1; i++) {
			array[i] = array[i+1];
		}
		//最后一位元素置空
		array[maxSize-1] = null;
		//整个数组长度减 1
		maxSize --;
		count --;
	}
	
	public int size() {
		return count;
	}
}
