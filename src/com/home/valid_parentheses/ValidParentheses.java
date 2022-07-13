package com.home.valid_parentheses;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private static Map<Character, Character> validPairs = Map.of('(', ')', '[', ']', '{', '}');
    private Stack<Character> stack;

    boolean isValid(String input) {
        stack = new Stack<>();
        for (int i = 0; i < input.length(); i ++) {
            if(!checkSymbol(input.charAt(i))) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean checkSymbol(char symbol) {
        if (isOpenParenthes(symbol)) {
            stack.push(symbol);
            return true;
        } else if (isCloseParenthes(symbol)) {
            if (stack.isEmpty()) {
                return false;
            } else {
                Character pop = stack.pop();
                if (validPairs.get(pop).equals(symbol)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private boolean isCloseParenthes(char symbol) {
        return validPairs.containsValue(symbol);
    }

    private boolean isOpenParenthes(char symbol) {
        return validPairs.containsKey(symbol);
    }

    public static void main(String[] args) {
        ValidParentheses p = new ValidParentheses();
        System.out.println(p.isValid("((()))"));
        System.out.println(p.isValid("((())"));
        System.out.println(p.isValid("((())}"));
        System.out.println(p.isValid("({())}"));
        System.out.println(p.isValid("((((("));
        System.out.println(p.isValid("]]]]"));
        System.out.println(p.isValid("{(())}"));
    }
}
