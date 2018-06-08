package com.chen.sort;
/**
 * <b>快速排序</b>
 * 不稳定
 * 时间复杂度最坏为O(2n)；平均为O(nlgn)
 * @author 威 
 * <br>2018
 */
public class QuickSort{
	/**
	 * 快速排序 选择一个基准数，通过一趟排序将数据分割成独立的两部分，然后递归
	 * <p>	
	 * @param a
	 * @param l	左边的初始下标  0
	 * @param r	右边的初始左标	a.length
	 * @return
	 * int[]
	 */
	public int[] quickSort(int[] a, int l, int r){
		if(l < r){
			int i = l;
			int j = r;
			int x = a[i];
			while(i < j){
				while(i < j && a[j] > x)	//从右往左找出第一个小于x的数，并把它放到x的左边
					j--;
				if(i < j) 
					a[i++] = a[j];
				while(i < j && a[i] < x) 	//从左往右找出第一个大于x的数，并把它放到x的右边
					i++;
				if(i < j)
					a[j--] = a[i];
			}
			a[i] = x;
			quickSort(a, l, i - 1);
			quickSort(a, i + 1, r);
		}
		return a;
	}
}