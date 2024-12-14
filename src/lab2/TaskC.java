package lab2;

import java.util.Scanner;

public class TaskC {
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    static class LinkedList {
        Node head;
        public void add(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        public void printLinkedList () {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbersAmount = sc.nextInt();
        LinkedList ll = new LinkedList();

        for (int i = 0; i < numbersAmount; i++) {
            int value = sc.nextInt();
            if (i % 2 == 0) {
                ll.add(value);
            }
        }
        ll.printLinkedList();
    }
}
