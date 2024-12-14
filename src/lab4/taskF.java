package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskF {
    static Node root;
    static int count = 0;
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

    static void inorder() {
        inorderRec(root);
    }

    static void inorderRec(Node root) {
        if (root != null) {
            if (root.left != null && root.right != null) count++;
            inorderRec(root.left);
            inorderRec(root.right);
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
        inorder();
        System.out.println(count);
    }
}
