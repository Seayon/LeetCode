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
		for (int i = 0; i < matrix.length / 2; i++) {
			int[] r1 = matrix[i];
			int rowLast1 = r1[r1.length - 1 - i];
			for (int j = r1.length - 1 - i; j > i; j--) {
				r1[j] = r1[j - 1];
			}
			int columnLast1 = matrix[r1.length - 1 - i][r1.length - 1 - i];
			for (int j = r1.length - 1 - i; j > i; j--) {
				matrix[j][r1.length - 1 - i] = matrix[j - 1][r1.length - 1 - i];
			}
			matrix[i + 1][r1.length - 1 - i] = rowLast1;

			int rowLast2 = matrix[matrix[i].length - 1 - i][i];
			for (int j = i; j < matrix[i].length - 1 - i; j++) {
				matrix[matrix[i].length - 1 - i][j] = matrix[matrix[i].length - 1 - i][j + 1];
			}
			matrix[r1.length - 1 - i][r1.length - 1 - i - 1] = columnLast1;

			for (int j = i; j < matrix[i].length -1 - i; j++) {
				matrix[j][i] = matrix[j + 1][i];
			}
			matrix[matrix[i].length - 1 - i -1][i] = rowLast2;
		}
	}

	@Test
	public void test() {
		int[][] a = new int[][]{
				{15, 3, 2, 5, 1, 222},
				{14, 3, 4, 1, 333, 4},
				{12, 6, 8, 9, 5, 6},
				{19, 2, 3, 4, 5, 2},
				{1616, 7, 0, 1, 6, 4},
				{111, 999, 0, 1, 6, 777}
		};
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
