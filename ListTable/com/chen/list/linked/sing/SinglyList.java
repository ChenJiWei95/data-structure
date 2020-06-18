package com.chen.list.linked.sing;

import com.chen.list.linked.Node;
import com.chen.list.seq.ADTList;

/**
 * <b>线性链表</b>
 * @author 威 
 * <br>2017年10月1日
 * @since 1.0
 * @param <E>
 */
public class SinglyList<E> implements ADTList<E> {
	public Node<E> head;
	public SinglyList(){
		this.head = new Node<E>(); /*创建头结点 data next 均为空（空单链表）*/
	}
	public SinglyList(E[] values){ /*构造单链表 元素由values提供*/
		this(); /*创建空单链表*/
		Node<E> rear = this.head;
		for(E e : values){
			rear.next = new Node<E>(e, null);
			rear = rear.next;
		}
	}
	
	public boolean isEmpty() {
		return this.head.next == null;
	}
	
	public int size() {
		Node<E> p = this.head.next;
		int length = 0;
		while(p != null){
			length++;
			p = p.next;
		}
		return isEmpty() ? 0 : length;
	}
	
	public E get(int index) {
		Node<E> p = this.head.next;
		for(int j = 0; p != null && j < index; j++)
			p = p.next;
		return (index>=0 && p!=null) ? p.data : null;
	}
	
	public void set(int index, E e) {
		Node<E> p = this.head.next;
		if(index+1 > size() && index < 0)
			throw new RuntimeException("下标异常 -- 超出表范围");
		for(int j = 0; p != null && j < index; j++)
			p = p.next;
		/*以上的循环获取第index节点*/
		p.data = e;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for(Node<E> p = this.head.next; p != null; p = p.next){
			sb.append(p.data);
			if(p.next!=null)
				sb.append(",");
		}
		return sb.toString();
	}
	
	// 复杂度是O（n）
	public int insert(int index, E e) {
		if(e == null)
			throw new NullPointerException("x==null");
		/*if(index+1 > size() && index < 0)
			throw new RuntimeException("下标异常 -- 超出表范围");*/
		Node<E> p = this.head;
		for(int j = 0; p.next != null && j < index; j++)
			p = p.next;
		/*以上的循环获取第index-1节点*/
		p.next = new Node<E>(e, p.next); /*将index-1节点指向新节点并将新节点指向index+1节点*/
		return index;
	}

	public int insert(E e) {
		/*利用insert(index, e)方法插入尾部， index必须容错 -- 提高插入尾部的效率和程序的效率*/
		return insert(Integer.MAX_VALUE, e);
	}
	
	public E remove(int index) {
		Node<E> p = this.head;
		for(int j = 0; p.next != null && j < index; j++) /*返回index-1节点*/
			p = p.next;
		if(index >= 0 && p.next != null){
			E old = p.next.data;
			p.next = p.next.next;
			return old;
		}
		return null;
	}
	
	public void clear() {
		this.head.next = null;		
	}
	
	public int search(E key) {
//		System.out.println("search: toString: "+toString());
		Node<E> p = this.head.next;
		for(int i = 0; p != null; i++){
//			System.out.println("search: for: "+p.data.getClass());
			if(p.data.equals(key))
				return i;
			p = p.next;
		}
		return -1;
	}
	
	public boolean contains(E key) {
		return search(key) != -1;
	}
	
	public int insertDifferent(E e) {
		if(!contains(e))
			return insert(e);
		return -1;
	}
	
	@SuppressWarnings("unused")
	public E remove(E key) {
		Node<E> p = this.head.next;
		Node<E> temp;
		if(key == null)
			throw new NullPointerException("key == null");
		for(int i = 0; p != null; i++) { 
			temp = p;
			p = p.next;
			if(p.data.equals(key)){ /*判断当前节点是否符合*/
				temp.next = p.next; /*将上一节点指向下下一节点--删除当前节点*/
				return p.data;
			}
		}	
		return null;
	}
	
	public void addAll(java.util.List<E> lists) {
		for(E e : lists){
			insert(e);
		}
	} 
	
	public static void main(String[] args){
		Integer i = new Integer(0);
		Integer b = new Integer(0);
		System.out.println(i.equals(b));
		System.out.println(i==b);
		
		int j = 0;
		int d = 0;
//		System.out.println(j.equals(d));
		System.out.println(j==d);
	}
}
