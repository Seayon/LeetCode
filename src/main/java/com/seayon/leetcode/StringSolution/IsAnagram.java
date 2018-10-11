package com.seayon.leetcode.StringSolution;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/10/11 16:01
 * @Description
 */
public class IsAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		HashMap<Character, Integer> hashMapS = new HashMap<>();
		for (char c : chars) {
			if (hashMapS.containsKey(c)) {
				int temp = hashMapS.get(c);
				temp++;
				hashMapS.put(c, temp);
			}else{
				hashMapS.put(c, 1);
			}
		}
		for (char c : chart) {
			if (hashMapS.containsKey(c)) {
				int temp = hashMapS.get(c);
				if (temp <= 0) {
					return false;
				}else{
					temp --;
					hashMapS.put(c, temp);
				}
			}else{
				return false;
			}
		}
		return true;
	}
	@Test
	public void test(){
		System.out.println(isAnagram("aacc", "ccac"));
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
		System.out.println(isAnagram("ab", "a"));
	}
}
