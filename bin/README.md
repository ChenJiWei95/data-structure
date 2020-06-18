队列
	Queue  接口
	SeqQueue  顺序队列
		取出复杂度O(1)
		插入在非扩容时复杂度O(1)、在扩容时复杂度O(n)
	LinkedQueue	链式队列
		取出复杂度O(1) 
		插入复杂度O(1)
	PriorityQueue 优先队列
		借助SortedCirDoubleList有序循环双链表实现队列的优先机制
栈 
	Stack 为接口
		public abstract boolean isEmpty() ;
		public abstract boolean push(E e) ;
		public abstract E peek() ;
		public abstract E pop() ;

	ArrayStackEX	以数组实现的栈
	NodeStackEX		链式实现
	LinkedStackEX	以LinkedList实现的栈
