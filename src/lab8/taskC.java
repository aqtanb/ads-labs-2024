package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class taskC {
    private static final long mod = (long) 1e9 + 7;
    private static final int p = 11;
    private static List<Long> hashes;
    private static boolean[] saw;

    private static long getHash(String s) {
        long h = 1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = (res + (s.charAt(i) - 'a' + 1) * h) % mod;
            h = (h * p) % mod;
        }
        return res;
    }

    private static void pref(String s) {
        hashes = new ArrayList<>(s.length());
        long h = 1;
        saw = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            long hashValue = (s.charAt(i) - 'a' + 1) * h % mod;
            hashes.add(hashValue);
            if (i > 0) {
                hashes.set(i, (hashes.get(i) + hashes.get(i - 1)) % mod);
            }
            h = (p * h) % mod;
        }
    }

    private static void rob(String s, String pattern) {
        long smlhash = getHash(pattern);
        for (int i = 0; i <= s.length() - pattern.length(); i++) {
            long bighash = hashes.get(i + pattern.length() - 1);
            if (i > 0) {
                bighash -= hashes.get(i - 1);
            }
            if (bighash < 0) {
                bighash += mod;
            }
            if (i > 0) {
                smlhash = (smlhash * p) % mod;
            }
            if (smlhash == bighash) {
                for (int pll = i; pll < i + pattern.length(); pll++) {
                    saw[pll] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        pref(s);
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String text = br.readLine();
            rob(s, text);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!saw[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

