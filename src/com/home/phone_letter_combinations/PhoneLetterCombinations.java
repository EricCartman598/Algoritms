package com.home.phone_letter_combinations;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneLetterCombinations {

    private static final Map<Character, List<String>> keyboard = Map.of(
            '0', List.of(" "),
            '1', List.of(""),
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {
        List<List<String>> letters = getLetters(digits);

        if(letters.isEmpty()) {
            return Collections.emptyList();
        }

        if (letters.size() == 1) {
            return letters.get(0);
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.addAll(letters.get(0));
        StringBuilder sb = new StringBuilder();
        char[] digitsArray = digits.toCharArray();

        for (int digitIndex = 1; digitIndex < digitsArray.length; digitIndex ++) {
            List<String> strings = keyboard.get(digitsArray[digitIndex]);
            int size = queue.size();
            for(int j = 0; j < size; j ++) {
                String pivot = queue.getFirst();
                for (String s1 : strings) {
                    sb.append(pivot);
                    sb.append(s1);
                    queue.addLast(sb.toString());
                    sb.setLength(0);
                }
                queue.removeFirst();
            }

        }

        return queue.stream().distinct().collect(Collectors.toList());
    }

    private List<List<String>> getLetters(String digits) {
        List<List<String>> letters = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            if (keyboard.containsKey(c)) {
                letters.add(keyboard.get(c));
            }
        }
        return letters;
    }

    public static void main(String[] args) {
        PhoneLetterCombinations combinations = new PhoneLetterCombinations();
        System.out.println(combinations.letterCombinations("23"));
        System.out.println(combinations.letterCombinations(""));
        System.out.println(combinations.letterCombinations("2"));
        System.out.println(combinations.letterCombinations("234"));
    }
}
