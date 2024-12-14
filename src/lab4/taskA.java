package lab4; // bst

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskA {
    static Node root;
    static class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    static void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root, parent = null;
        while (current != null) {
            parent = current;
            current = key < current.key ? current.left : current.right;
        }
        if (key < parent.key) parent.left = newNode;
        else parent.right = newNode;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int numberOfBST = Integer.parseInt(st.nextToken());
        int numberOfPaths = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfBST; i++) {
            insert(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < numberOfPaths; i++) {
            String path = br.readLine();
            boolean found = true;
            Node current = root;
            for (char ch : path.toCharArray()) {
                current = ch == 'L' ? current.left : current.right;
                if (current == null) {
                    found = false;
                    break;
                }
            }

            System.out.println(found ? "YES" : "NO");

        }
    }
}
