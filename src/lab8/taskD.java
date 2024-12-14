package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class taskD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int numberOfStrings = Integer.parseInt(br.readLine());
            if (numberOfStrings == 0) break;

            String[] patterns = new String[numberOfStrings];
            for (int i = 0; i < numberOfStrings; ++i) {
                patterns[i] = br.readLine();
            }

            String text = br.readLine();

            Map<String, Integer> frequency = new HashMap<>();
            int maxFrequency = 0;

            for (String pattern : patterns) {
                int count = 0;
                int position = text.indexOf(pattern);
                while (position != -1) {
                    ++count;
                    position = text.indexOf(pattern, position + 1);
                }
                frequency.put(pattern, count);
                if (count > maxFrequency) {
                    maxFrequency = count;
                }
            }

            System.out.println(maxFrequency);
            for (String pattern : patterns) {
                if (frequency.get(pattern) == maxFrequency) {
                    System.out.println(pattern);
                }
            }
        }
    }
}

