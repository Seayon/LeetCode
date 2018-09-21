package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Version 1.0
 * @author: ÕÔÐñÑô
 * @Date: 2018/9/21 9:49
 * @Description Êý×é¼Ó 1
 */
public class PlusOne {
	/*public int[] plusOne(int[] digits) {
		int last = digits.length - 1;
		for (int i = last; i >= 0 && (i == last || digits[i] > 9); i--) {
			if (i == last) {
				digits[i] += 1;
			}
			if (digits[i] > 9 && i > 0) {
				digits[i] = 0;
				digits[i - 1] += 1;
			}
		}
		if (digits[0] == 10) {
			int[] r = new int[digits.length + 1];
			r[0] = 1;
			digits[0] = 0;
			for (int i = 1; i < r.length; i++) {
				r[i] = digits[i-1];
			}
			digits = r;
		}
		return digits;
	}*/
	public int[] plusOne(int[] digits) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < digits.length; i++) {
			stringBuffer.append(digits[i]);
		}
		long a = Long.parseLong(new String(stringBuffer));
		a+=1;
		String b = String.valueOf(a);
		int[] r = new int[b.length()];
		for (int i = 0; i < b.length(); i++) {
			r[i] =  Character.getNumericValue(b.charAt(i));
		}
		return r;
	}
	@Test
	public void test() {
		long start = System.nanoTime();
		int[] a = plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
		System.out.println(Arrays.toString(a));
		long end = System.nanoTime();
		System.out.println(end - start);
	}
}
