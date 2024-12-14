package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskG {

    static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;
        int maxDiameter = 0;

        Node insert(Node root, int key) {
            if (root == null) {
                return new Node(key);
            }
            if (key < root.key) {
                root.left = insert(root.left, key);
            } else if (key > root.key) {
                root.right = insert(root.right, key);
            }
            return root;
        }

        int calculateDiameter(Node node) {
            if (node == null) {
                return 0;
            }

            int leftHeight = calculateDiameter(node.left);
            int rightHeight = calculateDiameter(node.right);

            maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        int findDiameter() {
            calculateDiameter(root);
            return maxDiameter;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BinaryTree tree = new BinaryTree();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            tree.root = tree.insert(tree.root, value);
        }

        System.out.println(tree.findDiameter() + 1);
    }
}
