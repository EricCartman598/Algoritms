package com.home.at_least_twice_in_array;

import java.util.*;
import java.util.stream.Collectors;

public class AtLeastTwice {

    List<Integer> process(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> data = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Integer pivot = data.get(0);
        int repeatCount = 0;
        for (int num : nums) {
            if (pivot.equals(num)) {
                repeatCount++;
            } else {
                repeatCount = 0;
                pivot = num;
            }

            if (repeatCount < 2) {
                res.add(num);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 7, 7, 7, 7, 8, 8, 8};
        List<Integer> res = new AtLeastTwice().process(arr);

        System.out.println(res);
    }
}
