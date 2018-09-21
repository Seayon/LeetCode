package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/21 16:30
 * @Description 1. Two Sum 两数之和
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] r = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i])!=null) {
				r[0] = i;
				r[1] = map.get(target-nums[i]);
				break;
			}
			map.put(nums[i],i);
		}
		return r;
	}

	@Test
	public void test() {
		int[] a = twoSum(new int[]{2, 1, 9, 4, 4, 56, 90, 3}, 8);
		//int[] a = twoSum(new int[]{3,2,4}, 6);
		//int[] a = twoSum(new int[]{2,5,5,11}, 10);
		System.out.println(Arrays.toString(a));
	}
}
