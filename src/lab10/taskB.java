package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taskB {

    static void bfs(List<List<Integer>> adj, int s) {

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[adj.size()];

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int curr = q.poll();
            System.out.print(curr + " ");

            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int pointA = Integer.parseInt(st.nextToken());
        int pointB = Integer.parseInt(st.nextToken());

        System.out.println(shortestPath(adj, pointA - 1, pointB - 1));
    }

    static int shortestPath(List<List<Integer>> adj, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, -1);
        q.add(start);
        distance[start] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neighbor : adj.get(curr)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[curr] + 1;
                    q.add(neighbor);
                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }
        return -1;
    }
}