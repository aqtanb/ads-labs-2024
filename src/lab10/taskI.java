package lab10;

import java.io.*;
import java.util.*;

public class taskI {
    static boolean detectCycle(int current, List<List<Integer>> adjList, boolean[] visited, int[] recursionStack) {
        visited[current] = true;
        recursionStack[current] = 1;

        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                if (detectCycle(neighbor, adjList, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor] == 1) {
                return true;
            }
        }

        recursionStack[current] = 0;
        return false;
    }

    static boolean isThereCycle(int n, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[n];
        int[] recursionStack = new int[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (detectCycle(i, adjList, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void dfs(int at, boolean[] visited, List<Integer> visitedNodes, List<List<Integer>> adjList) {
        visited[at] = true;

        List<Integer> edges = adjList.get(at);
        for (int edge : edges) {
            if (!visited[edge]) {
                dfs(edge, visited, visitedNodes, adjList);
            }
        }

        visitedNodes.add(at);
    }

    static void topSort(List<List<Integer>> adjList, BufferedWriter bw) throws IOException {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        int[] ordering = new int[n];

        int i = n - 1;

        for (int at = 0; at < n; at++) {
            if (!visited[at]) {
                List<Integer> visitedNodes = new ArrayList<>();
                dfs(at, visited, visitedNodes, adjList);
                for (int node : visitedNodes) {
                    ordering[i] = node;
                    i--;
                }
            }
        }

        for (int value : ordering) {
            bw.write((value + 1) + " ");
        }
        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x - 1).add(y - 1);
        }

        if (isThereCycle(n, adjList)) {
            bw.write("Impossible\n");
        } else {
            bw.write("Possible\n");
            topSort(adjList, bw);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
