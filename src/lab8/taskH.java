package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taskH {

    static String longestCommonSubstring(String[] strings) {
        String shortest = strings[0];
        for (String s : strings) if (s.length() < shortest.length()) shortest = s;
        int left = 0, right = shortest.length();
        String longest = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            String common = findCommonSubstring(strings, mid);
            if (common != null) {
                longest = common;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return longest;
    }

    static String findCommonSubstring(String[] strings, int length) {
        Set<String> substrings = new HashSet<>();
        String base = strings[0];
        for (int i = 0; i <= base.length() - length; i++)
            substrings.add(base.substring(i, i + length));
        for (int i = 1; i < strings.length; i++) {
            Set<String> temp = new HashSet<>();
            for (int j = 0; j <= strings[i].length() - length; j++) {
                String sub = strings[i].substring(j, j + length);
                if (substrings.contains(sub)) temp.add(sub);
            }
            substrings = temp;
            if (substrings.isEmpty()) return null;
        }
        return substrings.iterator().next();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfStrings = Integer.parseInt(br.readLine());
        String[] strings = new String[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            strings[i] = br.readLine();
        }

        String result = longestCommonSubstring(strings);
        System.out.println(result);
    }
}

