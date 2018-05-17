package com.util.queue;
/**
 * 
 * <b>队列接口<b>
 * @author 威 
 * <br>2017年9月30日 下午8:50:18 
 * 
 * @param <E>
 */
public interface Queue<E> {
	public boolean isEmpty() ;
	public boolean add(E e) ;
	public E peek() ;
	public E poll() ;
}
