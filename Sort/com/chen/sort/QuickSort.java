package com.chen.sort;
/**
 * <b>快速排序</b>
 * 不稳定
 * 时间复杂度最坏为O(2n)；平均为O(nlgn)
 * i = l = 0
 * j = len
 * x = a[i] = 3 以x为基准数，将数据根据准数左右两边排序
 * 3 6 4 8 1 2 5 (范例)
 * 在 i < j 的条件下循环从右往左找，从左往右找
 * 从右往左找比他小的数移到左边 (i < j && a[j] > x)  循环到a[i] < x为止
 * 2 6 4 8 1 2 5 (a[i++] = a[j])
 * 从左往右找比他大的数移到右边 (i < j && a[i] < x)  循环到a[i] > x为止
 * 2 6 4 8 1 6 5 (a[j--] = a[i]) a[2]大于x 所以复制于a[j]并且j--
 * 结束 i < j 的条件下循环 ，将a[i] = x
 * 继续递归快速排序 quickSort(a, l, i - 1); quickSort(a, i + 1, r);
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
