package com.util.LinkedStorage;

import java.util.List;
/**
 * <b>循环双链表</b>
 * @author 威
 * <br>2018年4月26日 下午6:41:48
 * @since 1.0
 * @param <T>
 */
public class CirDoublyList<T> implements CirADTList<T>{
	protected DoubleNode<T> head;
	protected int n;
	public CirDoublyList(){
		head = new DoubleNode<T>();
		head.prev = head;
		head.next = head;
		n = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return head.next == head;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public T get(int index) {
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=this.head && i<index; i++)
			font = font.next;
		return font.next.data;
	}
	
	@Override
	public T getLastNode() {
		return this.isEmpty() ? null : this.head.prev.data;
	}

	@Override
	public void set(int index, T e) {		
		if(e == null)
			throw new NullPointerException("e == null");
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=this.head && i<index+1; i++)
			font = font.next;
		DoubleNode<T> q = new DoubleNode<T>(e, font.prev, font.next);
		font.next.prev = q;
		font.prev.next = q;
	}

	@Override
	public DoubleNode<T> insert(int index, T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=this.head && i<index; i++)
			font = font.next;
		DoubleNode<T> q = new DoubleNode<T>(e, font, font.next);
		font.next.prev = q;
		font.next = q;
		n++;
		return q;
	}

	@Override
	public DoubleNode<T> insert(T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		DoubleNode<T> q = new DoubleNode<T>(e, head.prev, head);
		head.prev.next = q;
		head.prev = q;
		n++;
		return q;
	}

	@Override
	public DoubleNode<T> remove(int index) {
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=this.head && i<index+1; i++)
			font = font.next;
		font.next.prev = font.prev;
		font.prev.next = font.next;
		n--;
		return font;
	}

	@Override
	public DoubleNode<T> remove(T e) {	
		DoubleNode<T> font = this.head;
		for(font = font.next; font != this.head; font = font.next){
			if(e == font.data) {
				font.prev.next = font.next;
				font.next.prev = font.prev;
				return font;
			}
		}
		n--;
		return null;
	}
	
	@Override
	public DoubleNode<T> removeLast() {
		DoubleNode<T> targetP = this.head.prev;  // 末尾元素
		this.head.prev = targetP.prev;
		targetP.prev.next = this.head;
		n--;
		return targetP;
	}
	
	@Override
	public void clear() {		
		head.prev = head;
		head.next = head;
		n = 0;
	}

	@Override
	public DoubleNode<T> search(T key) {	
		DoubleNode<T> font = this.head;
		for(font = font.next; font != this.head; font = font.next)
			if(key == font.data) return font;
		return null;
	}

	@Override
	public boolean contains(T key) {
		DoubleNode<T> font = this.head;
		for(font = font.next; font != this.head; font = font.next)
			if(key == font.data) return true;
		return false;
	}

	@Override
	public DoubleNode<T> insertDifferent(T e) {
		return this.contains(e) ? null : insert(e);
	}

	@Override
	public void addAll(List<T> list) {
		for(T t : list) insert(t);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName()).append("=[");
		DoubleNode<T> font = this.head;
		for(font = font.next; font != this.head; font = font.next)
			sb.append(font.data).append(",");
		if(!this.isEmpty())
			sb.deleteCharAt(sb.length()-1);
		return sb.append("]").toString();
	}

	public static void main(String[] args){
		CirDoublyList<Integer> cir = new CirDoublyList<Integer>();
		cir.insert(12);
		cir.insert(13);
		cir.insert(0, 10);
		cir.insert(1, 11);
		cir.insertDifferent(13);
		System.out.println(cir.toString());
		System.out.println(cir.remove(12).data);
		System.out.println(cir.toString());
		cir.clear();
		System.out.println(cir.toString());
	}
}
