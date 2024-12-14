package lab2;

import java.util.*;

public class TaskD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        LinkedList<Integer> modes = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        modes.sort(Collections.reverseOrder());
        for (int mode : modes) {
            System.out.print(mode + " ");
        }
    }
}
