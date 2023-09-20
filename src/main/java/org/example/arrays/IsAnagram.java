package org.example.arrays;

public class IsAnagram {

        public static void main(String[] args) {
            String a = "rat";
            String b = "car";
            System.out.println(isAnagram(a,b));
        }
        public static boolean isAnagram(String s, String t) {
            char[] chars = new char[26];
            if (s.length() != t.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - (int) 'a';
                chars[index]++;
            }

            for (int i = 0; i < t.length(); i++) {
                int index = t.charAt(i) - (int) 'a';
                if (chars[index] == 0) {
                    return false;
                } else {
                    chars[index]--;
                }
            }
            return true;
        }
    }

