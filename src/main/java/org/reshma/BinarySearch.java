package org.reshma;

public class BinarySearch {
    public static void main(String[] args) {
     String p ="natan";
        System.out.println(isPalindrome(p));
    }

    public static boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        for (int i = 0; i <= len-1; i++) {
            if (ch[i] != ch[len-1-i])
                return false;
        }
        return true;
    }

}
