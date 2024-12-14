package lab1;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = scanner.nextInt();
        }

        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && a[s.peek()] > a[i]) {
                s.pop();
            }

            if (!s.isEmpty()) {
                result[i] = a[s.peek()];
            }

            s.push(i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}