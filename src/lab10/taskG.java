package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class taskG {
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

    static void topSort(List<List<Integer>> adjList) {
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
            System.out.print((value + 1) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adjList.get(x - 1).add(y - 1);
        }

        if (isThereCycle(n, adjList)) {
            System.out.println("Impossible");
            return;
        }

        System.out.println("Possible");
        topSort(adjList);
    }
}