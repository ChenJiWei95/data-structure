package com.util.LinkedStorage;
/**
 * <b>双链表 数据类</b>
 * @author 威 
 * <br>2018年4月26日 下午6:54:56 
 * @see
 * @since 1.0
 * @param <T>
 */
public class DoubleNode<T> {
	public T data;
	public DoubleNode<T> prev,next;
	
	public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public DoubleNode(T data){
		this(data, null, null);
	}
	
	public DoubleNode(){
		this(null, null, null);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("DoubleNode=[");
		sb.append(data).append(",").append(prev).append(",").append(next);
		return sb.append("]").toString();
	}
}
