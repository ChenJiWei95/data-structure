package com.chen.list.seq;
/**
 * <b>线性表接口</b>
 * @author 威
 * <br>2017年10月1日 下午2:22:43
 * @since 1.0
 * @param <E>
 */
public interface ADTList<E> {
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
	 * @return
	 * E
	 * @since 1.0
	 */
	public E get(int index);
	
	/**
	 * 设置第index个元素为E
	 * @param index
	 * 		从0开始
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
	 * 			从0开始
	 * @param e
	 * @return 返回插入位置
	 * Node<E>
	 * @see
	 * @since 1.0
	 */
	public int insert(int index, E e);
	
	/**
	 * 插入e元素作为第index个元素
	 * 			从0开始
	 * @param e
	 * @return 返回插入位置
	 * Node<E>
	 * @since 1.0
	 */
	public int insert(E e);
	
	/**
	 * 删除第index为元素并返回被删除元素
	 * @param index
	 * 			从0开始
	 * @return
	 * E
	 * @since 1.0
	 */
	public E remove(int index);
	
	/**
	 * 删除首次出现与key相同的元素
	 * @param key
	 * @return
	 * E
	 * @since 1.0
	 */
	public E remove(E e);
	
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
	public int search(E key);
	
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
	 * @return 返回插入位置
	 * Node<E>
	 * @since 1.0
	 */
	public int insertDifferent(E e);
	
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
