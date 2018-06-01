package com.chen.matrix.ext;
/**
 * <b>链式矩阵存储</b>
 * 描述:<br>
 * @author 威 
 * <br>2018年6月1日 下午10:55:39 
 * @since 1.0
 */
public class LinkedMatrix {
	private int rows, columns;
	//行指针
	private SeqList<PolySinglyList<Triple>> rowlist;
	public LinkedMatrix (int m, int n) {
		if(m >= 0 && n >= 0){
			this.rows = m;
			this.columns = n;
			this.rowlist = new SeqList<PolySinglyList<Triple>>();
			for (int i = 0; i < m; i++)
				this.rowlist.insert(new PolySinglyList<Triple>());//顺序表尾插入
		}else 
			throw new IllegalArgumentException("矩阵的行、列不能为负: m=" + m + ", n=" + n);
	}
	
	public LinkedMatrix (int n) {
		this(m, n);
	}
	
	public LinkedMatrix (int n, int m, Triple[] tris) {
		this(m, n);
		for(int i = 0; i < tris.length; i++)
			this.set(tris[i]);
	}
	
	public int getRows () {
		return this.rows;
	}
	public int getColumns () {
		return this.columns;
	}
	public void set (int i, int j, int x) {
		this.set(new Triple(i, j, x));
	}
	public void set (Triple tri) {
		int i = tri.row, j = tri.column;
		if(i >= 0 
			&& i <= this.rows 
			&& j >= 0
			&& j <= this.columns){
			SortedSinglyList<Triple> link = this.rowlist.get(i);
			//如果此时要存的三元组是零值那么删除已有的三元组
			if(tri.value == 0)
				link.remove(tri);
			else {
				//是否存在--存在修改值，不存在直接插入
				Node<Triple> find = link.search(tri);
				if(find != null)
					find.data.value = tri.value;
				else link.insert(tri);
			}
		}
		else 
			throw new IllegalArgumentException("三元组行、列不能为负或者操出存储范围:i=" + i + ", j=" + j);
	}
	public int get (int i, int j) {
		if(i >= 0 
			&& i <= this.rows 
			&& j >= 0 
			&& j <= this.columns){
			Node<Triple> find = this.rowlist.get(i).search(new Triple(i, j , 0));
			return (find != null) ? find.data : 0;
		}
		else throw new IllegalArgumentException("行、列不能为负或者操出存储范围:i=" + i + ", j=" + j);
	}
	public String toString () {
		String str = "";
		for(int i = 0; i < this.rowlist.size(); i++)
			str += i+" ->" + this.rowlist.get(i).toString() + "\n";
		return str;
	}
	//输出矩阵
	public void printMatrix () {
		System.out.println("矩阵" + this.getClass().getName()+"("+rows+"X"+columns+")");
		for(int i = 0; i < this.rowlist.size(); i++){
			Node<Triple> p = this.rowlist.get(i).head.next;
			for(int j = 0; j < this.columns; j++){
				if(p != null && j==p.data.column){
					System.out.println(String.format("%4d", p.data.value));
					p = p.next;
				}
				else System.out.println(String.format("%4d", 0));
			}
			System.out.println();
		}
	}
	//设置矩阵行列数
	public void setRowsColumns(int m, int n){
		if(m >= 0 & n >= 0){
			if(m > this.rows)
				for(int i = this.rows; i < m; i++)
					this.rowlist.insert(new PolySinglyList<Triple>());
			this.rows = m;
			this.columns = n;
		}
		else throw new IllegalArgumentException("行、列数不能为负：m="+m+", n="+n);
	}
	//矩阵相加
	public void addAll(LinkedMatrix mat){
		if(this.rows == mat.row){
			for(int i = 0; i< this.rows; i++)
				this.rowlist.get(i).addAll(mat.rowlist.get(i));
		}
		else throw new IllegalArgumentException("两个矩阵数不相等，不能相加");
	}
	
}