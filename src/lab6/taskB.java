package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class taskB {

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
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 0 || m == 0) {
            return;
        }

        st = new StringTokenizer(br.readLine());


        int[] firstArray = new int[n];
        for (int i = 0; i < n; i++) {
            firstArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] secondArray = new int[m];
        for (int i = 0; i < m; i++) {
            secondArray[i] = Integer.parseInt(st.nextToken());
        }

        sort(firstArray, 0, n - 1);
        sort(secondArray, 0, m - 1);

        int first = 0;
        int second = 0;
        while (first < n && second < m) {

            if (firstArray[first] == secondArray[second]) {
                System.out.print(firstArray[first] + " ");
                first++;
                second++;
            } else if (firstArray[first] > secondArray[second]) {
                second++;
            } else {
                first++;
            }

        }

    }
}
