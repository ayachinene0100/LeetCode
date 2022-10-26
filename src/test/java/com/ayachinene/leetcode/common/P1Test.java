package com.ayachinene.leetcode.common;

import com.ayachinene.leetcode.util.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1Test {
    @Test
    void twoSum() {
        P1.Solution s = new P1.Solution();
        assertAll(() -> {
            assertArrayEquals(s.twoSum(Utils.parseIntArray("2, 7, 11, 15"), 9), new int[] { 0, 1 });
            assertArrayEquals(s.twoSum(Utils.parseIntArray("3, 2, 4"), 6), new int[] { 1, 2 });
            assertArrayEquals(s.twoSum(Utils.parseIntArray("3, 3"), 6), new int[] { 0, 1 });
        });
    }
}