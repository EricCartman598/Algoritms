package com.home.valid_palindrome;

public class ValidPalindrome {

    private static final String VALID_SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyz";
    public boolean isPalindrome(String s) {

        if (s.isBlank()) return true;
        if (s.length() == 1) return true;

        StringBuilder sb = new StringBuilder();
        for(char c : s.toLowerCase().toCharArray()) {
            if (VALID_SYMBOLS.contains(String.valueOf(c))) {
                sb.append(c);
            }
        }

        // 1 way
//        String s1 = sb.toString();
//        String s2 = sb.reverse().toString();
//        return s1.equals(s2);

        // 2 way
        int p1 = 0;
        int p2 = sb.toString().length() - 1;
        boolean isPalindrome = true;
        char[] chars = sb.toString().toCharArray();
        while (p1 < p2) {
            if (chars[p1] == chars[p2]) {
                p1++;
                p2--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("qwwerty"));
        System.out.println(new ValidPalindrome().isPalindrome("asddsa"));
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
        System.out.println(new ValidPalindrome().isPalindrome(" "));
        System.out.println(new ValidPalindrome().isPalindrome("p"));
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));

    }
}
