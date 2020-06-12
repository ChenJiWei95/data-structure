package com.chen.list.seq;

import java.util.List;

/**
 * <b>顺序存储的线性表</b>
 * @author 威
 * <br>2018年4月26日 下午1:52:54
 * @since 1.0
 * @param <T>
 */
public class SepList<T> implements ADTList<T> {
	protected Object[] elements;
	protected int n;
	
	public SepList(){
		this(64);
	}
	
	public SepList(int len){
		this.elements = new Object[len];
		n = 0;
	}
	
	public SepList(T[] values){
		this(64);
		int len = values.length;
		for(int i = 0; i < len; i++)
			elements[i] = values[i];
		this.n = len;
	}
		
	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) this.elements[index];
	}
	
	@SuppressWarnings("unchecked")
	public T remove(int index) {
		if(index > n || index < 0)
			throw new IndexOutOfBoundsException(index + "");
		T temp = (T) elements[index];
		for(int i = index+1; i < n; i++)
			elements[i-1] = elements[i];
		n--;
		return temp;
	}
	
	public void clear() {
		n = 0;
	}
	
	/**
	 * 查找某一个T对象所在的下标
	 * @param e
	 * @return
	 * int
	 * @since 1.0
	 */
	public int search(T e) {
		for(int i = 0; i < n; i++)
			if(elements[i] == e)
				return i;
		return -1;
	}
	
	/**
	 * 是否包含
	 * @param e
	 * @return
	 * boolean
	 * @since 1.0
	 */
	public boolean contains(T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		for(int i = 0; i < n; i++)
			if(elements[i] == e)
				return true;
		return false;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("sepList").append("=[");
		for(int i = 0; i < n; i++)
			sb.append(",").append(elements[i]);
		if(n > 0)
			sb.deleteCharAt(9);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public void set(int index, T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		if(index > n || index < 0)
			throw new IndexOutOfBoundsException(index + "");
		for(int i = 0; i < n; i++)
			if(i == index)
				elements[i] = e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int insert(int index, T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		if(index > n || index < 0)
			throw new IndexOutOfBoundsException(index + "");
		n++;
		if(n > elements.length)
			throw new IndexOutOfBoundsException("超出限定长度："+ elements.length + "；操作后长度:" + n);
		// 替换index位置的元素为e
		T pre = (T) elements[index];
		elements[index] = e;
		// index位置后面的元素向后移
		for(int i = index+1; i < n; i++){
			T temp = (T) elements[i];
			elements[i] = pre;
			pre = temp;
		}
		return index;
	}

	@Override
	public int insert(T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		elements[n] = e;
		n++;
		return n-1;
	}

	@Override
	public T remove(T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		for(int i = 0; i < n; i++){
			if(e == elements[i])
				return e;
		}
		return null;
	}

	@Override
	public int insertDifferent(T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		if(!contains(e))
			return this.insert(e);
		return -1;
	}

	@Override
	public void addAll(List<T> list) {
		for(T t : list)
			this.insert(t);
	}
	
	public static void main(String[] args){
		SepList<Integer> sep = new SepList<Integer>(3);
		sep.insert(1);
		sep.insert(3);
		/*sep.insert(25);
		sep.insert(26);*/
//		System.out.println(sep.search(0));
		sep.insert(2, 2);
		sep.remove(2);
//		sep.set(0, 2);
		System.out.println(sep.toString());
	}
}
