package com.chen.test;

import com.chen.queue.PriorityQueue;
/**
 * <b>测试优先队列
 * <p>
 * 描述:<br>
 *  一切正常
 * @author 威 
 * <br>2018年5月15日 下午2:13:29 
 * @see
 * @since 1.0
 */
public class PriorityQueueTest {
	public static void main(String[] args){
		com.chen.queue.Process p1 = new com.chen.queue.Process("xiaoming", 5);
		com.chen.queue.Process p2 = new com.chen.queue.Process("xiaoming", 1);
		com.chen.queue.Process p3 = new com.chen.queue.Process("xiaoming", 10);
		com.chen.queue.Process p4 = new com.chen.queue.Process("xiaoming", 7);
		PriorityQueue<com.chen.queue.Process> pQueue = new PriorityQueue<com.chen.queue.Process>(true);
		pQueue.add(p1);
		pQueue.add(p2);
		pQueue.add(p3);
		pQueue.add(p4);
		
		System.out.println(pQueue.toString());
	}
}
