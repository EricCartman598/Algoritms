package com.home;

import java.util.HashMap;
import java.util.Map;

public class SymbolsCountDemo {
    private static final String inputString = "АААВВССССD";

    public static void main(String[] args) {
        char ethalonSymbol = inputString.charAt(0);
        int counter = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if(c == ethalonSymbol) {
                counter ++;
            } else {
                map.put(String.valueOf(ethalonSymbol), counter);
                counter = 1;
                ethalonSymbol = c;
            }
        }
        map.put(String.valueOf(ethalonSymbol), counter);
        System.out.println(map);
    }
}
