package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class taskH {

    static void KMP_Search(String pat, String text) {
        int patLength = pat.length();
        int textLength = text.length();
        int[] lookupTable = lookup(pat);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (pat.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (pat.length() == j) {
                System.out.println(i - j);
                j = lookupTable[j - 1];
            } else if (i < textLength && pat.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lookupTable[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    static int[] lookup(String pat) {
        int length = pat.length();
        int[] lookupTable = new int[length];
        int idx = 0;
        for (int j = 1; j < length; j++) {
            while (idx != 0 && pat.charAt(idx) != pat.charAt(j)) {
                idx = lookupTable[idx - 1];
            }
            if (pat.charAt(idx) == pat.charAt(j)) {
                idx++;
            }
            lookupTable[j] = idx;
        }
        return lookupTable;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] lookupTable = lookup(str);
        int answer = 0, strLength = str.length();
        for (int i = 1; i < strLength; i++) {
            int len = i - lookupTable[i - 1];
            if (i % len == 0 && (i / len) % 2 == 0) {
                answer++;
            }
        }
        System.out.println(answer);

    }
}
