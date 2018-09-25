package com.seayon.leetcode.ArraySolution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Version 1.0
 * @author: ’‘–Ò—Ù
 * @Date: 2018/9/21 17:11
 * @Description
 */
public class IsValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		HashMap<String, HashMap<Character, Integer>> hashMapHashMap = new HashMap<>();
		for (int i = 0; i < board.length; i++) {
			char[] in = board[i];
			for (int j = 0; j < in.length; j++) {
				if (!hashMapHashMap.containsKey("row" + i)) {
					hashMapHashMap.put("row" + i, new HashMap<>());
				}
				if (!hashMapHashMap.containsKey("column" + j)) {
					hashMapHashMap.put("column" + j, new HashMap<>());
				}
				int bi = i / 3;
				int bj = j / 3;
				if (!hashMapHashMap.containsKey("box" + bi + bj)) {
					hashMapHashMap.put("box" + bi+bj, new HashMap<>());
				}
				HashMap<Character, Integer> row = hashMapHashMap.get("row" + i);
				HashMap<Character, Integer> column = hashMapHashMap.get("column" + j);
				HashMap<Character, Integer> box = hashMapHashMap.get("box" + bi + bj);

				if ('.'!=board[i][j]&&(row.containsKey(board[i][j]) || column.containsKey(board[i][j]) || box.containsKey(board[i][j]))) {
					return false;
				} else {
					row.put(board[i][j], i);
					column.put(board[i][j], j);
					box.put(board[i][j], i);
				}
			}
		}
		return true;
	}

	@Test
	public void test() {
		char[][] a = {
				{'.', '.', '.', '.', '7', '.', '.', '.', '.'},
				{'.', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '.', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		System.out.println(isValidSudoku(a));

	}
}
