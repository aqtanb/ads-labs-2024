package lab12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taskB {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Edge>> graph;

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[start] = 0;
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0], currentNode = current[1];
            if (currentDist > dist[currentNode]) continue;
            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.to, weight = edge.weight;
                if (dist[currentNode] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[currentNode] + weight;
                    pq.add(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, c));
            graph.get(v).add(new Edge(u, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int[] distFromS = dijkstra(s, n);
        int[] distFromA = dijkstra(a, n);
        int[] distFromB = dijkstra(b, n);

        long path1 = (long) distFromS[a] + distFromA[b] + distFromB[f];
        long path2 = (long) distFromS[b] + distFromB[a] + distFromA[f];

        if (distFromS[a] == INF || distFromA[b] == INF || distFromB[f] == INF) path1 = INF;
        if (distFromS[b] == INF || distFromB[a] == INF || distFromA[f] == INF) path2 = INF;

        long result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }
}




