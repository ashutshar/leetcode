package org.example.graph;

import java.util.*;

//https://leetcode.com/problems/surrounded-regions/
class SurroundedRegions {
    public static void solve(char[][] board) {
        int[][] directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int[][] visited = new int[board.length][board[0].length];
        int m = board.length;
        int n = board[0].length;
        Map<Integer, List<Integer>> allZeros = new HashMap<>();
        for (int i = 0; i < m ; i++) {
            if (visited[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, visited, board, directions);
            }
            if (visited[i][n-1] == 0 && board[i][n-1] == 'O') {
                dfs(i, n-1, visited, board, directions);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[0][i] == 0 && board[0][i] == 'O') {
                dfs(0, i, visited, board, directions);
            }
            if (visited[m-1][i] == 0 && board[m-1][i] == 'O') {
                dfs(m-1, i, visited, board, directions);
            }
        }

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1) {
                    continue;
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(int i, int j, int[][] visited, char[][] board, int[][] directions) {
        visited[i][j] = 1;
        for (int count = 0; count < directions.length; count++) {
            int newX = i + directions[count][0];
            int newY = j + directions[count][1];
            if (validIndex(newX, newY, board) && board[newX][newY] == 'O' && visited[newX][newY] == 0) {
                dfs(newX, newY, visited, board, directions);
            }
        }
    }

    public static boolean validIndex(int i, int j, char[][] board) {
        if (i < board.length && i >= 0 && j < board[0].length && j >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //char[][] board = new char[][]{{'O','O'},{'O','O'}};
        char[][] board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        solve(board);
        for (char[] arr: board) {
            System.out.println(Arrays.toString(board));
        }
    }
}