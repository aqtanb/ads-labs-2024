package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class taskB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String student1 = reader.readLine();
        String student2 = reader.readLine();
        String parasite = reader.readLine();

        int pLen = parasite.length();
        int base = 31;
        long mod = 1000000007;

        long parasiteHash = computeHash(parasite, base, mod);
        HashSet<Integer> student1Matches = new HashSet<>();

        long basePower = 1;
        for (int i = 0; i < pLen - 1; i++) {
            basePower = (basePower * base) % mod;
        }

        long currentHash = computeHash(student1.substring(0, pLen), base, mod);
        if (currentHash == parasiteHash) student1Matches.add(0);

        for (int i = pLen; i < student1.length(); i++) {
            currentHash = (currentHash - student1.charAt(i - pLen) * basePower % mod + mod) % mod;
            currentHash = (currentHash * base + student1.charAt(i)) % mod;
            if (currentHash == parasiteHash) student1Matches.add(i - pLen + 1);
        }

        currentHash = computeHash(student2.substring(0, pLen), base, mod);
        int commonCount = student1Matches.contains(0) && currentHash == parasiteHash ? 1 : 0;

        for (int i = pLen; i < student2.length(); i++) {
            currentHash = (currentHash - student2.charAt(i - pLen) * basePower % mod + mod) % mod;
            currentHash = (currentHash * base + student2.charAt(i)) % mod;
            if (student1Matches.contains(i - pLen + 1) && currentHash == parasiteHash) {
                commonCount++;
            }
        }

        System.out.println(commonCount);
    }

    private static long computeHash(String s, int base, long mod) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * base + s.charAt(i)) % mod;
        }
        return hash;
    }
}
