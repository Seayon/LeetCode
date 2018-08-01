package com.seayon.leetcode;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/7/30 13:08
 * @Description
 */
public class MedianofTwoSortedArrays {
	public static void main(String[] args){
		MedianofTwoSortedArrays mn = new MedianofTwoSortedArrays();
		int[]nums1 = new int[]{1,2};
		int[]nums2 = new int[]{2};
		double m1 = mn.findMedianSortedArrays(nums1, nums2);
		System.out.println(m1);

		int[]nums11 = new int[]{1,2};
		int[]nums22 = new int[]{3,4};
		double m2 = mn.findMedianSortedArrays(nums11, nums22);
		System.out.println(m2);

		int[]nums13 = new int[]{1,4,5};
		int[]nums23 = new int[]{2,3,4};
		double m3 = mn.findMedianSortedArrays(nums13, nums23);
		System.out.println(m3);



	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double d = 0;

		return d;
	}
}
