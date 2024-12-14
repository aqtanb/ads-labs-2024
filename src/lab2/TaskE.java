package lab2;

import java.util.Scanner;

public class TaskE {
    static Node head;
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        static void add(int value) {
            if (head == null) {
                head = new Node(value);
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(value);
            }
        }


    }








    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int numberOfElements = sc.nextInt();


       for (int i = 0; i < numberOfElements; i++) {
           int number = sc.nextInt();
           Node.add(number);
       }
       int newNumber = sc.nextInt();
       int position = sc.nextInt();
       Node current = head;
       for (int i = 0; i < position - 1; i++) {
           current = current.next;
       }
       if (position == 0) {
           Node newNode = new Node(newNumber);
           newNode.next = head;
           head = newNode;
       } else {
           Node temp = current.next;
           current.next = new Node(newNumber);
           current.next.next = temp;
       }


       current = head;
       while (current != null) {
           System.out.print(current.value + " ");
           current = current.next;
       }
    }
}