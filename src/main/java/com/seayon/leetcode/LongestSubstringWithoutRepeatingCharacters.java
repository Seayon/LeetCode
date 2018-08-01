package com.seayon.leetcode;

import java.util.HashMap;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/7/30 12:05
 * @Description
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		int n1 = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt");
		int n2 = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb");
		int n3 = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");
		int n4 = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
	}

	public int lengthOfLongestSubstring(String s) {
		int n = 0, start = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char t = s.charAt(i);
			if (!map.containsKey(t) || map.get(t) < start) {
				map.put(t, i);
				n = i - start + 1 > n ? i - start + 1 : n;
			} else {
				start = map.get(t) + 1;
				map.put(t, i);
			}
		}
		return n;
	}
}
