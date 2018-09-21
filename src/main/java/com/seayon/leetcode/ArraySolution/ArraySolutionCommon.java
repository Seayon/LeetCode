package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/19 11:25
 * @Description
 */
public class ArraySolutionCommon {
	public boolean containsDuplicate(int[] nums){
		HashMap<Integer, Boolean> temp = new HashMap<Integer, Boolean>();
		boolean r = false;
		for (int num : nums) {
			if (temp.containsKey(num)) {
				r =  true;
				break;
			}else{
				temp.put(num, true);
			}
		}
		return r;
	}

	/**
	 * 136. 只出现一次的数字
	 * @param a
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
		int result=0;
		for(int i:nums){
			result=result^i;
		}
		return result;
	}
	@Test
	public void test() {
		//System.out.println(singleNumber(new int[]{}));
		System.out.println(singleNumber(new int[]{1,0,1}));
		System.out.println(singleNumber(new int[]{7, 5, 5, 4, 4, 4}));
		System.out.println(singleNumber(new int[]{2, 2, 2, 2, 5}));
		System.out.println(singleNumber(new int[]{3, 4, 3, 4, 5}));
	}
}
