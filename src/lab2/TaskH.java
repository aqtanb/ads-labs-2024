package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskH {

    public static void main(String[] args) throws IOException {

        class Node {
            int val;
            Node next;
            Node(int x, Node next){ this.val = x; this.next = next; }
            Node(int x){ this(x, null); }
            Node(Node next){ this(0, next); }
            Node(){ this(0, null); }
        }

        class Solution {

            Node insert(Node head, Node node, int pos) {
                if (pos == 0 || head == null) {
                    node.next = head;
                    return node;
                }

                Node current = head;
                for (int i = 0; i < pos - 1; i++) {
                    current = current.next;
                }
                node.next = current.next;
                current.next = node;
                return head;
            }

            Node remove(Node head, int pos) {
                if (pos == 0) {
                    return head.next;
                }

                Node current = head;
                for (int i = 0; i < pos - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
                return head;
            }

            void print(Node head) {
                if (head == null) {
                    System.out.println(-1);
                } else {
                    while (head != null) {
                        System.out.print(head.val + " ");
                        head = head.next;
                    }
                    System.out.println();
                }
            }

            Node replace(Node head, int pos1, int pos2) {
                if (pos1 == pos2) return head;

                Node prev1 = null, node1 = head;
                for (int i = 0; i < pos1; i++) {
                    prev1 = node1;
                    node1 = node1.next;
                }

                if (prev1 != null) prev1.next = node1.next;
                else head = node1.next;

                return insert(head, node1, pos2);
            }

            Node reverse(Node head) {
                Node prev = null, current = head, next;
                while (current != null) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                return prev;
            }

            Node cyclic_left(Node head, int x) {
                if (head == null || x == 0) return head;

                Node tail = head;
                int len = 1;
                while (tail.next != null) {
                    tail = tail.next;
                    len++;
                }
                tail.next = head;

                x = x % len;
                for (int i = 0; i < x; i++) {
                    tail = head;
                    head = head.next;
                }

                tail.next = null;
                return head;
            }

            Node cyclic_right(Node head, int x) {
                if (head == null || x == 0) return head;

                Node tail = head;
                int len = 1;
                while (tail.next != null) {
                    tail = tail.next;
                    len++;
                }
                tail.next = head;

                x = x % len;
                int shift = len - x;
                for (int i = 0; i < shift; i++) {
                    tail = head;
                    head = head.next;
                }

                tail.next = null;
                return head;
            }
        }

        Node head = null;
        Solution solution = new Solution();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        while (true) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken());
            if (x == 0) {
                break;
            } else if (x == 1) {
                int val = Integer.parseInt(tk.nextToken());
                int pos = Integer.parseInt(tk.nextToken());
                head = solution.insert(head, new Node(val), pos);
            } else if (x == 2) {
                int pos = Integer.parseInt(tk.nextToken());
                head = solution.remove(head, pos);
            } else if (x == 3) {
                solution.print(head);
            } else if (x == 4) {
                int pos1 = Integer.parseInt(tk.nextToken());
                int pos2 = Integer.parseInt(tk.nextToken());
                head = solution.replace(head, pos1, pos2);
            } else if (x == 5) {
                head = solution.reverse(head);
            } else if (x == 6) {
                int y = Integer.parseInt(tk.nextToken());
                head = solution.cyclic_left(head, y);
            } else if (x == 7) {
                int y = Integer.parseInt(tk.nextToken());
                head = solution.cyclic_right(head, y);
            }
        }
    }
}
