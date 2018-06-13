package com.chen.search.binarysearch;
/**
 * <b>二分法查找</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年6月13日 下午7:31:05 
 */
public class SortedArray {
	public <T extends Comparable<? super T>> int binarySearch(T[] value, int begin, int end, T key){
		while(begin <= end){
			int mid = (begin+end)/2;
			/*System.out.println(value[mid] + " " + mid);*/
			if(value[mid].compareTo(key) == 0)
				return mid;
			if(value[mid].compareTo(key) < 0) begin = mid+1;
			else end = mid-1;
		}
		return -1;
	}
	public <T extends Comparable<? super T>> int binarySearch(T[] value, T key){
		return binarySearch(value, 0, value.length - 1, key);
	}
}
