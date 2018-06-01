package com.chen.genlist.ext;

import com.chen.genlist.GenList;
import com.chen.genlist.GenNode;

/**
 * <b>将广义表的字符串形式数据转换为GenListExt对象形式</b>
 * @author 威 
 * <br>2018年6月1日 下午10:42:11 
 * @since 1.0
 */
public class GenList_String{
	private static int i;

	public GenList<String> create(String genListStr){
		i = 0;
		return createSub(genListStr);
	}
	//创建一个空的广义表
	//循环广义表字符串
	//遇到','，跳过
	//遇到一般数据字符创建节点并累加一般数据字符作为此时创建的节点的数据
	//遇到'(' 创建一个节点，并将递归createSub()所得的子表复制给当前创建的子表
	//遇到')' 返回广义表对象
	public GenList<String> createSub(String genListStr){
		i++;
		GenListExt<String> glist = new GenListExt<String>();
		GenNode<String> p = glist.head;
		while(i < genListStr.length()){
			char ch = genListStr.charAt(i);
			switch(ch){
				case ',' : i++; break;
				case '(' : 
				{
					p.next = new GenNode<String>();
					p = p.next;
					p.child = createSub(genListStr);
					break;
				}
				case ')' : i++; return glist; 
				default : 
				{
					int j = i + 1;
					ch = genListStr.charAt(j);
					while(ch != '(' && ch != ',' && ch != ')')
						ch = genListStr.charAt(++j);
					p.next = new GenNode<String>(genListStr.substring(i, j));
					p = p.next;
					i = j;
				}
			}
		}
		return null;
	}
}