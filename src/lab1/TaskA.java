package lab1; // stack, queue, deque

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDecks = scanner.nextInt();

        for (int deck = 0; deck < numberOfDecks; deck++) {
            int lengthOfDeck = scanner.nextInt();
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = lengthOfDeck; i > 0; i--) {
                deque.addFirst(i);
                for (int j = 0; j < i; j++) {
                    deque.addFirst(deque.removeLast());
                }
            }

            for (int card : deque) {
                System.out.print(card + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
