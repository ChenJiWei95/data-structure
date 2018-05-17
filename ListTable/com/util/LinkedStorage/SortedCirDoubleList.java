package com.util.LinkedStorage;
import com.util.LinkedStorage.CirDoublyList;
import com.util.LinkedStorage.DoubleNode;
/**
 * <b>排序循环升序</b>
 * @author 威 
 * <br>2018年5月15日 下午1:50:28 
 * @see com.chen.LinkedStorage.CirDoublyList<T>
 * @since 1.0
 * @param <T>
 */
public class SortedCirDoubleList<T extends Comparable<? super T>> extends CirDoublyList<T>{
	@Override
	public DoubleNode<T> insert(T x){
		if(this.isEmpty() || x.compareTo(this.head.prev.data) > 0)
			return super.insert(x);	//
		DoubleNode<T> p = this.head.next;
		while(p != null && x.compareTo(p.data) > 0) 
			p = p.next;
		DoubleNode<T> q = new DoubleNode<T>(x, p.prev, p);
		p.prev.next = q;
		p.prev = q;
		return q;
	}
	/**
	 * 倒序输出
	 * <p>	 
	 * @return
	 * String
	 * @see
	 * @since 1.0
	 */
	public String toPreviousString(){
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName()).append("=[");
		DoubleNode<T> prev = this.head.prev;
		for(; prev != this.head; prev = prev.prev)
			sb.append(prev.data).append(",");
		if(!this.isEmpty())
			sb.deleteCharAt(sb.length()-1);
		return sb.append("]").toString();
	}
}