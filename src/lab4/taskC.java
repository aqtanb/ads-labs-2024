package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskC {
    static Node root;
    private static Node targetRoot;

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

    static boolean search(int key) {
        return searchRec(root, key);
    }

    static boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key) {
            targetRoot = root;
            return true;
        }
        if (root.key < key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }

    static void preorder() {
        preorderRec(targetRoot);
        System.out.println("\n");

    }

    static void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfBST = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfBST; i++) {
            insert(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());

        search(target);
        preorder();
    }
}
