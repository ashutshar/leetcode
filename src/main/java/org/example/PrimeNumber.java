package org.example;

public class PrimeNumber {

    static StringBuilder sb = new StringBuilder();

    static int lastPrimeAdded = 1;

    //static int STRING_LENGTH = 0;
    public static boolean isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String rangeOfPrime(int n) {
        //StringBuilder sb = new StringBuilder();
        if (n > lastPrimeAdded) {
            for(long i = lastPrimeAdded + 1; i <= n; i++) {
                if (isPrime(i)) {
                    sb.append(i);
                }
            }
            lastPrimeAdded = n;
        }

        return sb.toString();
    }

    public static String solution(int i) {
        String primes = rangeOfPrime(100000);
        return primes.substring(i, i+5);
    }

    public static void main(String[] args) {
        System.out.println(solution(0));
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(100));
    }
}
