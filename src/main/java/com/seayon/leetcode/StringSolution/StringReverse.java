package com.seayon.leetcode.StringSolution;

import org.junit.Test;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/26 13:33
 * @Description
 */
public class StringReverse {
/*	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}*/

	public String reverseString(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			char t = chars[i];
			chars[i] = chars[chars.length -i - 1];
			chars[chars.length - i -1] = t;
		}
		return new String(chars);
		//return new StringBuilder(s).reverse().toString();
	}

	@Test
	public void t() {
		System.out.println(reverseString("hello"));
	}
}
