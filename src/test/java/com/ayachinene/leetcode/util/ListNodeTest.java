package com.ayachinene.leetcode.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.ayachinene.leetcode.util.Utils.*;

class ListNodeTest {

    @Test
    void test() {
        ListNode node = new ListNode();
        assertAll(() -> { assertEquals(0, node.val); },
                () -> { assertNull(node.next); }
        );
    }

    @Test
    void testEquals() {
        assertAll(() -> {
            assertTrue(ListNode.equals(parseIntList(""), parseIntList("")));
        }, () -> {
            assertTrue(ListNode.equals(parseIntList("1,2,3"), parseIntList("1,2,3")));
        }, () -> {
            assertTrue(ListNode.equals(parseIntList("1"), parseIntList("1")));
        }, () -> {
            assertFalse(ListNode.equals(parseIntList("1,2,3"), parseIntList("1,2,3,4")));
        }, () -> {
            assertFalse(ListNode.equals(parseIntList("1"), parseIntList("")));
        }, () -> {
            assertFalse(ListNode.equals(parseIntList("1,2,3"), parseIntList("1,3,3")));
        });
    }
}