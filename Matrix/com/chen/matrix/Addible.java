package com.chen.matrix;
/**
 * <b>此接口实现相加，删除元素</b>
 * @author 威 
 * <br>2018年6月1日 下午10:50:17 
 * @see
 * @since 1.0
 * @param <T>
 */
public interface Addible<T> {
	public void add (Triple tri);
	public boolean removable ();
}