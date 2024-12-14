package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();
        List<Integer> primes = new ArrayList<>();

        boolean[] isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 10000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j < 10000; j += i) {
                    isPrime[j] = false;
                }
            }

        }
        List<Integer> superprimes = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            if (isPrime[i]) {
                superprimes.add(primes.get(i - 1));
            }

        }
        System.out.println(superprimes.get(number - 1));



    }
}
