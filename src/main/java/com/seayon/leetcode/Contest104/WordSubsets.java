package com.seayon.leetcode.Contest104;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/30 10:46
 * @Description 916. 单词子集 未完成
 */
public class WordSubsets {
	public List<String> wordSubsets(String[] A, String[] B) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			char[] wordChars = A[i].toCharArray();
			for (int j = 0; j < B.length; j++) {
				boolean tag = true;
				char[] testChars = B[j].toCharArray();
				HashMap<Integer, Boolean> map = new HashMap<>();
				//验证当前单词和匹配组的子集关系是否成立
				for (int k = 0; k < testChars.length; k++) {
					for (int z = 0; z < wordChars.length; z++) {
						if (testChars[k] == wordChars[z] && !map.containsKey(z)) {
							map.put(z, true);
							break;
						} else if (z == wordChars.length - 1) {
							tag = false;
						}
					}

					if (!tag) {
						break;
					}
				}
				if (!tag) {
					break;
				}
				if (j == B.length - 1) {
					result.add(A[i]);
				}
			}
		}
		return result;
	}

	@Test
	public void test() {
		List<String> result = wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}
		, new String[]{"ec","oc","ceo"});
		for (String s : result) {
			System.out.println(s);
		}

	}
}
