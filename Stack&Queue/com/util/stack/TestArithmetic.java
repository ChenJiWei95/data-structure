package com.util.stack;
/**
 * 
 * <b>实现一列数学式的运算 <b>
 * 输入算式的格式:(举例)
 *  a+(b+c)
 *  {a+(b+c)}*2
 * @author 威 
 * <br>2018年3月23日 下午12:17:28 
 *
 */
public class TestArithmetic {
	
	
	public static Double doStart(String formula){
		return pushStack(formula);
		// 0;
	}
	
	//将算式入栈
	private static Double pushStack(String formula) {
		ArrayStackEX<String> stackVal = new ArrayStackEX<String>(40) ;
		int len = formula.length();
		int selectIndex = len - 1;
		int endIndex = len;
		while(selectIndex != -1){
			char c = formula.charAt(selectIndex) ;
			if(c == '-' || c == '+' || c == '/' || 
					c == '*'){
				if(selectIndex+1 != endIndex)
					stackVal.push(formula.substring(selectIndex+1, endIndex).trim());
				stackVal.push(String.valueOf(formula.charAt(selectIndex)));
				endIndex = selectIndex ;
			}else if(c == '(' || c == ')' || c == '{' || c == '}'){
				if(selectIndex+1 != endIndex)
					stackVal.push(formula.substring(selectIndex+1, endIndex).trim());
				stackVal.push(String.valueOf(formula.charAt(selectIndex)));
				endIndex = selectIndex;
			}
			selectIndex--;
			
		}
		stackVal.push(formula.substring(0,endIndex));
		System.out.println("原算式入栈结果：" + stackVal.toString());
		ArrayStackEX<String> stackOpraVal = new ArrayStackEX<String>(20) ;
		return operation(stackVal, stackOpraVal);
	}
	//运算
	public static Double operation(ArrayStackEX<String> stackVal, ArrayStackEX<String> stackOpraVal){
		String item;
		while(!stackVal.isEmpty()){
			item = stackVal.pop();
			if(item.equals("}")) {
				fristPriority(stackOpraVal);
			}
			else if(item.equals(")")) {
				secondPriority(stackOpraVal);
			}
			else if(item.equals("*") || item.equals("/")) {
				stackOpraVal.push(item);
				String nextItem = stackVal.peek();
				if(!(nextItem.equals("(") || nextItem.equals("{"))){
					stackOpraVal.push(stackVal.pop());
					thirdPriority(stackOpraVal);
				}
			}
			else stackOpraVal.push(item);
		}
		ArrayStackEX<String> tempStack = new ArrayStackEX<String>();
		while(!stackOpraVal.isEmpty()){
			tempStack.push(stackOpraVal.pop());
		}
		return end(tempStack);
	}
	public static Double end(ArrayStackEX<String> stackOpraVal){
		String item;
		String temp = "";
		Double result = 0.0;
		System.out.println("求结果时候的栈："+stackOpraVal.toString());
		if(stackOpraVal.size() == 1){
			return Double.valueOf(stackOpraVal.pop());
		}
		while(!stackOpraVal.isEmpty()){
			item = stackOpraVal.pop();
			if(item.equals("+") || item.equals("-")){
				result = Calcula(item, Double.valueOf(temp), Double.valueOf(stackOpraVal.pop()));
				temp = String.valueOf(result);
			}else temp = item;
		}
		return result;
	}
	//大括号优先策略
	public static void fristPriority(ArrayStackEX<String> stackOpraVal){
		String item;
		ArrayStackEX<String> stackTempVal = new ArrayStackEX<String>(20);
		while(true){
			item = stackOpraVal.pop();
			if(item.equals("{")){
				deal(stackOpraVal, stackTempVal);
				break;
			}
			stackTempVal.push(item);
		}
	}
	//小括号优先策略
	public static void secondPriority(ArrayStackEX<String> stackOpraVal){
		String item;
		ArrayStackEX<String> stackTempVal = new ArrayStackEX<String>(20);
		while(true){
			item = stackOpraVal.pop();
			if(item.equals("(")){
				deal(stackOpraVal, stackTempVal);
				break;
			}
			stackTempVal.push(item);
		}
	}

	public static void deal(ArrayStackEX<String> stackOpraVal, ArrayStackEX<String> stackTempVal) {
		String temp = String.valueOf(end(stackTempVal));
		String nextItem = stackOpraVal.peek();
		if(nextItem.equals("*") || nextItem.equals("/")) 
			stackOpraVal.push(String.valueOf(Calcula(stackOpraVal.pop(), Double.valueOf(stackOpraVal.pop()), Double.valueOf(temp))));
		else stackOpraVal.push(temp);
	}
	//乘除优先策略
	public static void thirdPriority(ArrayStackEX<String> stackOpraVal){
		String num2 = stackOpraVal.pop();
		String sysbom = stackOpraVal.pop();
		String num1 = stackOpraVal.pop();
		stackOpraVal.push(String.valueOf(Calcula(sysbom, Double.valueOf(num1), Double.valueOf(num2))));
	}

	//基本的加减乘除算数方法 返回计算值
	public static Double Calcula(String sysbom, Double num1, Double num2){
		switch(sysbom){
			case "+": return num1+num2;
			case "-": return num1-num2;
			case "*": return num1*num2;
			case "/": return num1/num2;
			default :
				return 0.0;
		}
	}
	public static void main(String[] args){
		System.out.println(doStart("2*{3*(3+6)}/3+2"));
	}
}
