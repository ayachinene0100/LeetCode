package com.ayachinene.leetcode.util;

import org.jetbrains.annotations.NotNull;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import java.util.Arrays;


public class Utils {

    private static final String SILENT_MSG = "";

    private static final String DEFAULT_DELIMITER = ",";

    public static int @NotNull [] parseIntArray(@NotNull String s) {
        return parseIntArray(s, DEFAULT_DELIMITER);
    }

    public static int @NotNull [] parseIntArray(@NotNull String s, @NotNull String regex) {
        String[] nums = split(s, DEFAULT_DELIMITER);
        if (nums.length == 0)
            return new int[0];
        return Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
    }

    public static ListNode parseIntList(@NotNull String s) {
        return parseIntList(s, DEFAULT_DELIMITER);
    }

    public static ListNode parseIntList(@NotNull String s, @NotNull String regex) {
        String[] nums = split(s, regex);
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
    private static String @NotNull [] split(@NotNull String s, @NotNull String regex) {
        Assert.hasLength(regex, SILENT_MSG);
        Assert.doesNotContain(regex, " ", SILENT_MSG);
        s = StringUtils.trimAllWhitespace(s);
        if (!StringUtils.hasLength(s))
            return new String[0];
        return s.split(regex);
    }

}
