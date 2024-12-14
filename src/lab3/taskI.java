package lab3;

import java.util.Scanner;

public class taskI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = sc.nextInt();
        int[] elements = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            elements[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int start = 0;
        int end = numberOfElements - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (elements[mid] > target) {
                end = mid - 1;
            } else if (elements[mid] < target) {
                start = mid + 1;
            } else {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
