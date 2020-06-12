package com.chen.list.linked;
/**
 * <b>循环双链表线性表接口</b>
 * @author 威
 * <br>2017年10月1日 下午2:22:43
 * @since 1.0
 * @param <E>
 */
public interface CirADTList<E> {
	public boolean isEmpty();
	
	/**
	 * 返回长度 
	 * @return
	 * int
	 * @since 1.0
	 */
	public int size();
	
	/**
	 * 返回第index个元素
	 * @param index
	 * 			从1开始
	 * @return
	 * E
	 * @since 1.0
	 */
	public E get(int index);
	
	/**
	 * 获取末尾元素
	 * <p>	 
	 * @return
	 * DoubleNode<E>
	 * @see
	 * @since 1.0
	 */
	public E getLastNode();
	
	/**
	 * 设置第index个元素为E
	 * @param index
	 * @param e
	 * void
	 * @since 1.0
	 */
	public void set(int index, E e);
	/**
	 * 放回线性表中所有元素的描述
	 * <p>	 
	 * @return
	 * String
	 * @since 1.0
	 */
	public String toString();
	/**
	 * 插入e元素作为第index个元素 
	 * @param index
	 * @param e
	 * @return
	 * Node<E>
	 * @see
	 * @since 1.0
	 */
	public DoubleNode<E> insert(int index, E e);
	
	/**
	 * 插入e元素作为第index个元素
	 * @param e
	 * @return
	 * Node<E>
	 * @since 1.0
	 */
	public DoubleNode<E> insert(E e);
	
	/**
	 * 删除第index为元素并返回被删除元素
	 * @param index
	 * @return
	 * E
	 * @since 1.0
	 */
	public DoubleNode<E> remove(int index);
	
	/**
	 * 删除首次出现与key相同的元素
	 * @param key
	 * @return
	 * E
	 * @since 1.0
	 */
	public DoubleNode<E> remove(E e);
	
	/**
	 * 删除末尾元素
	 * <p>	 
	 * @param e
	 * @return
	 * DoubleNode<E>
	 * @see
	 * @since 1.0
	 */
	public DoubleNode<E> removeLast();
	
	/**
	 * 删除线性表中的所有元素
	 * void
	 * @since 1.0
	 */
	public void clear();
	
	/**
	 * 查找key元素在线性表中的位置
	 * @param key
	 * @return
	 * Node<E>
	 * @since 1.0
	 */
	public DoubleNode<E> search(E key);
	
	/**
	 * 判断当前线性表是否存在元素key
	 * @param key
	 * @return
	 * boolean
	 * @since 1.0
	 */
	public boolean contains(E key);
	
	/**
	 *  插入不重复的元素
	 * @param e
	 * @return
	 * Node<E>
	 * @since 1.0
	 */
	public DoubleNode<E> insertDifferent(E e);
	
	
	/**
	 * 比较两个线性表中的所有元素是否相等
	 * @param obj
	 * @return
	 * boolean
	 * @since 1.0
	 */
	public boolean equals(Object obj);
	
	/**
	 * 添加list中的元素到线性表中
	 * @param list
	 * void
	 * @since 1.0
	 */
	public void addAll(java.util.List<E> list);
}
