package lab1;

import java.util.Scanner;
import java.util.Stack;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstWord = sc.next();
        String secondWord = sc.next();
        Stack<Character> firstStack = new Stack<>();
        Stack<Character> secondStack = new Stack<>();

        for (char ch: firstWord.toCharArray()) {
            if (ch == '#') {
                firstStack.pop();
            } else {
                firstStack.add(ch);
            }
        }

        for (char ch: secondWord.toCharArray()) {
            if (ch == '#') {
                secondStack.pop();
            } else {
                secondStack.add(ch);
            }
        }


        while (!firstStack.isEmpty() && !secondStack.isEmpty()) {
            char firstChar = firstStack.pop();
            char secondChar = secondStack.pop();
            if (firstChar != secondChar) {
                System.out.println("No");
                return;
            }
        }
        if (firstStack.isEmpty() && secondStack.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
