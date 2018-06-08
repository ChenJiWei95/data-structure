package com.chen.sort;
/**
 * <b>归并排序</b>
 * <p>
 * 描述:<br>
 * 算法稳定<br>
 * 时间复杂度： 最好，最坏，平均 都为 O(nlogn)<br>
 * @author 威 
 * <br>2018
 */
public class MergeSort {
	/** 
	 * 分而治之--形成一棵二叉树，后归并排序<br>
	 * @param a
	 * @param len
	 * @return
	 * int[]
	 */
	public int[] mergeSort(int[] a, int len){
		int[] temp = new int[len];
		mergeSort(a, 0, len-1, temp);//形成一棵二叉树
		return a;
	}
	/**
	 * 先形成一棵二叉树
	 * <p>	 
	 * @param a
	 * @param l
	 * @param r
	 * @param temp
	 * void
	 */
	protected void mergeSort(int[] a, 
			int l, int r, int[] temp){
		if(l < r){
			int mid = (l+r)/2;
			mergeSort(a, l, mid, temp);		//形成左二叉
			mergeSort(a, mid+1, r, temp);	//形成右二叉
			mergeSort(a, l, mid, r, temp);	//归并排序
		}
	}
	/**
	 * 对二叉树归并并进行排序
	 * <p>	 
	 * @param a
	 * @param left
	 * @param mid
	 * @param right
	 * @param temp
	 * void
	 */
	protected void mergeSort(int[] a, 
			int l, int mid, int r, int[] temp){
		int i = mid+1, //右序列指针
				j = l, //左序列指针
				k = l; //临时数组指针
		while(i <= r && j <= mid)
			temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
		while(j <= mid) temp[k++] = a[j++];	//左边剩余
		while(i <= r) 	temp[k++] = a[i++];	//右边剩余
		//将temp拷贝到原数组上
		for(int n = l; n <= r && n < a.length; n++)
			a[n] = temp[n];
	}
	public static void main(String[] args){
		int[] a = {
			//3,4,5,2,1	
			2,1,5,4,2,1,7,8
			//2,1,2,3
			//1,1,2
		};
		for(int n : new MergeSort().mergeSort(a, a.length))
			System.out.print(n + " ");
	}
}
