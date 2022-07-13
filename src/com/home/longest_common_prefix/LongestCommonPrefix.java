package com.home.longest_common_prefix;

import java.util.HashSet;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String minLengthString = strs[0];
        for(String s : strs) {
            if(s.length() < minLengthString.length()) {
                minLengthString = s;
            }
        }

        StringBuilder commonPrefix = new StringBuilder();
        HashSet<Character> commons = new HashSet<>();
        int symbolCounter = 0;
        while (symbolCounter < 200) {
            if (symbolCounter >= minLengthString.length()) {
                break;
            }
            commons.clear();
            commons.add(minLengthString.charAt(symbolCounter));
            boolean add = false;
            Character stringSymbol = null;
            for (String s : strs) {
                stringSymbol = s.charAt(symbolCounter);
                add |= commons.add(stringSymbol);
            }

            if (add) {
                return commonPrefix.toString();
            } else {
                commonPrefix.append(stringSymbol);
            }
            symbolCounter ++;
        }
        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        String[] input1 = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(input1));

        String[] input2 = {"aac","ab"};
        longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(input2));
    }
}
