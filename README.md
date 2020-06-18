数据结构  
====

### ListTable  
* 顺序存储  
* 链式存储    
[前往](ListTable "点击跳转")  

#### Stack  
顺序表实现栈  
链式表实现栈  
[前往](Stack&Queue "点击跳转")  

#### Queue  
顺序表实现队列  
链式表实现队列  
[前往](Stack&Queue "点击跳转")  

### Matrix(矩阵)
* Matrix
`简单存储`
* LinkedMatrix
`链式存储稀疏矩阵` 

* 特殊矩阵：   
	对称矩阵  
		矩阵中的元素满足  aij=aji    1≤i,j≤n  
	三角矩阵
		上（下）三角矩阵指矩阵的下（上）三角（不包括对角线）中的元素均为常数c或0的n阶矩阵
	对角矩阵
		矩阵中所有非0元素集中在主对角线为中心的区域中
* 稀疏矩阵  
	非0元素很少（≤ 5%）且分布无规律。
* 压缩存储的基本思路：   
	多个值相同的元素只分配一个存储空间。对零元素不分配存储空间。  
	对称矩阵有a(i,j)=a(j,i)。可以只存对角，那么得先判断是否为对称矩阵  
	三角矩阵，只存储上或者下三角  
	对角矩阵，只存储中间附近区域  
	稀疏矩阵非零分布没有规律，只存非零  
[前往](Matrix "点击前往") 

### GenList(广义表)  
* com.chen.genlist.ext.GenList_String  
`将广义表的字符串形式数据转换为GenListExt对象形式`  
* com.chen.genlist.ext.GenListExt  
`广义表实现类`  
[前往](GenList "点击前往") 

### Sort(排序算法)   
* 冒泡排序   
* 快速排序   
* 直接插入排序  
* 希尔排序  
* 选择排序  
* 归并排序  
* 基数排序  
* 堆排序   
[前往](Sort "点击前往")  

### tree(树)
* com.chen.tree.BinaryTree（二叉树）
* com.chen.tree.rbtree（[红黑树](tree/README.md "点击前往")）

### search(查找)
* com.chen.search.binarysearch
二分法查找   
条件:   
1.顺序存储    
2.查找列为有序   

* com.chen.search.blocksearch
索引块查找
[前往](search "点击前往")  
