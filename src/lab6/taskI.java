package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class taskI {

    static void random(char[] arr, int low, int high) {
        Random random = new Random();
        int pivot = random.nextInt(high - low) + low;
        char temp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;
    }


    static int partition(char[] arr, int low, int high) {
        random(arr, low, high);
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(char[] arr, int low, int high) {
        if (low < high) {
            int partIndex = partition(arr, low, high);
            sort(arr, low, partIndex - 1);
            sort(arr, partIndex + 1, high);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        sort(s, 0, s.length - 1);
        System.out.println(s);
    }
}
