package com.seayon.leetcode.StringSolution;

import org.junit.Test;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/10/11 16:29
 * @Description
 */
public class IsPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int length = s.length() - 1;
		for (int i = 0; i < s.length() - 1; i++) {
			int l = s.charAt(i);
			if ((l >= 48 && l <= 57) || (l >= 65 && l <= 90) || (l >= 97 && l <= 122)) {
				for (int j = length; j > i; j--) {
					int r = s.charAt(j);
					if ((r >= 48 && r <= 57) || (r >= 65 && r <= 90) || (r >= 97 && r <= 122)) {
						if (l != r) {
							return false;
						}else {
							break;
						}
					}else {
						length --;
						continue;
					}
				}
				length --;
			} else {
				continue;
			}
		}
		return true;
	}

	@Test
	public void test() {
		System.out.println(isPalindrome("   "));
		System.out.println(isPalindrome("aba"));
		System.out.println(isPalindrome("abA"));
		System.out.println(isPalindrome("aaa"));
		System.out.println(isPalindrome("abba"));
		System.out.println(isPalindrome("11211"));
		System.out.println(isPalindrome("   "));
		System.out.println(isPalindrome("  "));
		System.out.println(isPalindrome(" "));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("rac acar"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("amanaplanacanalpanama"));
	}
}
