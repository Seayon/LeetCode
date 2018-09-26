package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/19 11:25
 * @Description
 */
public class ArraySolutionCommon {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Boolean> temp = new HashMap<Integer, Boolean>();
		boolean r = false;
		for (int num : nums) {
			if (temp.containsKey(num)) {
				r = true;
				break;
			} else {
				temp.put(num, true);
			}
		}
		return r;
	}

	/**
	 * 136. 只出现一次的数字
	 *
	 * @param
	 * @return
	 */
/*	public int singleNumber(int[] a){
		int r = a[0];
		for (int i = 0; i < a.length; i++) {
			r = a[i];
			boolean b = false;
			for (int j = 0; j < a.length; j++) {
				if (a[j] == r&&i!=j) {
					break;
				} else if (j == a.length - 1) {
					b = true;
				}
			}
			if (b) {
				break;
			}
		}
		return r;
	}*/
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i : nums) {
			result = result ^ i;
		}
		return result;
	}

	/**
	 * 旋转图像，矩阵旋转
	 *
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int arrayLength = matrix.length;
		//控制循环处理不超过前一半儿的行数
		for (int i = 0; i < arrayLength / 2; i++) {

			//一次处理一圈儿
			for (int j = i; j < arrayLength - i - 1; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[arrayLength - j - 1][i];
				matrix[arrayLength - j - 1][i] = matrix[arrayLength - i - 1][arrayLength - j - 1];
				matrix[arrayLength - i - 1][arrayLength - j - 1] = matrix[j][arrayLength - 1 - i];
				matrix[j][arrayLength - 1 - i] = t;
			}
		}

	}

	@Test
	public void test() {
		int[][] a = new int[][]{
				{1515, 3, 2, 5, 1, 222},
				{14, 3, 4, 1, 333, 4},
				{12, 6, 8, 9, 5, 6},
				{19, 2, 3, 4, 5, 2},
				{1616, 7, 0, 1, 6, 4},
				{111, 999, 0, 1, 6, 777}
		};
		System.out.println(a[1][2]);
		rotate(a);
		printArray(a);
		//System.out.println(singleNumber(new int[]{}));
		//System.out.println(singleNumber(new int[]{1,0,1}));
		//System.out.println(singleNumber(new int[]{7, 5, 5, 4, 4, 4}));
		//System.out.println(singleNumber(new int[]{2, 2, 2, 2, 5}));
		//System.out.println(singleNumber(new int[]{3, 4, 3, 4, 5}));
	}

	public void printArray(int[][] a) {
		System.out.println(new Date() + "打印数组-------");
		for (int i = 0; i < a.length; i++) {
			int[] b = a[i];
			System.out.println(Arrays.toString(b));
		}
	}
}
