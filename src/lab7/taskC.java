package lab7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class taskC {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int sizeFirst = Integer.parseInt(tokenizer.nextToken());
        int sizeSecond = Integer.parseInt(tokenizer.nextToken());

        int[] firstArray = new int[sizeFirst];
        int[] secondArray = new int[sizeSecond];

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < sizeFirst; i++) {
            firstArray[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < sizeSecond; i++) {
            secondArray[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < sizeFirst && j < sizeSecond) {
            if (firstArray[i] < secondArray[j]) {
                i++;
            } else if (firstArray[i] > secondArray[j]) {
                j++;
            } else {
                if (result.length() == 0 || result.charAt(result.length() - 2) != firstArray[i]) {
                    result.append(firstArray[i]).append(" ");
                }
                i++;
                j++;
            }
        }

        System.out.println(result.toString().trim());
    }
}
