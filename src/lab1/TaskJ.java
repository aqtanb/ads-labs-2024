package lab1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TaskJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deq = new ArrayDeque<>();
        while (sc.hasNext()) {
            String operation = sc.next();
            switch (operation) {
                case "+":
                    int number = sc.nextInt();
                    deq.addFirst(number);
                    break;
                case "-":
                    number = sc.nextInt();
                    deq.addLast(number);
                    break;
                case "*":
                    if (!deq.isEmpty()) {
                        System.out.println(deq.peekFirst() + deq.peekLast());
                        deq.pollFirst();
                        if (!deq.isEmpty()) {
                            deq.pollLast();
                        }
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "!":
                    sc.close();
                    return;
            }
        }
    }
}

// 2 1 9  11
// 3 2 1 6 9 12
// 2 1 6  8
// 1 1