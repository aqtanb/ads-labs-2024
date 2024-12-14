package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class taskG {

    static int[] computeArray(String pat, int patternLength) {
        int[] lookupTable = new int[patternLength];
        int idx = 0;
        for (int j = 1; j < patternLength; j++) {
            while (idx > 0 && pat.charAt(idx) != pat.charAt(j)) {
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
        String input = br.readLine();
        int inputLength = input.length();

        int[] lookupTable = computeArray(input, inputLength);

        int periodicity = inputLength - lookupTable[inputLength - 1];
        System.out.println(Arrays.toString(lookupTable));
        System.out.println(periodicity);
    }
}
