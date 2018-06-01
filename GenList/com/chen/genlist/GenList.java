package com.chen.genlist;

/**
 * <b>广义表接口</b>
 * @author 威 
 * <br>2018年6月1日 下午10:40:26 
 * @since 1.0
 * @param <T>
 */
public interface GenList <T> {
	boolean isEmpty();
	int size();
	int depth();
	GenNode<T> insert(int i, T t);
	GenNode<T> insert(int i, GenList<T> gList);
	GenNode<T> insert(T t);
	GenNode<T> insert(GenList<T> gList);
 	void remove(int i);
}