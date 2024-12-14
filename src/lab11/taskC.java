package lab11;

import java.util.*;

class taskC {
    private static class DisjointSet {
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

    private static class Graph {
        private int numVertices;
        private List<Edge> edges;

        private static class Edge {
            int cost;
            int cityA;
            int cityB;

            Edge(int cost, int cityA, int cityB) {
                this.cost = cost;
                this.cityA = cityA;
                this.cityB = cityB;
            }
        }

        public Graph(int n) {
            numVertices = n;
            edges = new ArrayList<>();
        }

        public void addEdge(int cost, int cityA, int cityB) {
            edges.add(new Edge(cost, cityA, cityB));
        }

        public int kruskalMST() {
            edges.sort(Comparator.comparingInt(e -> e.cost));
            DisjointSet ds = new DisjointSet(numVertices);

            int totalCost = 0;
            List<Edge> selectedEdges = new ArrayList<>();

            for (Edge edge : edges) {
                int cost = edge.cost;
                int cityA = edge.cityA;
                int cityB = edge.cityB;

                if (ds.findSet(cityA) != ds.findSet(cityB)) {
                    totalCost += cost;
                    selectedEdges.add(new Edge(cityA, cityB, cost));
                    ds.uniteSets(cityA, cityB);
                }
            }

            return totalCost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Graph graph = new Graph(n);

        while (m-- > 0) {
            String roadType = scanner.next();
            int cityA = scanner.nextInt() - 1;
            int cityB = scanner.nextInt() - 1;
            int cost = scanner.nextInt();

            if (roadType.equals("big")) {
                graph.addEdge(cost * x, cityA, cityB);
            } else if (roadType.equals("small")) {
                graph.addEdge(cost * y, cityA, cityB);
            } else if (roadType.equals("both")) {
                graph.addEdge(cost * x, cityA, cityB);
                graph.addEdge(cost * y, cityA, cityB);
            }
        }

        int totalCost = graph.kruskalMST();
        System.out.println(totalCost);
    }
}

