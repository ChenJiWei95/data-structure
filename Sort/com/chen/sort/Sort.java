package com.chen.sort;
/**
 * <b>冒泡排序</b>
 * @author 威 
 * <br>2018
 */
public class Sort{
	/**
	 * 基本冒泡排序
	 * <p>	 
	 * 是稳定的 时间复杂度为O(2n)
	 * @param a
	 * @param len
	 * @return
	 * int[]
	 */
	public int[] sort(int[] a, int len){
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len - i - 1; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	/**
	 * 基本冒泡排序加强
	 * <p>
	 * 当数组排序步骤没结束，但是已经是有序的了，那么直接退出整个排序	 
	 * @param a
	 * @param len
	 * @return
	 * int[]
	 */
	public int[] sort2(int[] a, int len){
		for(int i = 0; i < len; i++){
			boolean isFlag = true;
			for(int j = 0; j < len - i - 1; j++){
				if(a[j] > a[j+1]){
					isFlag = false;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			if(isFlag)
				break;
		}
		return a;
	}
}