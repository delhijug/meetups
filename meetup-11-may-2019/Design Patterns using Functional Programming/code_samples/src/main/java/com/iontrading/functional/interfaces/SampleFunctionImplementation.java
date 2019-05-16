package com.iontrading.functional.interfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SampleFunctionImplementation {

    private static Function<Integer, Integer> add5_oldStyle = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer x) {
            return x+5;
        }
    };

    private static Function<Integer, Integer> add5 = x -> x+5;

    private static Function<Integer, Integer> square  = x -> x*x;
    private static Function<Integer, Integer> cube  = x -> x*x*x;



    private static Function<Integer, Function<Integer, Integer>> add = x -> y -> x+y;
    private static BiFunction<Integer, Integer, Integer> add1 = (x,y) -> x+y;

    //Currying
    private static Function<Integer, Integer> add2 = add.apply(2);

    private static Function<Integer, Integer> add5AndSquare =  x -> square.apply(add5.apply(x));

    //Composition
    private static Function<Integer, Integer> add5AndSquare_1 =  add5.andThen(square);

    private static Function<Integer, Integer> squareAndAdd5Andadd2 =  square.andThen(add5).andThen(add2);



    public static void main(String[] args) {
        System.out.println(add5_oldStyle.apply(10));
        System.out.println(add5.apply(10));
        System.out.println(square.apply(5));
        System.out.println(cube.apply(5));

        System.out.println(add2.apply(5));

        System.out.println(add5AndSquare.apply(2));
        System.out.println(add5AndSquare_1.apply(2));

        System.out.println(squareAndAdd5Andadd2.apply(2));


    }
}
