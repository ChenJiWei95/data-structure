package com.chen.list.seq;
/**
 * <b>排序随机存储线性表</b>
 * <p>
 * 描述:<br>
 * 默认升序 true
 * @author 威 
 * <br>2018年4月26日 下午2:27:00 
 * @see
 * @since 1.0
 * @param <T>
 */
public class SortedSeqList<T> extends SepList<T> {
	/**
	 * 升序布尔值
	 */
	protected boolean SORTED_VAL;
	
	/**
	 * 无参构造，sortedVal true
	 */
	public SortedSeqList(){
		this(64, true);
	}
	
	/**
	 * @param sortedVal	是否升序
	 */
	public SortedSeqList(boolean sortedVal){
		this(64, sortedVal);
	}
	
	public SortedSeqList(int len, boolean sortedVal){
		super(len);
		SORTED_VAL = sortedVal;
		n = 0;
	}
	
	public SortedSeqList(T[] values, boolean sortedVal){
		this(64, sortedVal);
		int len = values.length;
		for(int i = 0; i < len; i++)
			elements[i] = values[i];
		this.n = len;
	}
	public int insert(T x){
		if(x == null)
			throw new NullPointerException("e == null");
		if(n == 0){
			elements[0] = x;
			n++;
			return 0;
		}
		for(int i = 0; i < n; i++){
			if(SORTED_VAL && (Integer) elements[i] > (Integer) x){
				return insert(i, x);
			}else if(!SORTED_VAL && (Integer) elements[i] < (Integer) x){
				return insert(i, x);
			}
		}	
		elements[n++] = x;
		return n-1;
	}
	
	public static void main(String[] args){
		SortedSeqList<Integer> sortSeq = new SortedSeqList<Integer>(false);
		sortSeq.insert(4);
		sortSeq.insert(2);
		sortSeq.insert(1);
		sortSeq.insert(1);
		sortSeq.insert(6);
		sortSeq.insert(1);
		System.out.println(sortSeq.toString());
	}
}
