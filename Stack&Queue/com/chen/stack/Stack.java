package com.chen.stack;
/**
 * 
 * <b>栈接口<b>
 * @author 威 
 * <br>2017年9月30日 下午6:53:55 
 * 
 * @param <E>
 * 
 */
public interface Stack <E> {
	public abstract boolean isEmpty() ;
	public abstract boolean push(E e) ;
	public abstract E peek() ;
	public abstract E pop() ;
}
