package lab11;

import java.util.*;

class taskB {
    static class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; ++i)
                parent[i] = i;
        }

        public int findSet(int v) {
            if (v != parent[v])
                parent[v] = findSet(parent[v]);
            return parent[v];
        }

        public void uniteSets(int a, int b) {
            a = findSet(a);
            b = findSet(b);
            if (a != b) {
                if (rank[a] < rank[b])
                    swap(a, b);

                parent[b] = a;

                if (rank[a] == rank[b])
                    ++rank[a];
            }
        }

        private void swap(int a, int b) {
            int temp = a;
            a = b;
            b = temp;
        }
    }

    static class Graph {
        private List<Edge> edges;
        private int numVertices;

        public Graph(int n) {
            numVertices = n;
            edges = new ArrayList<>();
        }

        public void addEdge(int u, int v, int weight) {
            edges.add(new Edge(weight, u, v));
        }

        public int kruskalMST() {
            edges.sort(Comparator.comparingInt(edge -> edge.weight));
            DisjointSet ds = new DisjointSet(numVertices);

            int totalCost = 0;
            List<int[]> resultEdges = new ArrayList<>();

            for (Edge edge : edges) {
                int weight = edge.weight;
                int u = edge.u;
                int v = edge.v;

                if (ds.findSet(u) != ds.findSet(v)) {
                    totalCost += weight;
                    resultEdges.add(new int[]{u, v});
                    ds.uniteSets(u, v);
                }
            }
            return totalCost;
        }

        private static class Edge {
            int weight;
            int u;
            int v;

            Edge(int weight, int u, int v) {
                this.weight = weight;
                this.u = u;
                this.v = v;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] elements = new int[n];
        for (int i = 0; i < n; ++i)
            elements[i] = scanner.nextInt();

        Graph graph = new Graph(n);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int weight = elements[i] + elements[j];
                graph.addEdge(i, j, weight);
            }
        }

        int totalCost = graph.kruskalMST();
        System.out.println(totalCost);
    }
}


