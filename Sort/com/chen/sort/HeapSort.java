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
		//第一个for：
		//需要：从最尾端开始将最大的元素推到树顶
		//len/2-1得到一个最尾端的非叶子结点
		//通过for循环一次将最大的元素推到树顶
		for(int i = len/2-1; i >= 0; i--)
			adjustHead(a, i, len);	//构建大顶堆
		
		//第二个for：
		//做了什么：调整堆结构+交换堆顶元素与末尾元素
		//当前状态：经过第一个for的处理元素基本是堆顶向下从大到小排列，但不成序。
		//需要：通过循环调整堆结构，交换堆顶元素与末尾元素并在末尾构建一个有序数列。
		for(int j = len-1; j > 0; j--){
			swap(a, 0, j);			//上文已经构建了一个大顶堆，将堆顶元素和末尾元素替换，在末尾形成一个有序数列
			adjustHead(a, 0, j);	//0~j的范围重新构建大顶堆
		}
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
		int temp = arr[i];//当前非叶子结点
		for(int k = i*2+1; k < len; k = k*2+1){
			if(k+1 < len && arr[k] < arr[k+1]) k++; //与相邻的兄弟节点比较，选最大
			if(arr[k] > temp) {			//与当前堆顶节点比较，置换最大的元素到当前堆顶，然后在从置换的位置开始继续循环
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
			4,6,8,5,9	
		};
		for(int n : new HeapSort().headSort(a, a.length))
			System.out.print(n+" ");
	}
}
