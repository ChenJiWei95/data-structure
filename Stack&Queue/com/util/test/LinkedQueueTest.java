package com.util.test;

import com.util.queue.LinkedQueue;

/**
 * 
 * <b>对LinkedQueue类进行测试<b>
 * @author 威 
 * <br>2017年10月1日 下午1:24:08 
 *
 */
public class LinkedQueueTest {
	public static void main(String[] args){
		LinkedQueue<Integer> lq = new LinkedQueue<Integer>() ;
		lq.add(1) ;
		lq.add(2) ;
		lq.add(3) ;
		/*System.out.println(lq.peek()) ;
		System.out.println(lq.poll()) ;
		System.out.println(lq.poll()) ;
		System.out.println(lq.peek()) ;
		System.out.println(lq.poll()) ;
		System.out.println(lq.peek()) ;*/
		while(!lq.isEmpty())
			System.out.println(lq.poll()) ;
	}
}
