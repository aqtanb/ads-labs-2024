package lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class taskA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                inputs.add(st.nextToken());
            }
        }

        mergeSort(inputs, 0, inputs.size() - 1);

        for (String input : inputs) {
            System.out.print(input + " ");
        }
    }

    public static void mergeSort(ArrayList<String> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(ArrayList<String> arr, int left, int mid, int right) {
        ArrayList<String> leftList = new ArrayList<>();
        ArrayList<String> rightList = new ArrayList<>();

        for (int i = left; i <= mid; i++) {
            leftList.add(arr.get(i));
        }
        for (int i = mid + 1; i <= right; i++) {
            rightList.add(arr.get(i));
        }

        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                arr.set(k++, leftList.get(i++));
            } else {
                arr.set(k++, rightList.get(j++));
            }
        }

        while (i < leftList.size()) {
            arr.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            arr.set(k++, rightList.get(j++));
        }
    }
}
