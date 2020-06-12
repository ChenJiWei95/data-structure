package com.chen.queue;
/**
 * 
 * <b>链式队列<b>
 * @author 威 
 * <br>2017年10月1日 上午10:59:56 
 * 
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E> {
	/**
	 * front	指向队列头结点 <br>
	 * rear		指向队列尾结点
	 */
	Node<E> front, rear ;
	public LinkedQueue(){
		this.rear = this.front = null ;
	}
	public boolean isEmpty() {
		return rear == null && front == null ;
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
		Node<E> q = new Node<E>(e, null) ;  /*添加的新节点*/
		if(front == null)					
			this.front = q ; 				/*当前为空队列时将新节点添加到指向头结点的front*/
		else 
			this.rear.next = q ;			/*当队列不为空时，将旧尾结点与新尾节点连接*/
		this.rear = q ;						/*将新节点赋值给新尾结点rear*/
		return true ;
	}

	/**
	 * 只返回头结点，不删除
	 */
	public E peek() {
		return isEmpty() ? null : this.front.e ;
	}

	/**
	 * 返回头结点并删除返回的头结点
	 */
	public E poll() {
		if(isEmpty())
			return null ;
		Node<E> temp = this.front ;			/*将头结点赋值于临时节点*/	
		this.front = this.front.next ;		/*将头结点向右移*/
		E value = temp.e ;					
		temp = null ;
		if(this.front == null)
			this.rear = null ;
		return value ;
	}
	
	/**
	 * 
	 * <b>内部节点类<b>
	 * @author 威 
	 * <br>2017年10月1日 上午10:59:56 
	 * @see
	 * <p>此类作用：
	 * <br>末尾节点的没有下一节点因此next为空 
	 * <br>除了末尾节点其他节点负责保存下一个节点和当前节点的数据 
	 * @param <E>
	 * 
	 */
	@SuppressWarnings("hiding")
	class Node<E>{
		E e ;
		Node<E> next ;
		public Node(E e, Node<E> next){
			this.e = e ;
			this.next = next ;
		}
		public String toString(){
			return this.e.toString() ;
		}
	}	
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		Node p = this.front;
		while(p != null){
			sb.append(p+",");
			p = p.next;
		}
		if(this.front != null) sb.deleteCharAt(sb.length()-1);
		return sb.append("]").toString();
	}
	
	public static void main(String[] args){
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
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
