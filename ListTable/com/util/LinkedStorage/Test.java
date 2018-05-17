package com.util.LinkedStorage;

import java.util.ArrayList;
/**
 * 
 * <b>对SinglyList的测试<b>
 * @author 威 
 * <br>2017年10月1日 下午5:06:47 
 *
 */
public class Test {
	public static void main(String[] args){
		SinglyList<String> sl = new SinglyList<String>();
		sl.insert("1");
		sl.insert("2");
		sl.insert("3");
		/*System.out.println("insertDifferent:"+sl.insertDifferent("11"));
		System.out.println("insertDifferent:"+sl.insertDifferent("5"));
		System.out.println(sl.toString());
		System.out.println("remove:"+sl.remove("5"));
		System.out.println(sl.toString());
		System.out.println(sl.toString());
		System.out.println("remove:"+sl.remove(3));
		System.out.println(sl.toString());
		System.out.println("insertDifferent:"+sl.insertDifferent("11"));
		System.out.println("insertDifferent:"+sl.insertDifferent("5"));
		System.out.println("size:"+sl.size());
		System.out.println(sl.toString());
		System.out.println("get:"+sl.get(3));
		System.out.println(sl.toString());
		sl.set(3, "10");
		System.out.println(sl.toString());
		sl.insert(3, "4");
		System.out.println(sl.toString());
		java.util.List<String> lists = new ArrayList<String>();
		lists.add("6");
		lists.add("7");
		sl.addAll(lists);
		System.out.println(sl.toString());
		sl.clear(); 
		System.out.println("clear"+sl.toString());*/
		System.out.println(sl.search("1"));
		System.out.println(sl.toString());
	}
}
