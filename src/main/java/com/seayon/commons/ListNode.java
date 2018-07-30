package com.seayon.commons;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/7/30 9:33
 * @Description 链表节点的定义
 */
public class ListNode {
	public int val;
	/**
	 * 指针域，Java中对象都是引用类型，对象的名称其实就是指向这个对象的指针
	 */
	public ListNode next;

	public ListNode(int x) {
		this.val = x;
	}

}
