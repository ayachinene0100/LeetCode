package com.ayachinene.leetcode.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P46 {

    static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            int len = arrangement(nums.length);
            List<List<Integer>> res = new ArrayList<>(len);
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            for (int i = 1; i < len; ++i) {
                nextPermutation(nums);
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            }
            return res;
        }

        private int arrangement(int n) {
            int res = 1;
            for (int i = 2; i <= n; ++i)
                res *= i;
            return res;
        }

        private void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1])
                i--;
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j])
                    j--;
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        private void reverse(int[] array, int start) {
            int left = start, right = array.length - 1;
            while (left < right)
                swap(array, left++, right--);
        }
    }
}
