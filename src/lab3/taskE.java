package lab3;

import java.util.*;

public class taskE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sheeps = scanner.nextInt();
        int sheepsToCatch = scanner.nextInt();
        int[][] pastures = new int[sheeps][4];

        for (int i = 0; i < sheeps; i++) {
            pastures[i][0] = scanner.nextInt();
            pastures[i][1] = scanner.nextInt();
            pastures[i][2] = scanner.nextInt();
            pastures[i][3] = scanner.nextInt();
        }

        long left = 0, right = Long.MAX_VALUE, result = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canFitAtLeastK(pastures, sheepsToCatch, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canFitAtLeastK(int[][] pastures, int K, long sideLength) {
        int count = 0;

        for (int[] pasture : pastures) {
            long x1 = pasture[0], y1 = pasture[1], x2 = pasture[2], y2 = pasture[3];

            if (x2 <= sideLength && y2 <= sideLength) {
                count++;
            }

            if (count >= K) {
                return true;
            }
        }

        return false;
    }
}
