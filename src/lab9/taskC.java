package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class taskC {
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
                return i - j;
            } else if (i < textLength && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lookupTable[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
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
        String tamerlan = br.readLine();
        String alikhan = br.readLine();

        String doubled = tamerlan + tamerlan;
        int index = KMPSearch(alikhan, doubled);

        if (index == -1 || index >= tamerlan.length()) {
            System.out.println(-1);
        } else {
            System.out.println(alikhan.length() - index);
        }
    }
}