package lab10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class taskF {

    public static boolean bfsAdjList(List<List<Integer>> a, int v1, int v2) {
        boolean[] visited = new boolean[a.size()];
        Queue<Integer> q = new LinkedList<>();

        visited[v1] = true;
        q.add(v1);

        while (!q.isEmpty()) {
            int currentVertex = q.poll();

            if (currentVertex == v2) {
                return true;
            }

            for (int neighbor : a.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            a.get(x - 1).add(y - 1);
            a.get(y - 1).add(x - 1);
        }

        int s = scanner.nextInt();
        int f = scanner.nextInt();

        if (bfsAdjList(a, s - 1, f - 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
