package com.seayon.leetcode.StringSolution;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/9/26 14:48
 * @Description
 */
public class ReverseInteger {
	public int reverse(int x) {
		boolean p = false;
		if (x == -2147483648) {
			return 0;
		}
		if (x < 0) {
			x = -x;
			p = true;
		}
		String s = String.valueOf(x);
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			char t = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = t;
		}
		s = new String(chars);
		String position = p ? "-" : "";
		long l = Long.valueOf(position + s);
		if (l < -2147483648 || l > 2147483647) {
			return 0;
		}
		return Integer.valueOf(position + s);
	}

	@Test
	public void test() {
		System.out.println(reverse(-121));
		System.out.println(reverse(120000));
		System.out.println(reverse(12011));
		System.out.println(reverse(12021));
		System.out.println(reverse(-2147483648));
		System.out.println(reverse(-12340));
		System.out.println(reverse(-114748648));
		System.out.println(reverse(-2147483412));
	}
}

