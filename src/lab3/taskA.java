package lab3; // binary search

import java.util.Scanner;

public class taskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTargets = sc.nextInt();
        int[] targets = new int[numberOfTargets];
        for (int i = 0; i < numberOfTargets; i++) {
            targets[i] = sc.nextInt();
        }
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] numbers = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        for (int target : targets) {
            boolean found = false;
            for (int i = 0; i < rows; i++) {
                if (i % 2 == 0) {
                    int start = 0;
                    int end = columns - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        if (numbers[i][mid] == target) {
                            System.out.println(i + " " + mid);
                            found = true;
                            break;
                        } else if (numbers[i][mid] > target) {
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    }
                } else {
                    int start = 0;
                    int end = columns - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        int reverseMid = columns - 1 - mid;
                        if (numbers[i][reverseMid] == target) {
                            System.out.println(i + " " + reverseMid);
                            found = true;
                            break;
                        } else if (numbers[i][reverseMid] < target) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                }
                if (found) break;
            }
            if (!found) {
                System.out.println("-1");
            }
        }

        sc.close();
    }
}
