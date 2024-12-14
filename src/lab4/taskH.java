package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class taskH {
    static Node root;
    static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }
    static void insert(int key) {
        if (root == null) {
            root = new Node(key);
        }
        Node current = root, parent = null;
        while (current != null) {
            parent = current;
            current = key > current.key ? current.right : current.left;
        }
        if (key > parent.key) parent.right = new Node(key);
        else parent.left = new Node(key);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    }
}
