README
====
本文件用于描述红黑树的实现和一些关于红黑树的知识点

****

|Author|威|
|---|---
|E-mail|Jelly.K.Wang@qq.com
|引用|[引用自][cnsd1]

****

## 特性

1.每个节点是黑色或者红色

2.根节点是黑色

3.每个叶子节点（NIL）是黑色

4.如果一个节点时红色，那么它的子节点必须是黑色

5.从一个节点到该节点的子孙节点的所用路径上包含相同数目的黑节点

#### 注意：

1.特性3中的叶子节点，是只为空（NIL或NULL）的节点

2.特性5，确保没有一条路径会比其他路径长出两倍。因而，红黑树是相对是接近平衡的二叉树

红黑树示意图如下：

![红黑树示意图][rbtree]

## 应用

红黑树的应用比较广泛，主要是用它来存储有序的数据，它的时间复杂度是O(lgn)，效率非常之高。
例如，Java集合中的TreeSet和TreeMap，C++ STL中的set、map，以及Linux虚拟内存的管理，都是通过红黑树去实现的。

## 时间复杂度和相关证明

* 红黑树的时间复杂度为: O(lgn)

* 相关证明请看[引用自][cnsd1]

## 红黑树的操作

#### 左旋


![左旋示意图][rbtree-left] 

#### 右旋

![右旋示意图][rbtree-right]

#### 添加

#### 删除

[cnsd1]:http://www.cnblogs.com/skywang12345/p/3245399.html "引用自"
[rbtree]:https://images0.cnblogs.com/i/497634/201403/251730074203156.jpg
[rbtree-left]:https://images0.cnblogs.com/i/497634/201403/251733282013849.jpg
[rbtree-right]:https://images0.cnblogs.com/i/497634/201403/251735527958942.jpg