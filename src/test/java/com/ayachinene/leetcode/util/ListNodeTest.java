package com.ayachinene.leetcode.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void test() {
        ListNode node = new ListNode();
        assertAll(() -> { assertEquals(0, node.val); },
                () -> { assertNull(node.next); }
        );
    }
}