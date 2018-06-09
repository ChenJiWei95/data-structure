package com.chen.sort;
/**
 * <b>堆排序</b>
 * <p>
 * 描述:<br>
 * 算法稳定
 * 时间复杂度：最好，最坏，平均时间 O(nlogn)
 * @author 威 
 * <br>2018
 */
public class HeapSort {
	/**
	 * 顶堆排序
	 * <p>	 
	 * @param a
	 * @param len	
	 * @return
	 * int[]
	 */
	public int[] headSort(int[] a, int len){
		//构建大顶堆
		for(int i = len/2-1; i >= 0; i--){
			adjustHead(a, i, len);
		}
		for(int n : a)
			System.out.print(n+" ");
		//调整堆结构+交换堆顶元素与末尾元素
		
		return a;
	}
	/**
	 * 调整顶堆
	 * <p>	 
	 * @param arr
	 * @param i
	 * @param len
	 * void
	 */
	public void adjustHead(int[] arr, int i, int len){
		int temp = arr[i];
		for(int k = i*2+1; k < len; k = k*2+1){
			if(k+1<len && arr[k] < arr[k+1]) k++;
			if(arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}
		arr[i] = temp;
	}
	/**
	 * 两个元素置换
	 * <p>	 
	 * @param arr
	 * @param a		元素下标
	 * @param b		元素下标
	 * void
	 */
	protected void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args){
		int a[] = {
			//3,4,5,2,1	
			//5,4,2,1,2
			3,4,2,5,1	
		};
		new HeapSort().headSort(a, a.length);
		
	}
}
