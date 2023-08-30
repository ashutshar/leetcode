package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;


//https://leetcode.com/problems/course-schedule-ii/description/
public class TopologicalSortDFS {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<Integer>());
        AtomicBoolean ab = new AtomicBoolean(false);
        createAdjacencyMatrix(adjList, numCourses, prerequisites);

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> currTraversal = new ArrayList<>();
            if (visited[i] == 0) {
                dfs(i, visited, adjList, stack, ab, currTraversal);
            }
        }
        if (ab.get()) {
            return new int[0];
        }
        int[] ans = new int[numCourses];
        int k = 0;
        while (!stack.isEmpty()) {
            ans[k] = stack.pop();
            k++;
        }
        return ans;
    }

    public static void createAdjacencyMatrix(List<List<Integer>> adjList, int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }

    public static void dfs(int i, int[] visited, List<List<Integer>> adjList, Stack<Integer> stack, AtomicBoolean ab, List<Integer> currTraversal) {
        visited[i] = 1;
        currTraversal.add(i);
        List<Integer> current = adjList.get(i);
        for (Integer integer : current) {
            if (currTraversal.contains(integer)) {
                ab.set(true);
            }
            if (visited[integer] == 0) {
                dfs(integer, visited, adjList, stack, ab, currTraversal);
            }
        }
        currTraversal.remove(currTraversal.size()-1);
        stack.push(i);
    }

    public static void main(String[] args) {
        //int[][] prereq = new int[][]{{2,0},{1,0},{3,1},{3,2},{1,3}};
        int[][] prereq = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        int[] arr = findOrder(4, prereq);
        System.out.println(Arrays.toString(arr));
    }
}
