package lab1;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number == 1) {
            System.out.println("NO");
            return;
        }
        boolean prime = true;
        for (int i = 2; i < sqrt(number); i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
