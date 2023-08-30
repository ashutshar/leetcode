package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
    int value = Integer.MIN_VALUE;
    static class Pair{
        int first;
        int second;
        Pair(int i, int j) {
            this.first = i;
            this.second = j;
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> answer = new HashSet<>();
        Map<Long, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long sum = nums[i] + nums[j];
                if (map.containsKey(sum)) {
                    List<Pair> pairs = map.get(sum);
                    if ((nums[pairs.get(0).first] != nums[i] && nums[pairs.get(0).second] != nums[j]) && (nums[pairs.get(0).first] != nums[j] && nums[pairs.get(0).second] != nums[i])) {
                        map.get(sum).add(new Pair(i, j));
                    }
                }
                else {
                    List<Pair> pairs = new ArrayList<>();
                    pairs.add(new Pair(i, j));
                    map.put((long)(nums[i] + nums[j]), pairs);
                }
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long sum = nums[i] + nums[j];
                if(map.containsKey(target - sum)) {
                    List<Pair> pairs = map.get(target - sum);
                    for (Pair pair : pairs) {
                        if (pair.first != i && pair.first != j
                                && pair.second != i && pair.second != j) {
                            List<Integer> arr = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[pair.first], nums[pair.second]));
                            Collections.sort(arr);
                            answer.add(arr);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        int[] arr = GearBeam.solution(new int[]{4,30,55,56});
        System.out.println(Arrays.toString(arr));
    }
}
