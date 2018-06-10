package com.chen.tree.BinaryTree;
/**
 * <b>二叉树实现类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年6月
 * @param <T>
 */
public class BinaryTreeExt<T> implements BinaryTree<T>{
	public BinaryNode<T> root;
	public BinaryTreeExt(){
		root = null;
	}
	public boolean isEmpty(){
		return this.root == null;
	}
	public int size(){
		return 0;
	}
	public int height(){
		return 0;
	}
	public void preorder(){
		preorder(this.root);
		System.out.println();
	}
	public void preorder(BinaryNode<T> p){
		if(p != null){
			System.out.println(p.data.toString() + "");
			preorder(p.left);
			preorder(p.right);
		}
	}
	public void inorder(){
		inorder(this.root);
		System.out.println();
	}
	public void inorder(BinaryNode<T> p){
		if(p != null){
			inorder(p.left);
			System.out.println(p.data.toString() + "");
			inorder(p.right);
		}
	}
	public void postorder(){
		postorder(this.root);
		System.out.println();
	}
	public void postorder(BinaryNode<T> p){
		if(p != null){
			postorder(p.left);
			postorder(p.right);
			System.out.println(p.data.toString() + "");
		}
	}
	public void levelorder(){
		
	}
	public void levelorder(BinaryNode<T> p){
		
	}
	public BinaryNode<T> insert(T x){
		return this.root = new BinaryNode<T>(x, this.root, null);
	}
	//插入x为p的左右孩子， leftChild：true（左） false（右）
	//p原有的左右孩子将作为x的左右孩子
	public BinaryNode<T> insert(BinaryNode<T> p, T x, boolean leftChild){
		if(p == null || x == null) return null;
		if(isEmpty()) return insert(x);
		if(leftChild)
			return p.left = new BinaryNode<T>(x, p.left, null);
		return p.right = new BinaryNode<T>(x, null, p.right);
	}
	public void remove(BinaryNode<T> parent, boolean leftChild){
		if(leftChild) parent.left = null;
		else parent.right = null;
	}
	public void clear(){
		this.root = null;
	}
	public BinaryNode<T> search(T key){
		return null;
	}
	@SuppressWarnings("unused")
	private BinaryNode<T> search(T key, BinaryNode<T> p){
		if(p != null) {
			if(p.data.equals(key))
				return p;
			return search(key, p.left);
		}
		return null;
	}
	public boolean contains(T ket){
		return true;
	}
	public int level(T key){
		return 0;
	}
	public String toString(){
		return toString(this.root);
	}
	public String toString(BinaryNode<T> p){
		if(p == null)
			return "^";
		return p.data.toString() + toString(p.left) + toString(p.right);
	}
}