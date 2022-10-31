package com.ayachinene.leetcode.common;

public class P481 {
    static class Solution {
        public int magicalString(int n) {
            int res = 1;
            if (n < 4)
                return res;

            int[] s = new int[n];
            s[0] = 1; s[1] = 2; s[2] = 2;
            int i = 2;
            int j = 3;
            while (j < n) {
                int size = s[i];
                int num = 3 - s[j - 1];
                while (size > 0 && j < n) {
                    s[j++] = num;
                    if (num == 1)
                        ++res;
                    --size;
                }
                ++i;
            }
            return res;
        }
    }
}
