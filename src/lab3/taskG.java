package lab3;

import java.util.Scanner;

public class taskG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfIslands = sc.nextInt();
        long flights = sc.nextInt();

        int[] children = new int[numberOfIslands];
        for (int i = 0; i < numberOfIslands; i++) {
            children[i] = sc.nextInt();
        }

        int left = 1, right = 10000, result = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDeliverWithCapacity(children, flights, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDeliverWithCapacity(int[] children, long maxFlights, int capacity) {
        long flightsNeeded = 0;

        for (int childCount : children) {
            flightsNeeded += (childCount + capacity - 1) / capacity;
            if (flightsNeeded > maxFlights) {
                return false;
            }
        }

        return flightsNeeded <= maxFlights;
    }
}
