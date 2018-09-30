package com.seayon.leetcode.Contest104;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/30 9:30
 * @Description
 */
public class HasGroupsSizeX {
	public boolean hasGroupsSizeX(int[] deck) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < deck.length; i++) {
			if (map.containsKey(deck[i])) {
				int t = map.get(deck[i]);
				t++;
				map.put(deck[i], t);
			} else {
				map.put(deck[i], 1);
			}
		}
		for (int x = 2; x < 10001; x++) {
			boolean tag = true;
			for (Integer c : map.values()) {
				if (c != x && c % x != 0) {
					tag = false;
				}
			}
			if (tag) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void test() {
		System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
		System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
		System.out.println(hasGroupsSizeX(new int[]{1}));
		System.out.println(hasGroupsSizeX(new int[]{1, 1}));
		System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
	}
}
