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
	protected int getDigit(int x){
		return getDigit(x, 1);
	}
	/**
	 * 获取末尾数值
	 * <p>	 
	 * @param x	原数值
	 * @param d	获取那个位数的值--位数
	 * @return
	 * int
	 * @see
	 * @since 1.0
	 */
	protected int getDigit(int x, int d){
		int a[]={
				1,1,10,100
		};
		return ((x / a[d]) % 10);
	}
	/**
	 * 进行基数排序
	 * <p>	 
	 * @param a		排序数组
	 * @param digit	位总数--例如：121（3位数）
	 * @return
	 * int[]
	 * @see
	 * @since 1.0
	 */
	public int[] redixSort(int[] a, int digit){
		redixSort(a, 0, a.length - 1, digit);
		return a;
	}
	/**
	 * 进行基数排序
	 * <p>	 
	 * @param a		排序数组
	 * @param begin	开始--0
	 * @param end	结尾--a.length-1
	 * @param digit	位总数--例如：121（3位数）
	 * void
	 * @see
	 * @since 1.0
	 */
	protected void redixSort(int[] a, int begin, int end, int digit){
		final int radix = 10;
		int i = 0, j = 0;
		//桶的统计数
		int[] count = new int[radix];
		int[] bucket = new int[end - begin + 1];
		for(int d = 1; d <= digit; d++){
			//初始所有桶数量
			for(i = 0; i < radix; i++)
				count[i] = 0;
			
			//统计各个桶的个数
			for(i = begin; i <= end; i++){
				j = getDigit(a[i], d);
				count[j]++;
			}
			//d在各种情况下经过位数统计，count数组的值为：
			//d=1	4 0 0 1 1 1 1 0 0 0 
			//d=2	4 0 0 0 0 0 0 0 2 2 
			//d=3	4 2 0 0 0 0 0 1 1 0 
			
			//count[i]表示第i个桶右边界索引
			for(i = 1; i < radix; i++)
				count[i] = count[i] + count[i-1];
			//d在各种情况下经过第i个桶右边界索引处理，count数组的值为：
			//d=1	4 4 4 5 6 7 8 8 8 8 
			//d=2	4 4 4 4 4 4 4 4 6 8
			//d=3	4 6 6 6 6 6 6 7 8 8 
			
			//将数据装入桶中
			//从右向左，保证稳定性
			for(i = end; i >= begin; i--){
				j = getDigit(a[i], d);
				//根据桶count的右边界向桶bucket导入数据
				bucket[count[j] - 1] = a[i];
				//桶count的右边界索引自减，下一次导入数据时将会导入在前一个
				count[j]--;
			}
			//将桶数据装回原数组
			for(i = begin; i <= end; i++)
				a[i] = bucket[i];  
		}
	}
	public static void main(String[] args){
		int[] a = {	
			90,0,4,86,100,105,890,783
		};
		for(int n : new RadixSort().redixSort(a, 3))
			System.out.print(n+" ");
	}
}
