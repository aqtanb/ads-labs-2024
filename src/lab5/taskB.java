package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class taskB {

    static private ArrayList<Long> heap = new ArrayList<>();

    static private int parent(int i) {
        return (i - 1) / 2;
    }
    private static int leftChild(int i) {
        return i * 2 + 1;
    }
    private static int rightChild(int i) {
        return i * 2 + 2;
    }

    static private void swap(int i, int j) {
        long temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    static private void insert(long value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public static long extractMax() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        long max = heap.get(0);
        long lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            int currentIndex = 0;
            while (true) {
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);
                int largest = currentIndex;
                if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                    largest = left;
                }
                if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                    largest = right;
                }
                if (largest == currentIndex) {
                    break;
                }
                swap(currentIndex, largest);
                currentIndex = largest;
            }
        }
        return max;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            insert(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n - 1; i++) {
            long merge = extractMax() - extractMax();
            insert(merge);
        }

        System.out.println(heap.isEmpty() ? 0 : extractMax());

    }
}