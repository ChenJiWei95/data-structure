package com.chen.search.blocksearch;

import com.chen.search.binarysearch.SortedArray;

/**
 * <b>基于索引的分块查找</b>
 * <p>
 * 描述:<br>
 * 通过索引表获取对应的块进行查找
 * @author 威 
 * <br>2018年6月13日 下午7:40:42 
 */
public class KeyWord {
	//有序的关键字表
	private String[] keywords = {
		"abstract","assert", "boolean", "byte", "case", "catch", "char", "class", "continue", "default", "do"
		, "double", "else", "extends", "false", "final", "finally", "float", "for", "if", "implements"
		, "import", "instanceof", "int", "interface", "long", "native"
	};
	
	private IndexItem[] index;
	
	public KeyWord(){
		index = new IndexItem[23];
		for(int i = 0, j = 0; i < index.length && j < keywords.length; i++){
			char ch = (char)('a' + i);
			if(keywords[j].charAt(0) > ch)
				index[i] = new IndexItem(ch, -1, -1);
			else{
				int begin = j++;
				while(j < keywords.length && keywords[j].charAt(0) == ch)
					j++;
				index[i] = new IndexItem(ch, begin, j-1);
			}
		}
	}
	
	public boolean isKeyword(String str){
		int i = str.charAt(0)-'a';
		/*System.out.println(index[i].begin + "-" + index[i].end);*/
		return i >= 0 
				&& i < index.length 
				&& index[i].begin != -1 
				&& new SortedArray().binarySearch(keywords, index[i].begin, index[i].end, str) >= 0;
	}
	
	/**
	 * <b>索引项</b>
	 * <p>
	 * 描述:<br>
	 * 索引表中的项
	 * @author 威 
	 * <br>2018年6月13日 下午7:44:31 
	 */
	private class IndexItem implements Comparable<IndexItem>{
		char first;
		int begin, end;
		/**
		 * 构造一个索引项
		 * @param first	首字符
		 * @param begin	开始
		 * @param end	结束
		 */
		public IndexItem(char first, int begin, int end){
			this.first = first;
			this.begin = begin;
			this.end = end;
		}
		public String toString(){
			return first + " " + begin + " " + end;
		}
		@Override
		public int compareTo(IndexItem o) {
			return this.first - o.first;
		}
	}
}
