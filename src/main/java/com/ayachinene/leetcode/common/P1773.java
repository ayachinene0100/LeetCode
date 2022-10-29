package com.ayachinene.leetcode.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1773 {
    static class Solution {

        private static final Map<String, Integer> m;
        static {
            m = new HashMap<>(3);
            m.put("type", 0);
            m.put("color", 1);
            m.put("name", 2);
        }

        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int res = 0;
            for (List<String> item : items) {
                if (item.get(m.get(ruleKey)).equals(ruleValue))
                    res++;
            }
            return res;
        }
    }
}
