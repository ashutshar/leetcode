package org.example.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/description/
public class TopologicalSortKahnsAlgo {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        createAdjacencyList(numCourses, prerequisites, adjList);
        int[] indegrees = prepareIndegree(adjList, numCourses);
        List<Integer> answer = topoSort(adjList, indegrees);
        if (answer.size() != numCourses) {
            return new int[0];
        } else {
            //int[] arr = new int[numCourses];
            int[] arr = answer.stream().mapToInt(Integer::intValue).toArray();
            return arr;
        }
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        createAdjacencyList(numCourses, prerequisites, adjList);
        int[] indegrees = prepareIndegree(adjList, numCourses);
        List<Integer> answer = topoSort(adjList, indegrees);
        if (answer.size() == numCourses) {
            return true;
        } else {
            return false;
        }
    }

    public static void createAdjacencyList(int numCourses, int[][] prerequisites, List<List<Integer>> adjList) {
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }

    public static int[] prepareIndegree(List<List<Integer>> adjList, int numCourses) {
        int[] indegrees = new int[numCourses];
        for (List<Integer> list : adjList) {
            for (int i: list) {
                indegrees[i]++;
            }
        }
        return indegrees;
    }

    public static List<Integer> topoSort(List<List<Integer>> adjList, int[] indegrees) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int current = queue.poll();
            answer.add(current);
            List<Integer> nextNodes = adjList.get(current);
            for (int i: nextNodes) {
                indegrees[i]--;
                if(indegrees[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] preq = new int[][]{{1,0}};
        int[] arr = findOrder(2, preq);
        System.out.println(Arrays.toString(arr));
    }
}
