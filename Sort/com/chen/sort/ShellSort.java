package com.chen.sort;
/**
 * <b>希尔排序 -- 缩小增量排序</b>
 * <p>
 * 描述:<br>
 * 不稳定算法<br>
 * 时间复杂度 最坏O(1.5) 平均O(Nlog2N)<br>
 * 
 * 实现：<br>
 * 通过对步长不断的对半分，并且满足步长的两个元素进行比较再交换，直至步长<=1为止，会得到一个有序数列
 * @author 威 
 * <br>2018
 */
public class ShellSort {
	/**
	 * 希尔排序 -- 缩小增量排序
	 * <p>	 
	 * 取步长gap进行排序
	 * 初始步长 	len/2
	 * 后续步长 	gap/2
	 * 步长值 >= 1
	 * @param a
	 * @param len
	 * @return
	 * int[]
	 */
	public int[] shellSort(int[] a, int len){
		int gap = len / 2;
		while(1 <= gap){
			for(int i = gap; i < len; i++){
				int temp = a[i];
				/*if(a[i-gap] > temp){
					a[i] = a[i-gap];
					a[i-gap] = temp;
				}*/
				int j = 0; 
				for(j = i-gap; j >= 0 && temp < a[j]; j = j-gap)
					a[j+gap] = a[j];
				a[j+gap] = temp;
			}
			gap = gap/2;
		}
		return a;
	}
	public static void main(String[] args){
		int a[] = {
				//3,4,5,2,1	
				5,4,2,1,2
				//3,4,2,5,1	
			};
		for(int n : new ShellSort().shellSort(a, a.length))
			System.out.print(n);
		
	}
}
