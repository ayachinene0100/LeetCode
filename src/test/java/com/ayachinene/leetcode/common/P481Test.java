package com.ayachinene.leetcode.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P481Test {

    @Test
    void testMagicalString() {
        P481.Solution s = new P481.Solution();
        assertAll(() -> {
            assertEquals(3, s.magicalString(6));
        }, () -> {
            assertEquals(1, s.magicalString(1));
        });
    }

}