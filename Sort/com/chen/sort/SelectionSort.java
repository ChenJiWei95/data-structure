package com.chen.sort;
/**
 * <b>选择排序</b>
 * <p>
 * 描述:<br>
 * 稳定算法
 * 时间复杂度： O(2n) 
 * 
 * 实现：
 * 
 * @author 威 
 * <br>2018
 */
public class SelectionSort {
	/**
	 * <p>
	 * 在未排序的数列中找到最小元素，将其放到有序数列末尾位置；接着从剩余未排序的数列中继续前面的步骤	 
	 * @param a
	 * @param len
	 * @return
	 * int[]
	 * @see
	 * @since 1.0
	 */
	public int[] selectSort(int[] a, int len){
		int i, j, min;
		for(i = 0; i < len; i++){
			min = i;
			for(j = i + 1; j < len; j++)
				min = a[j] < a[min] ? j : min;
			if(min != i){
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
		return a;
	}
	public static void main(String[] args){
		int[] a = {
			//3,4,5,2,1	
			5,4,2,1,2
		};
		for(int n : new SelectionSort().selectSort(a, a.length))
			System.out.print(n);
	}
}
