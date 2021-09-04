package com.home;

import java.util.*;

public class IntersectionDemo {
    private static final List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c", "s", "r", "p", "1", "2", "3"));
    private static final List<String> list2 = new ArrayList<>(Arrays.asList("x", "y", "z", "8", "9", "s", "r", "7", "p"));

    public static void main(String[] args) {
        printIntersection_option1();
        printIntersection_option2();
    }

    private static void printIntersection_option1() {
        Set<String> intersections = new HashSet<>();
        for(String s1 : list1) {
            for(String s2 : list2) {
                if(s1.equals(s2)) {
                    intersections.add(s2);
                }
            }
        }
        System.out.println(intersections);
    }

    private static void printIntersection_option2() {
        Set<String> firstListValues = new HashSet<>(list1);
        list2.removeIf(firstListValues::add);
        System.out.println(list2);
    }
}
