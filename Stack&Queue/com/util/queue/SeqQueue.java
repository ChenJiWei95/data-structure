package com.util.queue;
/**
 * 
 * <b>顺序队列<b>
 * @author 威 
 * <br>2017年10月20日 下午12:18:51 
 * 
 * @param <E>
 */
public class SeqQueue<E> implements Queue<E> {
	/**
	 * 完成队列事务的数组
	 */
	private Object Elements[] ;
	
	/**
	 * front 	指向队列的头结点 <br>
	 * rear		指向队列的尾结点
	 */
	private int front, rear ;
	
	public SeqQueue(){
		this(64) ;							
	}
	
	public SeqQueue(int length){
		if(length < 64)
			length = 64 ;					/*能确定容量可以有效提高性能*/
		Elements = new Object[length] ;
		front = rear = 0 ;
	}
	
	public boolean isEmpty() {
		return rear == 0 ;
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
			return false ;
		
		/*判断队列是否超过原来的容量--扩充数组*/
		if(this.front == (this.rear+1)%this.Elements.length) {
			Object[] temp = this.Elements ;
			this.Elements = new Object[temp.length*2] ;
			int j = 0 ;
			for(int i = this.front; i < this.rear; i = (i+1)%temp.length ){
				this.Elements[j++] = temp[i] ;  /*将原来的数组数据复制到扩展的数组中*/
			}
			this.front = 0 ;
			this.rear = j ;
		}
		
		Elements[rear] = e ; 
		this.rear = (this.rear+1)%this.Elements.length ;
		return true ;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		return (E) (isEmpty() ? null : this.Elements[this.front]) ;
	}

	@SuppressWarnings("unchecked")
	public E poll() {
		if(isEmpty())
			return null ;
		E e = (E) this.Elements[this.front] ;
		this.front = (this.front+1)%this.Elements.length ;
		return e ;
	}

}
