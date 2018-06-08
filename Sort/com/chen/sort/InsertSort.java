package com.chen.sort;
/**
 * <b>直接插入排序法</b>
 * <p>
 * 描述:<br>
 * 稳定算法
 * 时间复杂度：O(2n)
 * @author 威 
 * <br>2018
 */
public class InsertSort {
	/**
	 * 这里用一句话描述这个方法的作用
	 * <p>	 
	 * @param a
	 * @param len
	 * @return
	 * int[]
	 * @see
	 * @since 1.0
	 */
	public int[] insertSort(int[] a, int len){
		int k, i, j;
		for(i = 1; i < len; i++){
			//0~i-1为有序序列，并在其中为a[i]找一个合适的位置
			for(j = i - 1; j >= 0; j--)
				if(a[j] <= a[i])
					break;
			//相邻两个值并且有序跳过
			if(i != j + 1){
				int temp = a[i];
				//对有序表需要移动的部分进行移动 向后移
				for(k = i-1; k > j; k--)
					a[k+1] = a[k];
				a[k+1] = temp;
			}
		}
		return a;
		
	}
	public static void main(String[] args){
		int a[] = {
			//3,4,5,2,1	
			5,4,2,1,2
		};
		for(int n : new InsertSort().insertSort(a, a.length))
			System.out.println(n);
	}
	
}
