package com.seayon.leetcode;

import com.seayon.commons.ListNode;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/7/30 9:26
 * @Description
 */
public class TwoNumbersSumList {
	public static void main(String[] args) {
		ListNode listNodel1 = new ListNode(5);
		//ListNode listNodel2 = new ListNode(5);
		//ListNode listNodel3 = new ListNode(5);
		//listNodel1.next = listNodel2;
		//listNodel2.next = listNodel3;

		ListNode listNodem1 = new ListNode(5);
		//ListNode listNodem2 = new ListNode(5);
		//ListNode listNodem3 = new ListNode(3);
		//listNodem1.next = listNodem2;
		//listNodem2.next = listNodem3;

		ListNode listNode = new TwoNumbersSumList().addTwoNumbers(listNodel1, listNodem1);
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
		//	两数之和
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNodeResult = new ListNode(0);
		ListNode listNodel1Temp = l1;
		ListNode listNodel2Temp = l2;
		ListNode listNodeResultTemp = listNodeResult;
		int tempAdd = 0;
		while (listNodel1Temp != null || listNodel2Temp != null) {
			int val1 = listNodel1Temp == null ? 0 : listNodel1Temp.val;
			int val2 = listNodel2Temp == null ? 0 : listNodel2Temp.val;
			int val = val1 + val2 + tempAdd;
			tempAdd = val / 10;//取整数，作为进位，下一轮相加所用的
			listNodeResultTemp.next = new ListNode(val % 10);//求余数，作为本位留下来的
			listNodeResultTemp = listNodeResultTemp.next;
			//继续指向下一位的操作
			if (listNodel1Temp != null) {
					listNodel1Temp = listNodel1Temp.next;
			}
			if (listNodel2Temp != null) {
					listNodel2Temp = listNodel2Temp.next;
			}
		}
		if (tempAdd > 0) {
			listNodeResultTemp.next = new ListNode(tempAdd);
		}
		return listNodeResult.next;
	}
}
