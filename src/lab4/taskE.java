package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskE {
    static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfNodes = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[numberOfNodes + 1];
        for (int i = 1; i <= numberOfNodes; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < numberOfNodes - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int isRight = Integer.parseInt(st.nextToken());

            if (isRight == 1) {
                nodes[parent].right = nodes[child];
            } else {
                nodes[parent].left = nodes[child];
            }
        }

        System.out.println(getMaxWidth(nodes[1]));
    }

    static int getMaxWidth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            maxWidth = Math.max(maxWidth, levelWidth);

            for (int i = 0; i < levelWidth; i++) {
                Node current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return maxWidth;
    }
}
