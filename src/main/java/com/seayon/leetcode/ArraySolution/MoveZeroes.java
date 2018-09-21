package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Version 1.0
 * @author: ’‘–Ò—Ù
 * @Date: 2018/9/21 11:11
 * @Description
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 1;
		while (i < nums.length && nums[i] != 0) {
			i++;
			j++;
		}
		while (j < nums.length) {
			if (nums[j] == 0) {
				j++;
			} else {
				nums[i] = nums[j];
				nums[j] = 0;
				j++;
				i++;
			}
		}
	}

	@Test
	public void test() {
		long start = System.nanoTime();
		//int[] a = new int[]{1};
		//int[] a = new int[]{0,1,0,3,12};
		//int[] a = new int[]{1, 0, 0, 1, 2, 3, 4, 0, 0, 3, 2};
		int[] a = new int[]{1, 0, 0, 2,2,2,2,2,2,2};
		moveZeroes(a);
		System.out.println(Arrays.toString(a));
		long end = System.nanoTime();
		System.out.println(end - start);
	}
}
