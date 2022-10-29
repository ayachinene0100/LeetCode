package com.ayachinene.leetcode.common;

import com.ayachinene.leetcode.util.ListNode;

public class P2 {
    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // head为头指针，head.next返回结果
            ListNode head = new ListNode();
            ListNode tail = head;
            int c = 0;
            while (l1 != null || l2 != null) {
                int a = l1 == null ? 0 : l1.val;
                int b = l2 == null ? 0 : l2.val;
                int sum = a + b + c;
                c = sum / 10;
                ListNode node = new ListNode(sum % 10);
                tail.next = node;
                tail = node;
                if (l1 != null)
                    l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;
            }
            if (c > 0) {
                tail.next = new ListNode(c);
            }
            return head.next;
        }
    }
}
