package com.ayachinene.leetcode.common;

import com.ayachinene.leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.ayachinene.leetcode.util.Utils.*;

class P2Test {

    @Test
    void testAddTwoNumbers() {
        P2.Solution s = new P2.Solution();
        assertAll(() -> {
            assertTrue(ListNode.equals(s.addTwoNumbers(parseIntList("2,4,3"), parseIntList("5,6,4")), parseIntList("7,0,8")));
        }, () -> {
            assertTrue(ListNode.equals(s.addTwoNumbers(parseIntList("0"), parseIntList("0")), parseIntList("0")));
        }, () -> {
            assertTrue(ListNode.equals(s.addTwoNumbers(parseIntList("9,9,9,9,9,9,9"), parseIntList("9,9,9,9")), parseIntList("8,9,9,9,0,0,0,1")));
        });
    }
}