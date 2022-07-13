package com.home.length_of_last_word;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello, world"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello, world"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord(""));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("123456789"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("as vfrde,ihjg"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("as qwe qwerty"));
    }
}
