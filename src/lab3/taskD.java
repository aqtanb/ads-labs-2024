package lab3;

import java.util.*;

public class taskD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = sc.nextInt();
        int queries = sc.nextInt();
        int[] elements = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            elements[i] = sc.nextInt();
        }

        Arrays.sort(elements);



        for (int i = 0; i < queries; i++) {
            int l1 = sc.nextInt(), r1 = sc.nextInt();
            int l2 = sc.nextInt(), r2 = sc.nextInt();

            int count1 = countInRange(elements, l1, r1);
            int count2 = countInRange(elements, l2, r2);

            int overlap = 0;
            if (Math.max(l1, l2) <= Math.min(r1, r2)) {
                overlap = countInRange(elements, Math.max(l1, l2), Math.min(r1, r2));
            }

            System.out.println(count1 + count2 - overlap);
        }
    }

    private static int countInRange(int[] a, int l, int r) {
        int start = 0, end = a.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (a[mid] >= l) end = mid;
            else start = mid + 1;
        }
        int loBound = start;

        start = 0; end = a.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (a[mid] > r) end = mid;
            else start = mid + 1;
        }
        int hiBound = start;

        return hiBound - loBound;
    }
}
