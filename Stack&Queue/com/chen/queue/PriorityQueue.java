package com.chen.queue;

import com.chen.list.linked.doubles.SortedCirDoubleList;
/**
 * <b>优先队列</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年5月15日 下午1:55:34 
 * @see
 * @since 1.0
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<? super E>> implements Queue<E> {
	private SortedCirDoubleList<E> list;
	private boolean asc;
	public PriorityQueue(boolean asc){
		list = new SortedCirDoubleList<E>();
		this.asc = asc;
	}
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean add(E e) {
		return this.list.insert(e) != null;
	}
	@Override
	public E peek() {
		return this.asc ? this.list.get(0) : this.list.getLastNode();
	}
	@Override
	public E poll() {
		return this.asc ? this.list.remove(0).data : this.list.removeLast().data;
	}
	@Override
	public String toString(){
		return this.asc ? this.list.toString() : this.list.toPreviousString();
	}
}
