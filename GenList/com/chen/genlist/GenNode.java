package com.chen.genlist;
/**
 * <b>广义表节点对象</b>
 * @author 威 
 * <br>2018年6月1日 下午10:41:14 
 * @see
 * @since 1.0
 * @param <T>
 */
public class GenNode<T>{
	public T data;					//数据域
	public GenList<T> child;		//地址域,指向子表
	public GenNode<T> next;			//地址域，指向下一节点
	public GenNode(T data, GenList<T> child, GenNode<T> next){
		this.data = data;
		this.child = child;
		this.next = next;
	}
	public GenNode(T data){
		this(data, null, null);
	}
	public GenNode(){
		this(null, null, null);
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("{GenNode-[");
		sb.append("data=").append(data).append(",");
		sb.append("child=").append(child.toString()).append(",");
		sb.append("next=").append(next.toString()).append("]}");
		return sb.toString();
	}
}