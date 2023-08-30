package org.example;

import java.util.*;

public class LongestCommonSubsequence {
    public static int longestConsecutive1(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            start = i;
            while (i < nums.length-1 && ((nums[i+1] - nums[i] == 1) || nums[i+1] == nums[i])) {
                if (nums[i+1] - nums[i] == 1) {
                    count++;
                }
                i++;
            }
            count = count+1;
            if(maxCount < count) {
                maxCount = count;
            }
            count = 0;
        }
        return maxCount;

    }


    public static int longestConsecutive(int[] nums) {
        //Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[nums.length];
        int start = 0;
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int searchNumber = nums[i];
            if (arr[map.get(searchNumber)] != -1) {
                //start = i;
                while (map.containsKey(searchNumber)) {
                    arr[map.get(searchNumber)] = -1;
                    searchNumber = searchNumber + 1;
                    count++;
                }
                if(maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            }
            }

        return maxCount;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(arr));
    }
}
