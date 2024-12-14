package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taskA {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());

        int[][] grid = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        int mushroomCount = 0;

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    mushroomCount++;
                }
            }
        }

        if (mushroomCount == 0) {
            System.out.println(0);
            return;
        }

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean crushedMushroom = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && !visited[nx][ny]) {
                        if (grid[nx][ny] == 1) {
                            mushroomCount--;
                            crushedMushroom = true;
                        }

                        if (grid[nx][ny] != 0) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            if (crushedMushroom) {
                minutes++;
            }
        }

        System.out.println(mushroomCount == 0 ? minutes : -1);
    }
}
