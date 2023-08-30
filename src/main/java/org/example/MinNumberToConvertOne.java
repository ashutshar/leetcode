package org.example;

import java.math.BigInteger;
import java.util.HashMap;

public class MinNumberToConvertOne {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("10");
        BigInteger b = new BigInteger("10");
        System.out.println(a.equals(b));
        System.out.println(solution("214748364799214748364799"));
    }

    public static int solution(String x) {
        HashMap<BigInteger, Integer> map = new HashMap<>();
       return (int) count(new BigInteger(x), map);
    }

    public static int count(BigInteger n, HashMap<BigInteger, Integer> map) {
        //System.out.println(n);
        int evenCount = 0;
        if (n.equals(new BigInteger("1"))) {
            map.put(new BigInteger("1"), 0);
            return 0;
        }
        if (n.remainder(new BigInteger("2")).equals(new BigInteger("0"))) {
            BigInteger x = n.divide(new BigInteger("2"));
            if(!map.containsKey(x)){
                map.put(x, count(x,map));
            }
            map.put(n, map.get(x)+1);
            return map.get(n);
        } else {
            BigInteger x = n.subtract(new BigInteger("1"));
            BigInteger y = n.add(new BigInteger("1"));
            if(!map.containsKey(x)){
                map.put(x, count(x,map));
            }
            if(!map.containsKey(y)){
                map.put(y, count(y,map));
            }
            int left = map.get(x);
            int right = map.get(y);
            map.put(n, Math.min(left, right) + 1);
            return  map.get(n);
        }
    }
}
