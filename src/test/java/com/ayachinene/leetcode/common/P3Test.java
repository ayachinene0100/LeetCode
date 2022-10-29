package com.ayachinene.leetcode.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P3Test {

    @Test
    void testLengthOfLongestSubstring() {
        P3.Solution s = new P3.Solution();
        assertAll(() -> {
            assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        }, () -> {
            assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        }, () -> {
            assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        }, () -> {
            assertEquals(1, s.lengthOfLongestSubstring(" "));
        }, () -> {
            assertEquals(3, s.lengthOfLongestSubstring("abc"));
        });
    }

}