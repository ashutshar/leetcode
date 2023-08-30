package org.example.graph.unsolved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/description/
public class SortItemsByGroups {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n ; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        createAdjList(adjList, beforeItems, n);
        int[] indegree = prepareIndegree(adjList, n);
        List<Integer> ans = topoSortBasedOnGroup(adjList, indegree, group);
        if (ans.size() != n) {
            return new int[0];
        } else {
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

    }

    public void createAdjList(List<List<Integer>> adjList, List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> current = beforeItems.get(i);
            for (int j : current) {
                adjList.get(j).add(i);
            }
        }
    }

    public int[] prepareIndegree(List<List<Integer>> adjList, int n) {
        int[] indegree = new int[n];
        for (List<Integer> list: adjList) {
            for (int i : list) {
                indegree[i]++;
            }
        }
        return indegree;
    }

    public List<Integer> topoSortBasedOnGroup(List<List<Integer>> adjList, int[] indegree, int[] group) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            answer.add(current);
            List<Integer> nextNodes = adjList.get(current);
            List<Integer> notInSameGroup = new ArrayList<Integer>();
            for(int i : nextNodes) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    if (group[i] == group[current] ) {
                        queue.add(i);
                    } else {
                        notInSameGroup.add(i);
                    }
                }
            }
            queue.addAll(notInSameGroup);
        }
        return answer;
    }
}
