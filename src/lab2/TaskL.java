package lab2;

import java.util.Scanner;

public class TaskL {
    static class Node {
        int val;
        Node next;

        Node() {
            val = 0;
            next = null;
        }
    }
    public static int findMaxSum(int n, Node head) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Node head = null, tail = null;
        for (int i = 1; i <= n; ++i) {
            int x = scanner.nextInt();
            Node cur = new Node();
            cur.val = x;

            if (i == 1) {
                head = tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
        }

        System.out.println(findMaxSum(n, head));
        scanner.close();
    }
}

