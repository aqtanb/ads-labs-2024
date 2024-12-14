package lab8; // hash tables, rabin karp

import java.util.*;

class taskA {
    public static String hashedRes(String s, int mod, int inc) {
        long p = 1;
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = (res + ((s.charAt(i) - 47) * p) % mod) % mod;
            p = (p * inc) % mod;
        }
        return Long.toString(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = scanner.nextInt();
        int count = 0;
        List<String> values = new ArrayList<>();
        Map<String, String> hashmap = new HashMap<>();

        for (int i = 0; i < numberOfStrings * 2; i++) {
            String s = scanner.next();
            values.add(s);
            hashmap.put(s, hashedRes(s, 1000000007, 11));
        }

        for (String i : values) {
            String str = hashedRes(i, 1000000007, 11);
            if (hashmap.containsKey(str)) {
                System.out.println("Hash of string \"" + i + "\" is " + str);
                count++;
            }
            if (count == numberOfStrings) {
                break;
            }
        }
        scanner.close();
    }
}

