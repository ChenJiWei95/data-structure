package com.chen.matrix.test;

import com.chen.matrix.ext.Matrix;

public class Test{
	@TestEtc
	public void init(){
		int value[][] = {{1},{2,3},{4,2},{8,7,1}};
		Matrix m = new Matrix(4, 3, value);
		System.out.println(m.toString());
	}
}