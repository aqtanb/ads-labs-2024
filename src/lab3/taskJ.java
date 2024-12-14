package lab3;

import java.util.Scanner;

public class taskJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfItems = sc.nextInt();
        int allowedHours = sc.nextInt();

        int[] items = new int[numberOfItems];
        int maxItem = 1;
        for (int i = 0; i < numberOfItems; i++) {
            items[i] = sc.nextInt();
            if (items[i] > maxItem) {
                maxItem = items[i];
            }
        }

        int low = 0;
        int high = maxItem;
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCompleteInHours(items, allowedHours, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
        sc.close();
    }

    private static boolean canCompleteInHours(int[] arr, int H, int K) {
        int totalCount = 0;
        for (int item : arr) {
            totalCount += item / K;
            if (item % K > 0) totalCount++;
        }
        return totalCount <= H;
    }
}
