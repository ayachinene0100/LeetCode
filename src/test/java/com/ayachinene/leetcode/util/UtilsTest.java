package com.ayachinene.leetcode.util;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static com.ayachinene.leetcode.util.Utils.*;

class UtilsTest {

    @Test
    void testParseIntArray() throws IllegalAccessException {
        assertAll(() -> assertArrayEquals(new int[0], parseIntArray("")),
                () -> assertArrayEquals(new int[] { 1 }, parseIntArray("1")),
                () -> assertArrayEquals(new int[] { 1 }, parseIntArray("1,")),
                () -> assertArrayEquals(new int[] { 1, 2, 3 }, parseIntArray("1, 2, 3")),
                () -> assertArrayEquals(new int[] { 1, 2, 3, 4 }, parseIntArray("1, 2, 3, 4")),
                () -> assertThrows(NumberFormatException.class, () -> { parseIntArray(",1, 2 ,"); }),
                () -> assertThrows(NumberFormatException.class, () -> { parseIntArray("1.2.3"); }),
                () -> assertThrows(NumberFormatException.class, () -> { parseIntArray("a,b,c，3"); })
        );
    }

    @Test
    void testParseIntList() {
        assertAll(() -> {
            assertNull(parseIntList(""));
        }, () -> {
            ListNode actual = parseIntList("1");
            ListNode expected = new ListNode(1);
            assertTrue(ListNode.equals(expected, actual));
        }, () -> {
            ListNode actual = parseIntList("1,2,3");
            ListNode expected = new ListNode(1);
            ListNode n1, n2, n3;
            n1 = expected;
            n2 = new ListNode(2);
            n3 = new ListNode(3);
            n1.next = n2;
            n2.next = n3;
            assertTrue(ListNode.equals(expected, actual));
        });
    }

    @Test
    void testSplit() {
        Method split = ReflectionUtils.findMethod(Utils.class, "split", String.class, String.class).get();
        split.setAccessible(true);
        assertAll(() -> {
            assertEquals(0, ((String[]) split.invoke(Utils.class, "   ", ",")).length);
        }, () -> {
            assertEquals(4, ((String[]) split.invoke(Utils.class, " 1, 2,3,   4,", ",")).length);
        }, () -> {
            assertEquals(1, ((String[]) split.invoke(Utils.class, "1", ",")).length);
        }, () -> {
            assertEquals(3, ((String[]) split.invoke(Utils.class, "1a,2.,3", ",")).length);
        }, () -> {
            assertThrows(Exception.class, () -> { split.invoke(Utils.class, "1a,2.,3", " ,"); });
        }, () -> {
            assertThrows(Exception.class, () -> { split.invoke(Utils.class, "1a,2.,3", " "); });
        });
    }
}