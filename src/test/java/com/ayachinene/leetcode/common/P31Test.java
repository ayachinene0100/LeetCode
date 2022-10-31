package com.ayachinene.leetcode.common;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P31Test {

    @Test
    void testNextPermutation() {
        P31.Solution s = new P31.Solution();
        assertAll(() -> {
            int[] expected = new int[] { 1, 3, 2 };
            int[] actual = new int[] { 1, 2, 3 };
            s.nextPermutation(actual);
            assertArrayEquals(expected, actual);
        }, () -> {
            int[] expected = new int[] { 1, 2, 3 };
            int[] actual = new int[] { 3, 2, 1 };
            s.nextPermutation(actual);
            assertArrayEquals(expected, actual);
        }, () -> {
            int[] expected = new int[] { 1, 5, 1 };
            int[] actual = new int[] { 1, 1, 5 };
            s.nextPermutation(actual);
            assertArrayEquals(expected, actual);
        });
    }

}