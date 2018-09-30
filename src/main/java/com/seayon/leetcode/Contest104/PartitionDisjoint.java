package com.seayon.leetcode.Contest104;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/30 9:59
 * @Description
 */
public class PartitionDisjoint {
	public int partitionDisjoint(int[] A) {
		for (int index = 1; index < A.length; index++) {
			int leftMax = A[0];
			for (int i = 0; i < index; i++) {
				if (leftMax < A[i]) {
					leftMax = A[i];
				}
			}
			int rightMin = A[index];
			for (int j = index; j < A.length ; j++) {
				if (A[j] < rightMin) {
					rightMin = A[j];
				}
			}
			if (leftMax <= rightMin) {
				return index;
			}
		}
		return A.length;
	}

	@Test
	public void test() {
		//System.out.println(partitionDisjoint(new int[]{90,47,69,10,43,92,31,73,61,97}));
		//System.out.println(partitionDisjoint(new int[]{8,7}));
		//System.out.println(partitionDisjoint(new int[]{6,7}));
		System.out.println(partitionDisjoint(new int[]{5, 6, 3, 8, 6}));
		//System.out.println(partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
		//System.out.println(partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
	}
}
