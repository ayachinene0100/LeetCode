package com.ayachinene.leetcode.util;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import java.util.Arrays;


public class Utils {

    private static final String SILENT_MSG = "";

    private static final String DEFAULT_DELIMITER = ",";

    public static int[] parseIntArray(String s) {
        return parseIntArray(s, DEFAULT_DELIMITER);
    }

    public static int[] parseIntArray(String s, String regex) {
        String[] nums = split(s, DEFAULT_DELIMITER);
        Assert.notNull(nums, SILENT_MSG);
        if (nums.length == 0)
            return new int[0];
        return Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
    }

    public static ListNode parseIntList(String s) {
        return parseIntList(s, DEFAULT_DELIMITER);
    }

    public static ListNode parseIntList(String s, String regex) {
        String[] nums = split(s, regex);
        Assert.notNull(nums, SILENT_MSG);
        int len = nums.length;
        if (len == 0)
            return null;
        ListNode head = new ListNode(Integer.parseInt(nums[0]));
        ListNode tail = head;
        for (int i = 1; i < len; ++i) {
            ListNode node = new ListNode(Integer.parseInt(nums[i]));
            tail.next = node;
            tail = node;
        }
        return head;
    }

    // 所有在s中的空格都会被忽略，所以regex不应该包含空格
    private static String[] split(String s, String regex) {
        Assert.hasLength(regex, SILENT_MSG);
        Assert.doesNotContain(regex, " ", SILENT_MSG);
        s = StringUtils.trimAllWhitespace(s);
        if (!StringUtils.hasLength(s))
            return new String[0];
        return s.split(regex);
    }

}
