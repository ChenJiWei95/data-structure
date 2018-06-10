package com.chen.tree.BinaryTree;

/**
 * <b>二叉树结点实体类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年6月
 * @param <T>
 */
public class BinaryNode<T>{
	public T data;
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	public BinaryNode(T data){
		this(data, null , null);
	}
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("(").append("data=").append(data);
		if(left != null)
			sb.append(",").append("left=").append(left.toString());
		if(right != null)
			sb.append(",").append("right=").append(right.toString());
		return sb.append(")").toString();
	}
	public boolean isLeaf(){
		return this.left == null && this.right == null;
	}
}