package lab2; // linked list

import java.util.Scanner;

public class TaskA {
    Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public int findNearestInt(int target) {
        Node current = head;
        int index = 0;
        int nearestIndex = -1;
        int closestDistance = Integer.MAX_VALUE;

        while (current != null) {
            int distance = Math.abs(current.value - target);
            if (distance <= closestDistance) {
                closestDistance = distance;
                nearestIndex = index;
            }
            current = current.next;
            index++;
        }
        return index - nearestIndex - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbersAmount = sc.nextInt();
        TaskA ll = new TaskA();
        for (int i = 0; i < numbersAmount; i++) {
            ll.add(sc.nextInt());
        }
        int target = sc.nextInt();
        System.out.println(ll.findNearestInt(target));
    }
}