package org.example.graph;

//https://leetcode.com/problems/max-area-of-island/description/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int[][] visited = new int[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j] == 1 && visited[i][j]==0) {
                    int currLength = dfs(i, j, visited, directions, grid);
                    maxArea = Math.max(maxArea, currLength);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j, int[][] visited, int[][] directions, int[][] grid) {
        int maxLen = 1;
        visited[i][j] = 1;
        for (int count = 0; count < directions.length; count++) {
            int newI = i + directions[count][0];
            int newJ = j + directions[count][1];
            if (validIndex(newI, newJ, grid) && grid[newI][newJ] == 1 && visited[newI][newJ] == 0) {
                maxLen = maxLen + dfs(newI, newJ, visited, directions, grid);
            }
        }
        return maxLen;
    }

    public boolean validIndex(int i, int j, int[][] grid) {
        if (i < 0 || i > grid.length - 1) {
            return false;
        }
        if (j < 0 || j > grid[0].length - 1) {
            return false;
        }
        return true;
    }
}
