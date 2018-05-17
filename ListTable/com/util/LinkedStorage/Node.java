package com.util.LinkedStorage;
/**
 * <b>节点</b>
 * @author 威 
 * <br>2017年10月1日 下午1:42:18
 * @since 1.0
 * @param <E>
 */
public class Node<E> {
	public E data ;
	public Node<E> next ;
	public Node(){
		this(null, null) ;
	}
	/**
	 *  Node构造方法 进行当前节点的数据保存和下一节点的保存
	 * @param data
	 * @param next
	 */
	public Node(E data, Node<E> next){
		this.data = data ;
		this.next = next ;
	}
	/**
	 * 返回节点的描述
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return this.data.toString() ;
	}
}

