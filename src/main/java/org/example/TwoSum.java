package org.example;

import java.util.*;
import java.util.stream.Collectors;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], Arrays.asList(i));
            } else {
                List<Integer> currList = new ArrayList<>(map.get(nums[i]));
                currList.add(i);
                map.put(nums[i], currList);
            }
        }
        int nextIndex = -1;
        for (int i : nums) {
            if (map.containsKey(target-i)) {

                List<Integer> list = map.get(target-i);
                for (int j : list) {
                    if (j != i) {
                        nextIndex = j;
                        break;
                    }
                }
            }
            if (nextIndex != -1) {
                return new int[]{i, nextIndex};
            }
        }
        return new int[]{-1, -1};
    }
}
