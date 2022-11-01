package com.ayachinene.leetcode.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1662Test {

    @Test
    void testArrayStringAreEqual() {
        P1662.Solution s = new P1662.Solution();
        assertAll(() -> {
            String[] word1 = new String[] { "ab", "c" };
            String[] word2 = new String[] { "a", "bc" };
            assertTrue(s.arrayStringsAreEqual(word1, word2));
        }, () -> {
            String[] word1 = new String[] { "a", "cb" };
            String[] word2 = new String[] { "ab", "c" };
            assertFalse(s.arrayStringsAreEqual(word1, word2));
        }, () -> {
            String[] word1 = new String[] { "abc", "d", "defg" };
            String[] word2 = new String[] { "abcddefg" };
            assertTrue(s.arrayStringsAreEqual(word1, word2));
        });
    }

}