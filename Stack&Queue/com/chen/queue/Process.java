package com.chen.queue;
/**
 * <b>优先队列的载入对象</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年5月15日 下午2:02:50 
 * @see	com.chen.queue.PriorityQueue
 * @since 1.0
 */
public class Process implements Comparable<Process> {
	private String name;
	private int priority;
	public Process(String name, int priority) {
		this.name = name;
		if(priority >= 1 && priority <= 10)
			this.priority = priority;
		else throw new IllegalArgumentException("priority = "+ priority);
	}
	public Process(String name){
		this(name, 5);
	}
	@Override
	public int compareTo(Process p) {
		return this.priority - p.priority;
	}
	
	public String toString(){
		return "(" + this.name + "," + this.priority + ")";
	}
	
}
