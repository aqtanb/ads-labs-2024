package lab3;

import java.util.Scanner;

public class taskK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        long target = scanner.nextLong();
        long[] arr = new long[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = scanner.nextLong();
        }

        System.out.println(minSubarrayLength(arr, numberOfElements, target));
        scanner.close();
    }

    private static int minSubarrayLength(long[] arr, int n, long k) {
        int minLength = n + 1;
        long currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            while (currentSum >= k) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= arr[start++];
            }
        }

        return minLength == n + 1 ? 0 : minLength;
    }
}
