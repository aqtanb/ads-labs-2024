package lab6; // heap sort, quick sort

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class taskA {

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

    static void printArray(char[] arr) {
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> consonants = new ArrayList<>();
        for (char ch : arr) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels.add(ch);
            } else {
                consonants.add(ch);
            }
        }
        for (char ch : vowels) {
            System.out.print(ch);
        }
        for (char ch : consonants) {
            System.out.print(ch);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        sort(s, 0, n - 1);
        printArray(s);
    }
}
