package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskE {

    static void KMP_Search(String pat, String text) {
        int patLength = pat.length();
        int textLength = text.length();
        int[] lookupTable = lookup(pat, patLength);
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

    static int[] lookup(String pat, int length) {
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
        StringTokenizer st;
        int numberOfNames = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfNames; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int repeats = Integer.parseInt(st.nextToken());
            int[] lookupTable = lookup(name, name.length());
            int lap = lookupTable[name.length() - 1];
            System.out.println(name.length() + (repeats - 1) * (name.length() - lap));
        }
    }
}
