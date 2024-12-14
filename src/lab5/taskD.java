package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class taskD {

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
        while (heap.get(currentIndex) < heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public static long extractMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        long min = heap.get(0);
        long lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            int currentIndex = 0;
            while (true) {
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);
                int smallest = currentIndex;
                if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                    smallest = left;
                }
                if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
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


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            insert(Integer.parseInt(st.nextToken()));
        }

        int numberOfOperations = 0;
        for (int i = 0; i < n - 1; i++) {
            long smallest = extractMin();
            long secondSmallest = extractMin();
            long mixture = smallest + 2 * secondSmallest;
            insert(mixture);
            numberOfOperations++;
            if (smallest >= x) {
                System.out.println(numberOfOperations - 1);
                return;
            }
        }
        System.out.println(-1);

    }
}
//5 3 9 10 12
//13 9 10 12
//13 29 12
