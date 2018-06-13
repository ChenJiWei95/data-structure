package com.chen.tree.BinaryTree;
/**
 * <b>二叉树接口</b>
 * @author 威 
 * <br>2018年6月
 * @param <T>
 */
public interface BinaryTree<T>{
	/**
	 * 二叉树是否为空
	 * <p>	 
	 * @return
	 * boolean
	 */
	boolean isEmpty();
	/**
	 * 返回二叉树结点的个数
	 * <p>	 
	 * @return
	 * int
	 */
	int size();
	/**
	 * 返回二叉树的高度
	 * <p>	 
	 * @return
	 * int
	 */
	int height();
	/**
	 * 先根次序遍历
	 * <p>	 
	 * void
	 */
	void preorder();
	/**
	 * 中根次序遍历
	 * <p>	 
	 * void
	 */
	void inorder();
	/**
	 * 后根次序遍历
	 * <p>	 
	 * void
	 */
	void postorder();
	/**
	 * 层次遍历
	 * <p>	 
	 * void
	 */
	void levelorder();
	/**
	 * 插入元素作为根结点并返回
	 * <p>	 
	 * @param x
	 * @return
	 * BinaryNode<T>
	 */
	BinaryNode<T> insert(T x);
	/**
	 * 给p插入一个孩子作为p的左或右孩子
	 * <p>	 
	 * @param p
	 * @param x
	 * @param leftChild
	 * @return
	 * BinaryNode<T>
	 */
	BinaryNode<T> insert(BinaryNode<T> p, T x, boolean leftChild);
	/**
	 * 删除parent结点的左或者右孩子
	 * <p>	 
	 * @param parent
	 * @param leftChild
	 * void
	 */
	void remove(BinaryNode<T> parent, boolean leftChild);
	
	/**
	 * 删除树的所有结点
	 * <p>	 
	 * void
	 */
	void clear();
	/**
	 * 先根次序遍历查找首个关键字为key的结点
	 * <p>	 
	 * @param key
	 * @return
	 * BinaryNode<T>
	 */
	BinaryNode<T> search(T key);
	/**
	 * 是否包含关键字为key元素
	 * <p>	 
	 * @param ket
	 * @return
	 * boolean
	 */
	boolean contains(T ket);
	/**
	 * 获取key元素所在的层次
	 * <p>	 
	 * @param key
	 * @return
	 * int
	 */
	int level(T key);
}