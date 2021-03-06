package com.chen.matrix;

/**
 * <b>稀疏矩阵非零三元组--行号，列号，元素值</b>
 * <p>
 * 描述:<br>
 * Addible 完成相加 接口 <br>
 * Comparable 完成不同矩阵中两个值的相等判断 <br> 
 * 比较大小与其行、列有关，与其值无关，约定三元组排序次序 <br>
 * <br>
 * @author 威 
 * <br>2018年6月1日 下午10:51:32 
 * @see
 * @since 1.0
 */
public class Triple implements Comparable<Triple>, Addible<Triple>{
	public int row, column, value;
	public Triple (int row, int column, int value) {
//		System.out.println("("+row+", "+column+", "+value+")");
		if(row >= 0 && column >= 0){
			this.row = row;
			this.column = column;
			this.value = value;
		}
		else
			throw new IllegalArgumentException("行号、列号不能为负:row="+row+", column="+column);
	}
	public Triple (Triple triple) {
		this(triple.row, triple.column, triple.value);
	}
	public String toString () {
		return "("+row+", "+column+", "+value+")";
	}
	//比较大小与其行、列有关，与其值无关，约定三元组排序次序
	public int compareTo(Triple tri) {
		if(this.row == tri.row && this.column == tri.column)
			return 0;
		return (this.row < tri.row || this.row == tri.row 
			&& this.column < tri.column) ? -1 : 1;
	}
	//比较三元组是否相等，比较位置和元素值 。 有一个要素不相等，就会返回false
	// 如果要使用get方法那么此处必须得是比较位置是否相等
	@Override
	public boolean equals(Object tri) {
//		System.out.println("equals: "+tri);
		if(((Triple)tri).row != this.row || ((Triple)tri).column != this.column)
			return false;
		return true;
	}
	//必须要位置相同才能进行相加
	public void add(Triple tri) {
		if(this.compareTo(tri) == 0)
			this.value += tri.value;
		else
			throw new IllegalArgumentException();
	}
	//约定删除元素的条件，实现Addible<T>接口
	public boolean removable() {
		return this.value == 0;
	}
	//返回对称位置的三元组对象
	public Triple toSymmetry() {
		return new Triple(this.column, this.row, this.value);
	}
}