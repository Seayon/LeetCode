package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/17 16:06
 * @Description
 */
public class Rotate {
	public void rotate(int[] nums, int k) {
		for (int j = 0; j < k; j++) {
			if (nums.length > 0) {
				int last = nums[nums.length - 1];
				for (int i = nums.length - 1; i > 0; i--) {
					nums[i] = nums[i - 1];
				}
				nums[0] = last;
			}
		}
	}

	@Test
	public void test() {
		int[] a = new int[]{1};
		rotate(a, 100);

		System.out.println(Arrays.toString(a));
		System.out.println("".equals(""));
	}
}
