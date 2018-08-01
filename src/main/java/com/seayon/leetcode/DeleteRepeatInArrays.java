package com.seayon.leetcode;

import java.util.Arrays;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/7/30 13:27
 * @Description
 */
public class DeleteRepeatInArrays {
	public static void main(String[] args) {
		int[] a = new int[]{1,1,2};
		int n  = new DeleteRepeatInArrays().removeDuplicates(a);
		System.out.println(Arrays.toString(a));
		System.out.println(n);
	}


	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int t = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[t] != nums[i]) {
				t++;
				nums[t] = nums[i];
			}
		}
		return t + 1;
	}
}
