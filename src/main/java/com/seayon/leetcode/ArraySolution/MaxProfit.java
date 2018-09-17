package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/17 11:07
 * @Description
 */
public class MaxProfit {
	public int maxProfit(int[] prices) {
		int r = 0;
		int min = prices.length==0?0:prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			} else {
				if (i < prices.length - 1) {
					if (prices[i] > prices[i + 1]) {
						r += (prices[i] - min);
						min = prices[i + 1];
					}
				} else {
					r+=(prices[i]-min);
				}
			}
		}
		return r;
	}

	@Test
	public void test() {
		System.out.println(maxProfit(new int[]{}));
		System.out.println(maxProfit(new int[]{1}));
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
		System.out.println(maxProfit(new int[]{1, 4, 3, 4, 5}));
	}
}
