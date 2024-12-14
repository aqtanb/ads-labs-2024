package algorithms.topological;

import java.util.*;

class TopologicalSort {

    static void topologicalSort(int vertices, List<List<Integer>> graph) {
        int[] inDegree = new int[vertices];

        for (int u = 0; u < vertices; u++) {
            for (int v : graph.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topOrder.add(u);

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (topOrder.size() != vertices) {
            System.out.println("The graph contains a cycle. Topological sorting is not possible.");
        } else {
            System.out.println("Topological Order: " + topOrder);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topologicalSort(vertices, graph);
    }
}
