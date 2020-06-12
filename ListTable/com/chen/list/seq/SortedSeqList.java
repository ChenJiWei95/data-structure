package com.chen.list.seq;

import java.util.List;

/**
 * <b>排序随机存储线性表</b>
 * <p>
 * 描述:<br>
 * 默认升序，SORTED_VAL=true
 * @author 威 
 * <br>2018年4月26日 下午2:27:00 
 * @see
 * @since 1.0
 * @param <T>
 */
public class SortedSeqList<T> extends SepList<T> {
	/** 升序布尔值 默认升序，SORTED_VAL=true*/
	protected boolean SORTED_VAL;
	
	/**
	 * 无参构造，sortedVal true
	 */
	public SortedSeqList(){
		this(64, true);
	}
	
	/**
	 * @param sortedVal	是否升序
	 */
	public SortedSeqList(boolean sortedVal){
		this(64, sortedVal);
	}
	
	public SortedSeqList(int len, boolean sortedVal){
		super(len);
		SORTED_VAL = sortedVal;
		n = 0;
	}
	
	public SortedSeqList(T[] values, boolean sortedVal){
		this(64, sortedVal);
		int len = values.length;
//		SortedSeqList<T> inList = new SortedSeqList<T>(len, sortedVal);
		for(int i = 0; i < len; i++)
			this.insert(values[i]);
//		this.n = len;
	}
	
	public int insert(int index, T x){
		throw new UnsupportedOperationException("不支持方法");
	}
	
	@Override
	public void set(int index, T e) {
		throw new UnsupportedOperationException("不支持方法");
	}
	
	@Override
	public int insertDifferent(T e) {
		if(e == null)
			throw new NullPointerException("e == null");
		if(!contains(e))
			return this.insert(e);
		return -1;
	}
	
	/**
	 * 重写insert 使其有序插入
	 * @see com.chen.list.seq.SepList#insert(java.lang.Object)
	 */
	public int insert(T x){
		if(x == null)
			throw new NullPointerException("e == null");
		if(n == 0){
			super.elements[0] = x;
			super.n++;
			return 0;
		}
		for(int i = 0; i < n; i++){
			if(SORTED_VAL && (Integer) super.elements[i] > (Integer) x){
				return super.insert(i, x);
			}else if(!SORTED_VAL && (Integer) super.elements[i] < (Integer) x){
				return super.insert(i, x);
			}
		}	
		super.elements[n++] = x;
		return super.n-1;
	}
	
	public static void main(String[] args){
		SortedSeqList<Integer> sortSeq = new SortedSeqList<Integer>(new Integer[]{1, 2, 8, 4, 2}, false);
		sortSeq.insert(4);
		sortSeq.insert(2);
		sortSeq.insert(1);
		sortSeq.insert(1);
		sortSeq.insert(6);
		sortSeq.insert(1);
//		System.out.println(sortSeq.search(4));
//		sortSeq.remove(2);
//		System.out.println(sortSeq.insertDifferent(8));
		System.out.println(sortSeq.toString());
//		sortSeq.insert(1, 1);
	}
}
