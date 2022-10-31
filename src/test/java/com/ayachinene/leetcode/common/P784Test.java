package com.ayachinene.leetcode.common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P784Test {

    @Test
    void testLetterCasePermutation() {
        P784.Solution s = new P784.Solution();
        assertAll(() -> {
            List<String> expected = new ArrayList<>();
            expected.add("a1b2");
            expected.add("a1B2");
            expected.add("A1b2");
            expected.add("A1B2");
            assertEquals(new HashSet<>(expected), new HashSet<>(s.letterCasePermutation("a1b2")));
        }, () -> {
            List<String> expected = new ArrayList<>();
            expected.add("3z4");
            expected.add("3Z4");
            assertEquals(new HashSet<>(expected), new HashSet<>(s.letterCasePermutation("3z4")));
        });
    }
}