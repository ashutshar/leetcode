package org.example;

import java.util.*;

public class LongestSubArrayKSum {
    public static int longestSubsetWithZeroSum(ArrayList<Integer> arr) {

        Map<Integer, Integer> map  = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum = sum + arr.get(i);
            map.put(sum, i);
        }
        int maxLen = 0;
        sum = 0;
        int length = 0;
        if (map.containsKey(0)) {
            maxLen = map.get(0) + 1;
        }
        for(int i = 0; i < arr.size(); i++) {
            sum = sum + arr.get(i);
            if (map.containsKey(sum) && map.get(sum) != i) {
                length = map.get(sum) - i;
            }
            if (maxLen < length){
                maxLen = length;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, -1, 4, -4));
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, -1, 2, -2));
        System.out.println(longestSubsetWithZeroSum(arr));
        System.out.println(longestSubsetWithZeroSum(arr1));
    }
}
