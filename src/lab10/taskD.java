package lab10;

import java.util.*;

class taskD {
    public static void bfsFindDistOfRed(List<List<Integer>> data, int vertex, int[] distance) {
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> neighbours = data.get(curr);
            for (int i = 0; i < neighbours.size(); i++) {
                int neighbour = neighbours.get(i);
                if (distance[neighbour] != 0 && distance[curr] + 1 < distance[neighbour]) {
                    distance[neighbour] = distance[curr] + 1;
                    q.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        List<List<Integer>> data = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            data.add(new ArrayList<>());
        }
        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);

        for (int i = 0; i < m; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            if (first == second) continue;
            data.get(first - 1).add(second - 1);
            data.get(second - 1).add(first - 1);
        }

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            int vertex = scanner.nextInt();
            if (type == 1) {
                distance[vertex - 1] = 0;
                bfsFindDistOfRed(data, vertex - 1, distance);
            } else {
                if (distance[vertex - 1] == (int) 1e9) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[vertex - 1]);
                }
            }
        }
        scanner.close();
    }
}
