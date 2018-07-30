package com.seayon.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/7/25 9:26
 * @Description
 */
public class TwoNumbersSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				result[0] = i;
				result[1] = map.get(target - nums[i]);
				break;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		twoSum(new int[]{2, 1, 9, 4, 4, 56, 90, 3}, 8);
	}
}
