package com.chen.queue;
/**
 * 
 * <b>顺序队列<b>
 * @author 威 
 * <br>2017年10月20日 下午12:18:51 
 * 
 * @param <E>
 */
public class SeqQueue<E> implements Queue<E> {
	/** 完成队列事务的数组 */
	private Object elements[];
	/** front 指向队列的头结点 */
	private int front;
	/** rear  指向队列的尾结点 */
	private int rear;
	
	public SeqQueue(){
		this(64);							
	}
	
	public SeqQueue(int length){
		/*确定容量可以有效提高性能*/
		if(length < 64)
			length = 64;					
		elements = new Object[length];
		front = rear = 0;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}

	/**
	 * 只能在尾添加
	 * <pre>
	 * 	1、空队列情况下添加
	 * 	2、非空队列情况下添加
	 * </pre>
	 */
	public boolean add(E e) {
		if(e == null)
			return false;
		
		/*判断队列是否超过原来的容量--扩充数组*/
		if(this.rear+1-this.front > this.elements.length) {
			Object[] temp = this.elements;
			this.elements = new Object[temp.length*2];
			/* 将原来的数组数据拷贝到扩展的数组中 */
//			并且从零开始拷贝，减轻假溢出
			for(int i = 0; i < this.rear-this.front; i++)
				this.elements[i] = temp[i+this.front];
			this.rear = this.rear-this.front;
			this.front = 0;
		}
		elements[rear] = e; 
		this.rear++;
		return true;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = this.front; i < this.rear; i++)
			sb.append(elements[i]+",");
		if(this.rear > this.front) sb.deleteCharAt(sb.length()-1);
		return sb.append("]").toString();
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		return (E) (isEmpty() ? null : this.elements[this.front]);
	}

	@SuppressWarnings("unchecked")
	public E poll() {
		if(isEmpty())
			return null;
		E e = (E) this.elements[this.front];
		// 弹出的时候实际是没有起始下标往后移了，最后就是可能造成假的溢出，因为front前面是空闲的
		this.front++;
		return e;
	}
	
	public static void main(String[] args){
		System.out.println(55%10);
		SeqQueue<Integer> q = new SeqQueue<Integer>(3);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		q.add(11);
		System.out.println(q.toString());
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.toString());
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.toString());
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.toString());
	}

}
