package com.iontrading.functional.interfaces;

import java.util.function.Predicate;

public class PredicateSamples {

    private static Predicate<Integer> isEven_oldStyle = new Predicate<Integer>() {
        @Override
        public boolean test(Integer e) {
            return e % 2 == 0;
        }
    };

    private static Predicate<Integer> isEven = e -> e % 2 == 0;
    private static Predicate<Integer> isGT4 = e -> e >4;


    private static void print(int number, Predicate<Integer> predicate, String msg) {
        System.out.println(number + " "+ msg + ":" + predicate.test(number));
    }

    public static void main(String[] args) {

        print(4, isEven, "isEven ?");
        print(5, isEven, "isEven ?");
        print(6, isGT4, "isGT4 ?");

        print(6, isGT4.and(isEven), "isGT4 and is Even ?");
        print(6, isGT4.or(isEven), "isGT4 or is Even ?");
        print(6, isGT4.negate(), "is NOT GT4?");
    }
}
