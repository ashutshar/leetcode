package org.example.recursion.backtrack;

import java.util.Arrays;
import java.util.List;

public class PrintAllPermutations {
    static int count = 0;
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        printArray(nums, 0, 0);
        return null;
    }

    public static void printArray(int[] nums, int start, int end) {
        if (start == end) {
            System.out.println("Count "+ count+":: Start "+ start+" Array -> " +Arrays.toString(nums));
            count++;
        }
        for (int i = start; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                printArray(nums, i+1, j);
                swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
