package lab3;

import java.util.Scanner;

public class taskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfHouses = sc.nextInt();
        int roadblocks = sc.nextInt();
        int[] houses = new int[numberOfHouses];
        for (int i = 0; i < numberOfHouses; i++) {
            houses[i] = sc.nextInt();
        }

        long left = 0, right = 0;
        for (int value : houses) {
            left = Math.max(left, value);
            right += value;
        }

        while (left < right) {
            long mid = (left + right) / 2;
            long currentBlockSum = 0;
            int blockCount = 1;

            for (int i = 0; i < numberOfHouses; i++) {
                if (currentBlockSum + houses[i] > mid) {
                    blockCount++;
                    currentBlockSum = houses[i];
                } else {
                    currentBlockSum += houses[i];
                }
            }

            if (blockCount <= roadblocks) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
        sc.close();
    }
}
