package com.chen.list.linked.doubles;

import java.util.List;

import com.chen.list.linked.CirADTList;
import com.chen.list.linked.DoubleNode;
/**
 * <b>双链表</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2020年6月11日 下午6:56:25 
 * @see
 * @since 1.0
 * @param <T>
 */
public class DoublyList<T> implements CirADTList<T>{
	protected DoubleNode<T> head;
	protected int n;
	public DoublyList(){
		head = new DoubleNode<T>();
		n = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public T get(int index) {
		if(isEmpty())
			return null;
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=null && i<index; i++)
			font = font.next;
		return font.data;
	}
	
	@Override
	public T getLastNode() {
		return this.isEmpty() ? null : get(Integer.MAX_VALUE);
	}

	@Override
	public void set(int index, T e) {	
		if(isEmpty())
			return ;
		if(e == null)
			throw new NullPointerException("e == null");
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=null && i<index; i++)
			font = font.next;
		font.data = e;
		/*DoubleNode<T> q = new DoubleNode<T>(e, font.prev, font.next);
		font.next.prev = q;
		font.prev.next = q;*/
	}

	@Override
	public DoubleNode<T> insert(int index, T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=null && i<index; i++)
			font = font.next;
		DoubleNode<T> q = new DoubleNode<T>(e, font, font.next);
		if(font.next != null) font.next.prev = q;
		font.next = q;
		n++;
		return q;
	}

	@Override
	public DoubleNode<T> insert(T e) {
		return insert(Integer.MAX_VALUE, e);
	}

	@Override
	public DoubleNode<T> remove(int index) {
		System.out.println("下标删除");
		DoubleNode<T> font = this.head;
		for(int i = 0; font.next!=null && i<index; i++)
			font = font.next;
		if(n <= index){
			font.prev.next = null;
			font.prev = null;
		}else {
			font.next.prev = font.prev;
			font.prev.next = font.next;
		}
		n--;
		return font;
	}

	@Override
	public DoubleNode<T> remove(T e) {	
		System.out.println("对象删除");
		DoubleNode<T> font = this.head;
		for(font = font.next; font != null; font = font.next){
			if(e.equals(font.data)) {
				if(font.next == null){
					font.prev.next = null;
					font.prev = null;
				}else {
					font.prev.next = font.next;
					font.next.prev = font.prev;
				}
				return font;
			}
		}
		n--;
		return null;
	}
	
	@Override
	public DoubleNode<T> removeLast() {
		return remove(Integer.MAX_VALUE);
	}
	
	@Override
	public void clear() {		
		head.next = null;
		n = 0;
	}

	@Override
	public DoubleNode<T> search(T key) {	
		DoubleNode<T> font = this.head;
		for(font = font.next; font != null; font = font.next)
			if(font.data.equals(key)) return font;
		return null;
	}

	@Override
	public boolean contains(T key) {
		DoubleNode<T> font = this.head;
		for(font = font.next; font != null; font = font.next)
			if(font.data.equals(key)) return true;
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
		for(font = font.next; font != null; font = font.next)
			sb.append(font.data).append(",");
		if(!this.isEmpty())
			sb.deleteCharAt(sb.length()-1);
		return sb.append("]").toString();
	}

	public static void main(String[] args){
		DoublyList<Integer> list = new DoublyList<Integer>();
		System.out.println("isEmpty:"+list.isEmpty());
		System.out.println("insert:"+list.insert(1));
		System.out.println("set: ");
		list.set(1, 2);
//		System.out.println("对象删除 remove: "+list.remove(new Integer(2)));
//		System.out.println("下标删除 remove: "+list.remove(1));
//		System.out.println("removeLast："+list.removeLast());
		System.out.println("search："+list.search(2));
		System.out.println("contains："+list.contains(2));
		System.out.println("insertDifferent："+list.insertDifferent(2));
		System.out.println("insertDifferent："+list.insertDifferent(3));
		System.out.println("get:"+list.get(1));
		System.out.println("getLastNode:"+list.getLastNode());
		System.out.println("size:"+list.size());
//		list.insert(12);
//		list.insert(13);
//		list.insert(0, 10);
//		list.insert(1, 11);
//		list.insertDifferent(13);
//		System.out.println(list.toString());
//		System.out.println(list.remove(12).data);
//		System.out.println(list.toString());
//		list.clear();
//		System.out.println(list.toString());
	}
}
