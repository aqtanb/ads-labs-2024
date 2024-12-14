package lab3;

import java.util.Scanner;

public class taskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = sc.nextInt();
        int numberOfQueries = sc.nextInt();
        int[] numbers = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < numberOfQueries; i++) {
            int indices = 0;
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            for (int number : numbers) {
                if (l1 <= number && number <= r1 ||
                        (l2 <= number && number <= r2)) {
                    indices++;
                }
            }
            System.out.println(indices);
        }
    }
}
