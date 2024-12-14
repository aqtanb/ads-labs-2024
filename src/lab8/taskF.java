package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class taskF {
    public static int[] buildSuffixArray(String s) {
        int n = s.length();
        int[] suffixArray = new int[n];
        int[] rank = new int[n];
        int[] tempRank = new int[n];
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; ++i) {
            suffixArray[i] = i;
            order[i] = i;
            rank[i] = s.charAt(i);
        }

        for (int k = 1; k < n; k *= 2) {
            final int step = k;
            Arrays.sort(order, (a, b) -> {
                if (rank[a] != rank[b]) return Integer.compare(rank[a], rank[b]);
                int rankA_k = (a + step < n) ? rank[a + step] : -1;
                int rankB_k = (b + step < n) ? rank[b + step] : -1;
                return Integer.compare(rankA_k, rankB_k);
            });

            for (int i = 0; i < n; i++) {
                suffixArray[i] = order[i];
            }

            tempRank[suffixArray[0]] = 0;
            for (int i = 1; i < n; ++i) {
                tempRank[suffixArray[i]] = tempRank[suffixArray[i - 1]] +
                        ((rank[suffixArray[i - 1]] != rank[suffixArray[i]] ||
                                ((suffixArray[i - 1] + step < n ? rank[suffixArray[i - 1] + step] : -1) !=
                                        (suffixArray[i] + step < n ? rank[suffixArray[i] + step] : -1))) ? 1 : 0);
            }
            System.arraycopy(tempRank, 0, rank, 0, n);
        }
        return suffixArray;
    }

    public static int[] buildLCPArray(String s, int[] suffixArray) {
        int n = s.length();
        int[] rank = new int[n];
        int[] lcp = new int[n - 1];
        for (int i = 0; i < n; ++i) {
            rank[suffixArray[i]] = i;
        }

        int h = 0;
        for (int i = 0; i < n; ++i) {
            if (rank[i] > 0) {
                int j = suffixArray[rank[i] - 1];
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) {
                    ++h;
                }
                lcp[rank[i] - 1] = h;
                if (h > 0) --h;
            }
        }
        return lcp;
    }

    public static int countDistinctSubstrings(String s) {
        int n = s.length();
        int[] suffixArray = buildSuffixArray(s);
        int[] lcpArray = buildLCPArray(s, suffixArray);

        int totalSubstrings = 0;
        for (int i = 0; i < n; ++i) {
            int numSubstringsStartingHere = n - suffixArray[i];
            if (i > 0) {
                numSubstringsStartingHere -= lcpArray[i - 1];
            }
            totalSubstrings += numSubstringsStartingHere;
        }
        return totalSubstrings;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(countDistinctSubstrings(s));
    }
}
