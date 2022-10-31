package com.ayachinene.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class P784 {
    static class Solution {

        public List<String> letterCasePermutation(String s) {
            List<StringBuilder> res = new ArrayList<>();

            char c = s.charAt(0);
            res.add(new StringBuilder().append(c));
            if (Character.isLetter(c))
                res.add(new StringBuilder().append(c ^ 32));

            for (int i = 1; i < s.length(); ++i) {
                c = s.charAt(i);
                if (Character.isLetter(c)) {
                    int oldSize = res.size();
                    for (int j = 0; j < oldSize; ++j)
                        res.add(new StringBuilder(res.get(j)));
                    for (int j = 0; j < oldSize; ++j) {
                        res.get(j).append(c);
                        res.get(j + oldSize).append(c ^ 32);
                    }
                } else
                    for (StringBuilder sb : res)
                        sb.append(c);
            }

            return res.stream().map(StringBuilder::toString).toList();
        }
    }
}
