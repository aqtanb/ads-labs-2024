package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class taskD {

//    static void KMP_Search(String pat, String text) {
//        int patLength = pat.length();
//        int textLength = text.length();
//        int[] lookupTable = lookupFunction(pat);
//        int i = 0, j = 0;
//        while (i < text.length()) {
//            if (pat.charAt(j) == text.charAt(i)) {
//                i++;
//                j++;
//            }
//            if (pat.length() == j) {
//                System.out.println(i - j);
//                j = lookupTable[j - 1];
//            } else if (i < textLength && pat.charAt(j) != text.charAt(i)) {
//                if (j != 0) {
//                    j = lookupTable[j - 1];
//                } else {
//                    i++;
//                }
//            }
//        }
//    }

    static int[] lookupFunction(String pat) {
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

    public static List<String> checkSuffixOfPrefix(List<String> cities, String previousCity, int numberOfCities) {
        List<String> answers = new ArrayList<>();
        int maxi = 1;
        for (int i = 0; i < numberOfCities; i++) {
            int[] pi = lookupFunction(cities.get(i) + "#" + previousCity);
            if (pi[pi.length - 1] > maxi) {
                maxi = pi[pi.length - 1];
                answers.clear();
                answers.add(cities.get(i));
            } else if (pi[pi.length - 1] == maxi) {
                answers.add(cities.get(i));
            }
        }
        return answers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String previousCity = br.readLine().toLowerCase();
        int numberOfCities = Integer.parseInt(br.readLine());
        List<String> cities = new ArrayList<>();
        previousCity = previousCity.toLowerCase();

        for (int i = 0; i < numberOfCities; i++) {
            String city = br.readLine().toLowerCase();
            cities.add(city);
        }

        List<String> answers = checkSuffixOfPrefix(cities, previousCity, numberOfCities);
        System.out.println(answers.size());
        for (String city : answers) {
            System.out.println(city.substring(0, 1).toUpperCase() + city.substring(1));
        }
    }
}
