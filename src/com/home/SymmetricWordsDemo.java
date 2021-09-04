package com.home;

public class SymmetricWordsDemo {
    private static final String word1 = "ABBA";
    private static final String word2 = "RSFSR";
    private static final String word3 = "QWERT";
    private static final String word4 = "QWERTY";

    public static void main(String[] args) {
        System.out.println(isSymmetric(word1));
        System.out.println(isSymmetric(word2));
        System.out.println(isSymmetric(word3));
        System.out.println(isSymmetric(word4));
    }

    private static boolean isSymmetric(String word) {
        boolean isSymmetric = true;
        int length = word.length();
        int middlePivot = length % 2 != 0 ? length / 2 : (length / 2) - 1;
        for (int i = 0; i <= middlePivot; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                isSymmetric = false;
                break;
            }
        }
        return isSymmetric;
    }
}
