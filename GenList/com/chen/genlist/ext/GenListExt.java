package com.chen.genlist.ext;

import com.chen.genlist.GenList;
import com.chen.genlist.GenNode;

/**
 * <b>广义表实现类</b>
 * @author 威 
 * <br>2018年6月1日 下午10:43:12 
 * @see com.chen.genlist.GenList<T>
 * @since 1.0
 * @param <T>
 */
public class GenListExt<T> implements GenList<T>{
	public GenNode<T> head;			//广义表头节点
	private int len;				//广义表长度
	public GenListExt(){
		this.head = new GenNode<T>();
		len = 0;
	}
	public boolean isEmpty(){
		return this.head.next == null;
	}
	public int size(){
		//长度属性自增自减实现
		return len;
	}
	//递归
	public int depth(){
		if(isEmpty()) return 1;
		int preLen = 1, nowLen = 1;
		for(GenNode<T> p = this.head.next; p != null; p=p.next){
			if(p.child != null){
				nowLen += p.child.depth();
				preLen = preLen > nowLen ? preLen : nowLen;
				nowLen = 1;
			}
		}
		return preLen;
	}
	public GenNode<T> insert(int i, T t){	
		//对i容错 ， 如果操出范围则尾插入
		if(i > len) i = len;
		len++;
		GenNode<T> currentNode = this.head;
		for(int j = 0; j < i; j++)
			currentNode = currentNode.next;
		GenNode<T> p = new GenNode<T>(t, null, currentNode.next);
		currentNode.next = p;
		return p;
	}
	public GenNode<T> insert(int i, GenList<T> gList){
		//对i容错 ， 如果操出范围则尾插入
		if(i > len) i = len;
		len++;
		GenNode<T> currentNode = this.head;
		for(int j = 0; j < i; j++)
			currentNode = currentNode.next;
		GenNode<T> p = new GenNode<T>(null, gList, currentNode.next);
		currentNode.next = p;
		return p;
		
	}
	public GenNode<T> insert(T t){
		return insert(len, t);
	}
	public GenNode<T> insert(GenList<T> gList){
		return insert(len, gList);
	}
 	public void remove(int i){
		if(i < len){
			len--;
			GenNode<T> currentNode = this.head;
			for(int j = 0; j < i; j++)
				currentNode = currentNode.next;
			currentNode.next = currentNode.next.next;
		}	
		else throw new IndexOutOfBoundsException("i������ٳ���Χ:" + i);
	}
	//递归
	public String toString(){
		String str = "(";
		for(GenNode<T> p = this.head.next; p != null; p=p.next){
			str += p.child == null 
				? p.data.toString() 
				: p.child.toString();
			if(p.next != null) str += ",";
		}
		return str+")";
	}
} 