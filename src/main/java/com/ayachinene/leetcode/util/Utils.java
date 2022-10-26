package com.ayachinene.leetcode.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class Utils {

    public static int[] parseIntArray(String s) {
        s = StringUtils.trimAllWhitespace(s);
        if (!StringUtils.hasLength(s))
            return new int[0];
        String[] nums;
        nums = s.split(",");
        return Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
    }
}
