package algorithms.dijkstra;

import java.util.*;

class Dijkstra {
    private static int findMinDistance(int[] dist, boolean[] visited, int vertices) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && dist[i] < minDistance) {
                minDistance = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = findMinDistance(dist, visited, vertices);

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    private static void printSolution(int[] dist) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 10, 20, 0, 0},
                {10, 0, 30, 50, 10},
                {20, 30, 0, 20, 33},
                {0, 50, 20, 0, 2},
                {0, 10, 33, 2, 0}
        };

        dijkstra(graph, 0);
    }
}
