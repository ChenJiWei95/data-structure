package com.chen.sort;
/**
 * <b>基数排序</b>
 * <p>
 * 描述:<br>
 * 算法稳定
 * 时间复杂度：平均，最差，最好 O(d(n+r))
 * @author 威 
 * <br>2018
 */
public class RadixSort {
	/**
	 * 获取末尾数值
	 * <p>	 
	 * @param x
	 * @return
	 * int
	 */
	public int getDigit(int x){
		return ((x / 1) % 10);
	}
	public int[] redixSort(int[] a, int len){
		return null;
	}
	public static void main(String[] args){
		System.out.println(new RadixSort().getDigit(9));
		System.out.println(new RadixSort().getDigit(01));
		System.out.println(new RadixSort().getDigit(119));
	}
}
