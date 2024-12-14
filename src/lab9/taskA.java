package lab9; // knuth-morris-pratt

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class taskA {
    static int KMPSearch(String pat, String txt)
    {
        int textLength = txt.length();
        int patternLength = pat.length();
        int[] lookupTable = new int[patternLength];
        computeArray(pat, patternLength, lookupTable);

        int i = 0, j = 0;
        int numberOfOccurrences = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while (i < textLength) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == patternLength) {
                numberOfOccurrences++;
                al.add(i - j + 1);
                j = lookupTable[j - 1];
            } else if (i < textLength && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lookupTable[j - 1];
                } else {
                    i++;
                }
            }
        }
        return numberOfOccurrences;
    }

    static void computeArray(String pat, int patternLength, int[] lookupTable) {
        int idx = 0;
        int j = 1;
        while (j < patternLength) {
            if (pat.charAt(idx) == pat.charAt(j)) {
                idx++;
                lookupTable[j] = idx;
                j++;
            } else {
                if (idx != 0) {
                    idx = lookupTable[idx - 1];
                } else {
                    lookupTable[j] = idx;
                    j++;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String txt = br.readLine();
        String pat = br.readLine();

        StringBuilder repeatedA = new StringBuilder();
        int repetitions = 0;

        while (repeatedA.length() < pat.length()) {
            repeatedA.append(txt);
            repetitions++;
        }

        if (KMPSearch(pat, String.valueOf(repeatedA)) > 0) {
            System.out.println(repetitions);
            return;
        }

        repeatedA.append(txt);
        repetitions++;

        if (KMPSearch(pat, String.valueOf(repeatedA)) > 0) {
            System.out.println(repetitions);
            return;
        }


        System.out.println(-1);
    }
}
