package com.util.test;

import com.util.queue.Queue;
import com.util.queue.SeqQueue;
import com.util.stack.NodeStackEX;

/**
 * 
 * <b>对NodeStackEX栈扩展的测试<b>
 * @author 威 
 * <br>2017年9月30日 下午7:43:07 
 * 
 * @param <E>
 * 
 */
public class Test1<E> {
	
	public static void main(String[] args){
		NodeStackEX<String> t = new NodeStackEX<String>() ;
		System.out.println(t.isEmpty()) ;
		t.push("2") ;
		t.push("3") ;
		t.push("4") ;
		System.out.println(t.length()) ;
		System.out.println(t.isEmpty()) ;
		while(!t.isEmpty()){
			System.out.println(t.pop()) ;
		}
		Queue<Integer> q = new SeqQueue<Integer>() ;
		q.add(1) ;
		q.add(2) ;
		q.add(3) ;
		q.add(4) ;
			System.out.println("输出"+q.poll()) ; 
			System.out.println("输出"+q.poll()) ; 
			System.out.println("输出"+q.poll()) ; 
			System.out.println("输出"+q.poll()) ; 
			q.add(1) ;
			q.add(2) ;
			q.add(3) ;
			q.add(4) ;
			System.out.println("输出"+q.poll()) ; 
			System.out.println("输出"+q.poll()) ; 
	}
}