package lab10;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class taskH {
    public static void bfs(char[][] grid, boolean[][] visited, int startI, int startJ) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startI, startJ});
        visited[startI][startJ] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];

            for (int[] direction : directions) {
                int tempI = currentI + direction[0];
                int tempJ = currentJ + direction[1];

                if (tempI >= 0 && tempI < grid.length && tempJ >= 0 && tempJ < grid[0].length &&
                        grid[tempI][tempJ] == '1' && !visited[tempI][tempJ]) {
                    visited[tempI][tempJ] = true;
                    q.offer(new int[]{tempI, tempJ});
                }
            }
        }
    }

    public static int countIslands(int n, int m, char[][] grid) {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    bfs(grid, visited, i, j);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        System.out.println(countIslands(n, m, grid));
    }
}
