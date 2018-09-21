package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/19 15:54
 * @Description 350. 两个数组的交集 II
 */
public class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Boolean> num1Map = new HashMap<>();
		HashMap<Integer, Boolean> num2Map = new HashMap<>();
		HashMap<Integer, Boolean> resultMap = new HashMap<>();

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]&&!(num1Map.containsKey(i)||num2Map.containsKey(j))) {
					num1Map.put(i, true);
					num2Map.put(j,true);
					resultMap.put(i, true);
					break;
				}
			}
		}
		int i = 0;
		int[] r = new int[resultMap.size()];
		for(int key:resultMap.keySet())
		{
			r[i]= nums1[key];
			i++;
		}
		return r;
	}

	@Test
	public void test() {
		int[] num2 = new int[]{2,1,2,1};
		int[] num1 = new int[]{2,2};

		int[] r = intersect(num1,num2);
		System.out.println(Arrays.toString(r));
	}
}
