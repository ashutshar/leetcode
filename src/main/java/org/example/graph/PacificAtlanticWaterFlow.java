package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

//https://leetcode.com/problems/pacific-atlantic-water-flow/submissions/
public class PacificAtlanticWaterFlow {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                AtomicBoolean po = new AtomicBoolean(false);
                AtomicBoolean ao = new AtomicBoolean(false);
                if (!visited[i][j]) {
                    dfs(i, j, visited, heights, po, ao, directions);
                }
                if (po.get() && ao.get()) {
                    answer.add(Arrays.asList(i, j));
                }
            }
        }
        return answer;

    }

    public static void dfs(int i, int j, boolean[][] visited, int[][] heights, AtomicBoolean po, AtomicBoolean ao, int[][] directions) {
        visited[i][j] = true;
        if (i == 0 || j == 0) {
            po.set(true);
        }

        if (i == heights.length - 1 || j == heights[0].length - 1) {
            ao.set(true);
        }
        if (po.get() && ao.get()) {
            visited[i][j] = false;
            return;
        }
        for (int count = 0 ; count < directions.length; count++) {
            int newI = i + directions[count][0];
            int newJ = j + directions[count][1];
            if (validIndex(newI, newJ, heights) && !visited[newI][newJ] && heights[newI][newJ] <= heights[i][j]) {
                dfs(newI, newJ, visited, heights, po, ao, directions);
            }
        }
        visited[i][j] = false;
    }

    public static boolean validIndex(int i, int j, int[][] heights) {
        if (i < 0 || i > heights.length-1 || j < 0 || j > heights[0].length - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> ans = pacificAtlantic(heights);
        for (List<Integer> arr : ans) {
            System.out.println(Arrays.toString(arr.toArray()));
        }
    }
}

