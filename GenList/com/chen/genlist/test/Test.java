package com.chen.genlist.test;

import com.chen.genlist.GenList;
import com.chen.genlist.ext.GenListExt;
import com.chen.genlist.ext.GenList_String;

public class Test{
	@TestEtc
	public void test(){
		//测试广义表对象
		GenListExt<String> gList = new GenListExt<String>();
		GenListExt<String> javaList = new GenListExt<String>();
		
		javaList.insert("java SE");
		javaList.insert("java ME");
		GenListExt<String> javaEEList = new GenListExt<String>();
		javaEEList.insert("servlet");
		javaEEList.insert("jsp");
		javaEEList.insert("ssh");
		javaEEList.insert("ssm");
		javaList.insert(javaEEList);
		
		gList.insert(javaList);
		System.out.println(javaList.size());
		System.out.println(gList.depth());
		System.out.println(gList.toString());
		
		//测试广义表字符串创建广义表对象
		GenList_String gStr = new GenList_String();
		GenList<String> testList = gStr.create(gList.toString());
		System.out.println(testList.toString());
	}
}
