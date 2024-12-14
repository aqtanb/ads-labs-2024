package lab1;

import java.util.Scanner;
import java.util.Stack;

public class TaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        if (st.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");

        scanner.close();
    }
}

