package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskB {
    static Node root;
    private static Node targetRoot;
    private static int count;

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

    static void inorder() {
        count = 0;
        inorderRec(targetRoot);
    }

    static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            count++;
            inorderRec(root.right);
        }
    }
    

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfBST = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] bst = new int[numberOfBST];
        for (int i = 0; i < numberOfBST; i++) {
            bst[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int indexOfTarget = Integer.parseInt(st.nextToken());
        int target = 0;

        for (int i = 0; i < numberOfBST; i++) {
            insert(bst[i]);
            if (i + 1 == indexOfTarget) {
                target = bst[i];
            }
        }
        search(indexOfTarget);
        inorder();
        System.out.println(count);
        

    }
}
