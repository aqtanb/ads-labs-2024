package lab11; // kruskal, prima

import java.util.*;

class taskA {
    private static class UnionFind {
        private int[] parent, leftmost, rightmost;

        public UnionFind(int n) {
            parent = new int[n];
            leftmost = new int[n];
            rightmost = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                leftmost[i] = i;
                rightmost[i] = i;
            }
        }

        public int find(int i) {
            if (i == parent[i]) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void unionSets(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b) {
                return;
            }

            parent[a] = b;
            leftmost[b] = Math.min(leftmost[a], leftmost[b]);
            rightmost[b] = Math.max(rightmost[a], rightmost[b]);
        }

        public int getLeftmost(int i) {
            return leftmost[find(i)];
        }

        public int getRightmost(int i) {
            return rightmost[find(i)];
        }
    }

    private static class Solution {
        private int n, m;
        private List<int[]> edges;

        public Solution(int nodes, int edgesCount) {
            n = nodes;
            m = edgesCount;
            edges = new ArrayList<>();
        }

        public void addEdge(int l, int r, int cost) {
            edges.add(new int[]{cost, l - 1, r - 1});
        }

        public long computeMinimumCost() {
            edges.sort(Comparator.comparingInt(a -> a[0]));
            UnionFind uf = new UnionFind(n);

            long totalCost = 0;
            int components = 0;

            for (int[] edge : edges) {
                if (components >= n - 1) {
                    break;
                }

                int left = edge[1];
                int right = edge[2];
                int cost = edge[0];

                int representative = uf.find(left);

                if (uf.getLeftmost(representative) <= left && right <= uf.getRightmost(representative)) {
                    continue;
                } else if (uf.getLeftmost(representative) <= right && right <= uf.getRightmost(representative)) {
                    right = uf.getLeftmost(representative);
                } else if (uf.getLeftmost(representative) <= left && left <= uf.getRightmost(representative)) {
                    left = uf.getRightmost(representative);
                }

                for (int j = left; j <= right; j++) {
                    if (uf.find(representative) != uf.find(j)) {
                        uf.unionSets(representative, j);
                        components++;
                        totalCost += cost;
                    }
                }
            }

            return totalCost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Solution solution = new Solution(n, m);

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            solution.addEdge(l, r, c);
        }

        System.out.println(solution.computeMinimumCost());
        scanner.close();
    }
}


