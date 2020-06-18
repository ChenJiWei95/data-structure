package com.chen.matrix.ext;

import com.chen.list.linked.Node;
import com.chen.list.linked.sing.SinglyList;
import com.chen.list.seq.SepList;
import com.chen.matrix.Triple;

/**
 * <b>链式矩阵存储  运用于稀疏矩阵压缩，只存非零</b>
 * 描述:<br>
 * @author 威 
 * <br>2018年6月1日 下午10:55:39 
 * @since 1.0
 */
public class LinkedMatrix {
	private int rows, columns;
	//行指针
	private SepList<SinglyList<Triple>> rowlist;
	public LinkedMatrix (int m, int n) {
		if(m >= 0 && n >= 0){
			this.rows = m;
			this.columns = n;
			this.rowlist = new SepList<SinglyList<Triple>>();
			for (int i = 0; i < m; i++)
				this.rowlist.insert(new SinglyList<Triple>());//顺序表尾插入
		}else 
			throw new IllegalArgumentException("矩阵的行、列不能为负: m=" + m + ", n=" + n);
	}
	
	public LinkedMatrix (int n) {
		this(n, n);
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
			&& i < this.rows 
			&& j >= 0
			&& j < this.columns){
			SinglyList<Triple> link = this.rowlist.get(i);
			//如果此时要存的三元组是零值那么删除已有的三元组
			if(tri.value == 0)
				link.remove(tri);
			else {
				//是否存在--存在修改值，不存在直接插入
				int index;
//				System.out.println("set 调用 search：");
				if((index = link.search(tri)) >= 0){
					link.set(index, tri);
				}
				else link.insert(tri);
			}
		}
		else 
			throw new IllegalArgumentException("三元组行、列不能为负或者操出存储范围:i=" + i + ", j=" + j);
	}
	public int get (int i, int j) {
		
		if(i >= 0 
			&& i < this.rows
			&& j >= 0
			&& j < this.columns){
			int index;
			System.out.println("get: "+i+", "+j);
			if((index = this.rowlist.get(i).search(new Triple(i, j , 0))) >= 0){
				return this.rowlist.get(i).get(index).value;
			}
			return 0;
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
		System.out.println("矩阵" + this.getClass().getSimpleName()+"("+rows+"X"+columns+")");
		for(int i = 0; i < this.rowlist.size(); i++){
			Node<Triple> p = this.rowlist.get(i).head.next;
			for(int j = 0; j < this.columns; j++){
				if(p != null && j==p.data.column){
					System.out.print(String.format("%4d", p.data.value));
					p = p.next;
				}
				else System.out.print(String.format("%4d", 0));
			}
			System.out.println();
		}
	}
	//设置矩阵行列数
	public void setRowsColumns(int m, int n){
		if(m >= 0 & n >= 0){
			if(m > this.rows)
				for(int i = this.rows; i < m; i++)
					this.rowlist.insert(new SinglyList<Triple>());
			this.rows = m;
			this.columns = n;
		}
		else throw new IllegalArgumentException("行、列数不能为负：m="+m+", n="+n);
	}
	//矩阵相加
	public void addAll(LinkedMatrix mat){
		if(this.rows == mat.rows){
			for(int i = 0; i< this.rows; i++){
				SinglyList<Triple> addList = mat.rowlist.get(i);
				SinglyList<Triple> list = this.rowlist.get(i);
				for(int j = 0; j < this.columns; j++){
					list.get(j).add(addList.get(j));
				}
			}
		}
		else throw new IllegalArgumentException("两个矩阵数不相等，不能相加");
	}
	
	public static void main(String[] args){
		LinkedMatrix lm = new LinkedMatrix(4, 5);
		lm.set(0, 0, 1);
		lm.set(0, 1, 7);
		lm.set(0, 2, 7);
		lm.set(0, 3, 7);
		lm.set(0, 4, 7);
		
		lm.set(2, 0, 1);
		lm.set(3, 1, 7);
		lm.set(1, 2, 7);
		lm.set(1, 2, 8);
		lm.set(1, 1, 8);
		
		LinkedMatrix lm2 = new LinkedMatrix(4, 5);
		lm2.set(0, 0, 1);
		lm2.set(0, 1, 7);
		lm2.set(0, 2, 7);
		lm2.set(0, 3, 7);
		lm2.set(0, 4, 7);
		
		lm2.set(2, 0, 1);
		lm2.set(3, 1, 7);
		lm2.set(1, 2, 7);
		lm2.set(1, 2, 8);
		lm2.set(1, 1, 8);
		
		lm.addAll(lm2);
		
		System.out.println(lm.toString());
		lm.printMatrix();
		System.out.println("");
		System.out.println(lm.get(2, 0));
	}
	
}