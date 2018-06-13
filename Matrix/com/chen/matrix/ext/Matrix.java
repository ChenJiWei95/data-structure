package com.chen.matrix.ext;

/**
 * <b>矩阵 -- 简单矩阵存储</b>
 * <p>
 * 描述:<br>
 * rows 行数， columns 列数<br>
 * elements 通过二维数组存储矩阵
 * @author 威 
 * <br>2018年6月1日 下午10:53:34 
 * @see
 * @since 1.0
 */
public class Matrix {
	private int rows, columns;
	private int[][] elements;
	
	/**
	 * Matrix 构造空矩阵
	 * @param m	  行数
	 * @param n  列数
	 */
	public Matrix (int m, int n) {
		this.elements = new int[m][n];
		this.rows = m;
		this.columns = n;
	}
	/**
	 * Matrix 构造空矩阵
	 * @param n 行数列数均为n
	 */
	public Matrix (int n) {
		this(n, n);
	}
	/**
	 * Matrix 构造以参数value为数据的矩阵
	 * @param m  行数
	 * @param n  列数
	 * @param value	插入二维数组参数
	 */
	public Matrix (int m, int n, int[][] value) {
		this(m, n);
		for(int i = 0; i < value.length && i < m; i++)
			for(int j = 0; j < value[i].length && j < n; j++)
				this.elements[i][j] = value[i][j];
	}
	//获取行数
	public int getRows () {
		return this.rows;
	}
	//获取列数
	public int getColumns () {
		return this.columns;
	}
	//获取
	public int get (int i, int j) {
		if(i < this.rows 
			&& i >= 0 
			&& j >= 0 
			&& j < this.columns)
			return elements[i][j];
		throw new IndexOutOfBoundsException("i=" + i + ",j=" + j);
	}
	//插入
	public void set (int i, int j, int x) {
		if(i < this.rows 
			&& i >= 0 
			&& j >= 0 
			&& j < this.columns)
			elements[i][j] = x;
		else throw new IndexOutOfBoundsException("i=" + i + ",j=" + j);
	}
	public String toString() {
		String str = " 矩阵"+this.getClass().getName()+"("+this.rows+"x"+this.columns+"):\n";
		for (int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++)
				str+=String.format("%6d", this.elements[i][j]);
			str+="\n";
		}
		return str;
	}
	//重新设置矩阵为m、n列，若参数指定的行较大，则扩容，并赋值原矩阵数据
	public void setRowsColumns (int m, int n) {
		if(m > 0 && n > 0){
			if(m > this.elements.length || n > this.elements[0].length){
				int[][] source = this.elements;
				this.elements = new int[m][n];
				for(int i = 0; i < m; i++)
					for(int j = 0; j < n; j++)
						elements[i][j] = source[i][j];
			}
			this.rows = m;
			this.columns = n;
		}
		//else throw new IllegalArgumentException("不能小于零：i=" + i + ",j=" + j);
	}
}