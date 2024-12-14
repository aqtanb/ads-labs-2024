package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskD {
    static Node root;
    static int[] levelSums;
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


    static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            return Math.max(lheight, rheight) + 1;
        }
    }

    static void calculateSums(Node root, int level) {
        if (root == null) {
            return;
        }
        levelSums[level] += root.key;
        calculateSums(root.left, level + 1);
        calculateSums(root.right, level + 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfBST = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfBST; i++) {
            insert(Integer.parseInt(st.nextToken()));
        }

        int height =  height(root);
        levelSums = new int[height];
        calculateSums(root, 0);
        System.out.println(height);
        for (int i = 0; i < height; i++) {
            System.out.print(levelSums[i] + " ");
        }

    }
}
