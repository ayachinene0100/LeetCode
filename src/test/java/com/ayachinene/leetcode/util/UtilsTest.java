package com.ayachinene.leetcode.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void parseIntArray() throws IllegalAccessException {
        assertAll(() -> assertArrayEquals(Utils.parseIntArray(""), new int[0]),
                () -> assertArrayEquals(Utils.parseIntArray(null), new int[0]),
                () -> assertArrayEquals(Utils.parseIntArray("   "), new int[0]),
                () -> assertArrayEquals(Utils.parseIntArray(" 1 "), new int[] { 1 }),
                () -> assertArrayEquals(Utils.parseIntArray("1 ,"), new int[] { 1 }),
                () -> assertArrayEquals(Utils.parseIntArray("1 ,   2,3"), new int[] { 1, 2, 3 }),
                () -> assertArrayEquals(Utils.parseIntArray("   1, 2, 3,4 "), new int[] { 1, 2, 3, 4 }),
                () -> assertThrows(NumberFormatException.class, () -> { Utils.parseIntArray(",1,2,"); }),
                () -> assertThrows(NumberFormatException.class, () -> { Utils.parseIntArray("1.2.3"); }),
                () -> assertThrows(NumberFormatException.class, () -> { Utils.parseIntArray("a,b,c"); })
        );
    }
}