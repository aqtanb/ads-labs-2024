package algorithms.dfs;

import java.util.*;

class DFS {

    static void dfs(int vertex, List<List<Integer>> graph, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(4);
        graph.get(3).add(1);
        graph.get(3).add(5);
        graph.get(4).add(2);
        graph.get(5).add(3);

        boolean[] visited = new boolean[vertices];

        System.out.println("DFS Traversal starting from vertex 0:");
        dfs(0, graph, visited);
    }
}
