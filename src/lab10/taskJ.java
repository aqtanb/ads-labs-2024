package lab10;

import java.io.*;
import java.util.*;

public class taskJ {
    static int bfs(List<List<Integer>> adjList, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int[] childCount = new int[adjList.size()];
        int[] parent = new int[adjList.size()];
        Arrays.fill(parent, -1);

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    parent[neighbor] = current;
                    childCount[current]++;
                }
            }

            int parentNode = parent[current];
            if (parentNode == -1 || childCount[current] > childCount[parentNode]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        boolean[] visited = new boolean[n];
        int totalBigFamilies = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                totalBigFamilies += bfs(adjList, i, visited);
            }
        }

        System.out.println(totalBigFamilies);
    }
}
