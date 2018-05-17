package com.util.test;


import com.util.stack.ArrayStackEX;
import com.util.stack.Stack;
/**
 * 
 * <b>对顺序栈Stack类的测试<b>
 * @author 威 
 * <br>2017年9月30日 下午6:49:09 
 *
 */
public class Test {
	public static void main(String[] args){
		Stack<Integer> stack = new ArrayStackEX<Integer>() ;
		/*System.out.println("当前是否为空"+stack.empty()) ; */
		stack.push(12) ;
		stack.push(13) ;
		stack.push(14) ;
		stack.push(15) ;
		stack.push(16) ;
		stack.push(17) ;
		stack.push(18) ;
		stack.push(19) ;
		/*System.out.println("调用顶栈"+stack.peek()) ;
		System.out.println("当前是否为空"+stack.empty()) ; 
		System.out.println("调出顶栈"+stack.pop()) ;
		System.out.println("当前是否为空"+stack.empty()) ; */
		while(!stack.isEmpty()){
			System.out.println("调出顶栈"+stack.pop()) ;
		}
	}
}
