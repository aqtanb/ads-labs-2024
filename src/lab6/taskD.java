package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class taskD {

    static void random(int[] arr, int low, int high) {
        Random random = new Random();
        int pivot = random.nextInt(high - low) + low;
        int temp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;
    }


    static int partition(int[] arr, int low, int high) {
        random(arr, low, high);
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int partIndex = partition(arr, low, high);
            sort(arr, low, partIndex - 1);
            sort(arr, partIndex + 1, high);
        }
    }

    static void printArray(int[] arr) {
        for (int j : arr) {
            String date = String.valueOf(j);
            System.out.print(date.substring(6, 8) + "-" + date.substring(4, 6) + "-" + date.substring(0, 4) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dates = new int[n];
        for (int i = 0; i < n; i++) {
            String date = br.readLine();
            String day = date.substring(0, 2);
            String month = date.substring(3, 5);
            String year = date.substring(6, 10);
            int number = Integer.parseInt((year + month + day));
            dates[i] = number;
        }

        sort(dates, 0, n - 1);
        printArray(dates);

    }

}
