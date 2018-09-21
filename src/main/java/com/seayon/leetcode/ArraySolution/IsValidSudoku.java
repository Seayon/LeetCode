package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Version 1.0
 * @author: ’‘–Ò—Ù
 * @Date: 2018/9/21 17:11
 * @Description
 */
public class IsValidSudoku {
	public boolean isValidSudoku(char[][] board) {

		return true;
	}

	@Test
	public void test() {
		char[][] a = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
	}
}
