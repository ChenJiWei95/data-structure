package com.util.stack;

import java.util.LinkedList;
/**
 * 
 * <b>通过LinkedList实现栈 - 扩展<b>
 * @author 威 
 * <br>2017年9月30日 下午8:44:01 
 * 
 * @param <E>
 * 
 */
public class LinkedStackEX<E> implements Stack<E>{
	private LinkedList<E> ll ; 
	
	public LinkedStackEX(){
		ll = new LinkedList<E>() ;
	}
	
	public boolean isEmpty() {
		return ll.isEmpty() ;
	}

	public boolean push(E e) {
		return ll.add(e) ;
	}

	public E peek() {
		return ll.getFirst() ;
	}

	public E pop() {
		return ll.removeFirst() ;
	}

}
