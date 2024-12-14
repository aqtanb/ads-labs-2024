package lab11;

import java.util.Scanner;
import java.util.Arrays;

public class taskD {
    private static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] g = new int[n][n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] minEdge = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(minEdge, INF);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = scanner.nextInt();
            }
        }

        minEdge[0] = 0;
        int totalWeight = 0;

        for (int i = 0; i < n; i++) {
            int currentVertex = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (currentVertex == -1 || minEdge[j] < minEdge[currentVertex])) {
                    currentVertex = j;
                }
            }

            visited[currentVertex] = true;

            if (parent[currentVertex] != -1) {
                totalWeight += g[currentVertex][parent[currentVertex]];
            }

            for (int j = 0; j < n; j++) {
                if (g[currentVertex][j] < minEdge[j]) {
                    minEdge[j] = g[currentVertex][j];
                    parent[j] = currentVertex;
                }
            }
        }

        System.out.println(totalWeight);
        scanner.close();
    }
}


