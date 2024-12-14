package lab1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TaskE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> boris = new ArrayDeque<>();
        Deque<Integer> nursik = new ArrayDeque<>();

        for (int i = 0; i < 5; i++) {
            boris.add(scanner.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            nursik.add(scanner.nextInt());
        }

        final int MAX_MOVES = 1000000;
        int moves = 0;

        while (!boris.isEmpty() && !nursik.isEmpty() && moves < MAX_MOVES) {
            moves++;

            int bCard = boris.poll();
            int nCard = nursik.poll();

            if ((bCard == 0 && nCard == 9) || (bCard > nCard && !(bCard == 9 && nCard == 0))) {
                boris.add(bCard);
                boris.add(nCard);
            } else {
                nursik.add(bCard);
                nursik.add(nCard);
            }
        }

        if (boris.isEmpty()) {
            System.out.println("Nursik " + moves);
        } else if (nursik.isEmpty()) {
            System.out.println("Boris " + moves);
        } else {
            System.out.println("blin nichya");
        }

        scanner.close();
    }
}