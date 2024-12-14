package lab2;

import java.util.*;

public class TaskB {
    static class Node {
        String word;
        Node next;

        Node(String word) {
            this.word = word;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWords = sc.nextInt();
        int shift = sc.nextInt();

        Node head = new Node(sc.next());
        Node current = head;
        for (int i = 1; i < numberOfWords; i++) {
            current.next = new Node(sc.next());
            current = current.next;
        }


        current = head;
        for (int i = 0; i < shift - 1; i++) {
            current = current.next;
        }
        Node newHead = current.next;
        current.next = null;
        Node tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        current = newHead;
        while (current != null) {
            System.out.print(current.word + " ");
            current = current.next;
        }
    }
}
