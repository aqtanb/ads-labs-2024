package lab10;

import java.util.*;

public class taskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, 0});
        Map<Integer, Integer> path = new HashMap<>();
        path.put(a, -1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0], steps = current[1];
            if (num == b) {
                System.out.println(steps);
                List<Integer> sequence = new ArrayList<>();
                while (num != -1) {
                    sequence.add(num);
                    num = path.get(num);
                }
                Collections.reverse(sequence);
                for (int x : sequence) {
                    if (x == sequence.get(0)) continue;
                    System.out.print(x + " ");
                }
                return;
            }
            if (!path.containsKey(num * 2) && num * 2 <= b * 2) {
                queue.add(new int[]{num * 2, steps + 1});
                path.put(num * 2, num);
            }
            if (!path.containsKey(num - 1) && num - 1 > 0) {
                queue.add(new int[]{num - 1, steps + 1});
                path.put(num - 1, num);
            }
        }
    }
}
