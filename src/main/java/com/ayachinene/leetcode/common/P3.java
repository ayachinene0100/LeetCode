package com.ayachinene.leetcode.common;

public class P3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            boolean[] exist = new boolean[128];
            // [i, j)
            int i = 0, j = 0;
            while (j < s.length()) {
                char c = s.charAt(j++);
                if (exist[c]) {
                    res = Math.max(res, j - i - 1);
                    while (s.charAt(i) != c)
                        exist[s.charAt(i++)] = false;
                    i++;
                }
                exist[c] = true;
            }
            return Math.max(res, j - i);
        }
    }
}
