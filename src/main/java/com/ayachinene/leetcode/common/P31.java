package com.ayachinene.leetcode.common;

public class P31 {
    static class Solution {

        public void nextPermutation(int[] nums) {
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
