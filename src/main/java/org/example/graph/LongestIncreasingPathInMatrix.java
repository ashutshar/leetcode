package org.example.graph;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
public class LongestIncreasingPathInMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] countFromHere = new int[matrix.length][matrix[0].length];

        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLen = Math.max(maxLen, dfs(i, j, directions, matrix, countFromHere));
            }
        }
        return maxLen;
    }

    public static int dfs(int i, int j, int[][] directions, int[][] matrix, int[][] countFromHere) {
        //visited[i][j] = 1;
        int count = 0;
        for (int[] arr : directions) {
            int newI = i + arr[0];
            int newJ = j + arr[1];
            if (checkIndexValidity(newI, newJ, matrix) && matrix[newI][newJ] > matrix[i][j]) {
                if (countFromHere[newI][newJ] > 0) {
                    count = Math.max(count, countFromHere[newI][newJ]);
                } else {
                    count = Math.max(count, dfs(newI, newJ, directions, matrix, countFromHere));
                }
            }
        }
        countFromHere[i][j] = count + 1;
        return count + 1;
    }

    public static boolean checkIndexValidity(int i, int j, int[][] matrix){
        if (i < 0 || i > matrix.length - 1) {
            return false;
        }
        return j >= 0 && j <= matrix[0].length - 1;
    }

    public static void main(String[] args) {
        //int[][] matrix = new int[][] {{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix = new int[][] {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
}
