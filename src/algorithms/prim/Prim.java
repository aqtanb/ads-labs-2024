package algorithms.prim;


import java.util.*;

class Prim {

    static class Edge implements Comparable<Edge> {
        int vertex, weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static void prim(int vertices, List<List<Edge>> graph) {
        int[] key = new int[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);

        boolean[] visited = new boolean[vertices];

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        key[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            visited[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, key[v]));
                }
            }
        }

        printMST(parent, key);
    }

    private static void printMST(int[] parent, int[] key) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + key[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(4, 7));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(1, 5));
        graph.get(4).add(new Edge(2, 7));

        prim(vertices, graph);
    }
}
