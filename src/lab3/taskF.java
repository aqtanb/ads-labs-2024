package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class taskF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfOpps = sc.nextInt();
        int[] opps = new int[numberOfOpps];
        for (int i = 0; i < numberOfOpps; i++) {
            opps[i] = sc.nextInt();
        }

        Arrays.sort(opps);

        int[] prefixSum = new int[numberOfOpps];
        prefixSum[0] = opps[0];
        for (int i = 1; i < numberOfOpps; i++) {
            prefixSum[i] = prefixSum[i - 1] + opps[i];
        }

        int numberOfRounds = sc.nextInt();
        for (int i = 0; i < numberOfRounds; i++) {
            int power = sc.nextInt();
            int victories = upperBound(opps, power);
            int sum = victories > 0 ? prefixSum[victories - 1] : 0;
            System.out.print(victories + " ");
            System.out.println(sum);
        }
    }

    private static int upperBound(int[] opps, int power) {
        int left = 0, right = opps.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (opps[mid] <= power) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
