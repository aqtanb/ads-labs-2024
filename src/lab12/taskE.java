package lab12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taskE {
    static final int INF = 1_000_000_000;
    static List<List<int[]>> graph;
    static int[] dist;
    static int[] parent;
    static int n;

    static void bellmanFord() {
        dist = new int[n];
        parent = new int[n];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        int start = -1;
        dist[0] = 0;

        for (int i = 0; i < n; i++) {
            start = -1;
            for (int u = 0; u < n; u++) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0], weight = edge[1];
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        parent[v] = u;
                        start = v;
                    }
                }
            }
        }

        if (start == -1) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < n; i++) {
                start = parent[start];
            }
            List<Integer> cycle = new ArrayList<>();
            for (int v = start;; v = parent[v]) {
                cycle.add(v + 1);
                if (v == start && cycle.size() > 1) break;
            }
            Collections.reverse(cycle);
            System.out.println("YES");
            System.out.println(cycle.size());
            for (int v : cycle) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int w = Integer.parseInt(st.nextToken());
                if (w != 100000) graph.get(i).add(new int[]{j, w});
            }
        }
        bellmanFord();
    }
}
