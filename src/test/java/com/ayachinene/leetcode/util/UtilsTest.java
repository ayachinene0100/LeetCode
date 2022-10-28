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
                () -> assertArrayEquals(new int[0], parseIntArray(null)),
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
            String s = "";
            ListNode list = parseIntList(s);
            assertNull(list);
        }, () -> {
            ListNode list = parseIntList(null);
            assertNull(list);
        }, () -> {
            String s = "1";
            ListNode list = parseIntList(s);
            assertNotNull(list);
            assertEquals(1, list.val);
            assertNull(list.next);
        }, () -> {
            String s = "1, 2, 3";
            ListNode list = parseIntList(s);
            ListNode node1 = list;
            assertNotNull(node1);
            assertEquals(1, node1.val);
            assertNotNull(node1.next);
            ListNode node2 = node1.next;
            assertEquals(2, node2.val);
            assertNotNull(node2.next);
            ListNode node3 = node2.next;
            assertEquals(3, node3.val);
            assertNull(node3.next);
        });
    }

    @Test
    void testSplit() {
        Method split = ReflectionUtils.findMethod(Utils.class, "split", String.class, String.class).get();
        split.setAccessible(true);
        assertAll(() -> {
            assertThrows(Exception.class, () -> { split.invoke(Utils.class, null, null); });
        }, () -> {
            assertThrows(Exception.class, () -> { split.invoke(Utils.class, null, ""); });
        }, () -> {
            assertThrows(Exception.class, () -> { split.invoke(Utils.class, null, " "); });
        }, () -> {
            assertEquals(0, ((String[]) split.invoke(Utils.class, null, ",")).length);
        }, () -> {
            assertEquals(0, ((String[]) split.invoke(Utils.class, "   ", ",")).length);
        }, () -> {
            assertEquals(4, ((String[]) split.invoke(Utils.class, " 1, 2,3,   4,", ",")).length);
        }, () -> {
            assertEquals(1, ((String[]) split.invoke(Utils.class, "1", ",")).length);
        });
    }
}