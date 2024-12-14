package lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class taskB {

    static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int[] arrOne = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] arrTwo = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        return merge(arrOne, arrTwo);
    }

    static int[] merge(int[] arrOne, int[] arrTwo) {
        int size = arrOne.length + arrTwo.length;
        int[] sorted = new int[size];


        int arrOneCount = 0;
        int arrTwoCount = 0;
        int totalCount = 0;
        while (arrOneCount < arrOne.length && arrTwoCount < arrTwo.length) {
            if (arrOne[arrOneCount] < arrTwo[arrTwoCount]) {
                sorted[totalCount++] = arrOne[arrOneCount++];
            } else {
                sorted[totalCount++] = arrTwo[arrTwoCount++];
            }
        }

        while (arrOneCount < arrOne.length) {
            sorted[totalCount++] = arrOne[arrOneCount++];
        }

        while (arrTwoCount < arrTwo.length) {
            sorted[totalCount++] = arrTwo[arrTwoCount++];
        }
        return sorted;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] firstArray = new int[n];
        for (int i = 0; i < n; i++) {
            firstArray[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] secondArray = new int[m];
        for (int i = 0; i < m; i++) {
            secondArray[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = merge(firstArray, secondArray);
        for (int number : sorted) {
            System.out.print(number + " ");
        }
    }
}
