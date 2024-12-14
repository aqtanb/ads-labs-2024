package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskG {
    private static final int BASE = 31;
    private static final long MOD = (long) 1e9 + 9;

    private static long computeHash(String s) {
        long hashValue = 0;
        long p = 1;
        for (char c : s.toCharArray()) {
            hashValue = (hashValue + (c - 'a' + 1) * p) % MOD;
            p = (p * BASE) % MOD;
        }
        return hashValue;
    }

    private static long[] precomputeHashes(String s) {
        int n = s.length();
        long[] hash = new long[n + 1];
        long[] power = new long[n + 1];
        power[0] = 1;

        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] + (s.charAt(i) - 'a' + 1) * power[i]) % MOD;
            power[i + 1] = (power[i] * BASE) % MOD;
        }
        return hash;
    }

    private static int countOccurrences(String S, String pattern, long[] hash, long[] power) {
        int n = S.length();
        int m = pattern.length();
        long patternHash = computeHash(pattern);

        int count = 0;
        for (int i = 0; i <= n - m; i++) {
            long currentHash = (hash[i + m] - hash[i] + MOD) % MOD;
            if (currentHash == (patternHash * power[i] % MOD)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        long[] hash = precomputeHashes(S);
        long[] power = new long[S.length() + 1];
        power[0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            power[i] = (power[i - 1] * BASE) % MOD;
        }

        while (q-- > 0) {
            String[] lr = br.readLine().split(" ");
            int L = Integer.parseInt(lr[0]) - 1;
            int R = Integer.parseInt(lr[1]) - 1;
            String pattern = S.substring(L, R + 1);
            System.out.println(countOccurrences(S, pattern, hash, power));
        }
    }
}


