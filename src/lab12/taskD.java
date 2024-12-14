package lab12;

import java.io.*;
import java.util.*;

public class taskD {
    private static final int MAX_NODES = 200005;
    private static final int INF = 2000000007;

    private int[] x = new int[MAX_NODES];
    private int[] y = new int[MAX_NODES];
    private int[] parent = new int[MAX_NODES];
    private int minRadius = 0;

    private int findRoot(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findRoot(parent[node]);
    }

    private boolean unionSets(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);
        if (a == b) return false;
        if (new Random().nextInt(2) == 0) {
            int temp = a;
            a = b;
            b = temp;
        }
        parent[b] = a;
        return true;
    }

    private void findMinRadius(int left, int right, int nodeCount) {
        while (left <= right) {
            int mid = (left + right) / 2;

            for (int i = 1; i <= nodeCount; i++) parent[i] = i;

            for (int i = 1; i <= nodeCount; i++) {
                for (int j = 1; j <= nodeCount; j++) {
                    int distance = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                    if (distance <= mid) {
                        unionSets(i, j);
                    }
                }
            }

            if (findRoot(1) == findRoot(nodeCount)) {
                minRadius = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        taskD task = new taskD();

        int nodeCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= nodeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            task.x[i] = Integer.parseInt(st.nextToken());
            task.y[i] = Integer.parseInt(st.nextToken());
        }

        task.findMinRadius(0, INF, nodeCount);
        System.out.println(task.minRadius);
    }
}

