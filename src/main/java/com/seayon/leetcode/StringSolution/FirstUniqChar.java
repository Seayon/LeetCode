package com.seayon.leetcode.StringSolution;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/26 16:47
 * @Description
 */
public class FirstUniqChar {
	public int firstUniqChar(String s) {
		if (s.length() == 1) {
			return 0;
		}
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {

			char tempChar = chars[i];

			for (int j = 0; j < chars.length; j++) {
				if (tempChar == chars[j] && j != i) {
					break;
				} else if (j == chars.length - 1) {
					if (i != j) {
						if (tempChar != chars[j]) {
							return i;
						}
					}else{
						return i;
					}
				}
			}

		}
		return -1;
	}

	@Test
	public void test() {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar("22"));
		System.out.println(firstUniqChar("2"));
		System.out.println(firstUniqChar("aadadaad"));
		System.out.println(firstUniqChar("dddccdbba"));
	}
}
