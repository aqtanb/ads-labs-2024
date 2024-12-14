package lab1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TaskI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String votes = scanner.next();

        Queue<Integer> queueS = new ArrayDeque<>();
        Queue<Integer> queueK = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (votes.charAt(i) == 'S') {
                queueS.add(i);
            } else {
                queueK.add(i);
            }
        }

        while (!queueS.isEmpty() && !queueK.isEmpty()) {
            int s = queueS.poll();
            int k = queueK.poll();

            if (s < k) {
                queueS.add(s + n);
            } else {
                queueK.add(k + n);
            }
        }

        if (queueS.isEmpty()) {
            System.out.println("KATSURAGI");
        } else {
            System.out.println("SAKAYANAGI");
        }

        scanner.close();
    }
}
