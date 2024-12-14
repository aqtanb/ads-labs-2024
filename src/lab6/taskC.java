package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taskC {

    static ArrayList<Integer> heap = new ArrayList<>();

    static int parent(int i) {
        return (i - 1) / 2;
    }
    static int leftChild(int i) {
        return i * 2 + 1;
    }
    static int rightChild(int i) {
        return i * 2 + 2;
    }

    static void swap(int firstIndex, int secondIndex) {
        int firstValue = heap.get(firstIndex);
        int secondValue = heap.get(secondIndex);
        heap.set(secondIndex, firstValue);
        heap.set(firstIndex, secondValue);
    }

    static void insert(int number) {
        heap.add(number);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    static int extractMin() {
        if (heap.isEmpty()) return Integer.MAX_VALUE;
        int min = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            int currentIndex = 0;
            while (true) {
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);
                int smallest = currentIndex;

                if (heap.size() > left && heap.get(smallest) > heap.get(left)) {
                    smallest = left;
                }
                if (heap.size() > right && heap.get(smallest) > heap.get(right)) {
                    smallest = right;
                }

                if (smallest == currentIndex) {
                    break;
                }
                swap(currentIndex, smallest);
                currentIndex = smallest;
            }
        }
        return min;
    }

    static int[] heapSort(int[] arr) {
        heap.clear();
        for (int num : arr) {
            insert(num);
        }

        int[] sortedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArray[i] = extractMin();
        }
        return sortedArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArray = heapSort(array);

        int leastDiff = Integer.MAX_VALUE;
        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(sortedArray[i + 1] - sortedArray[i]);
            if (diff < leastDiff) {
                leastDiff = diff;
                pairs.clear();
                pairs.add(sortedArray[i] + " " + sortedArray[i + 1]);
            } else if (diff == leastDiff) {
                pairs.add(sortedArray[i] + " " + sortedArray[i + 1]);
            }
        }

        for (String pair : pairs) {
            System.out.print(pair + " ");
        }
    }
}