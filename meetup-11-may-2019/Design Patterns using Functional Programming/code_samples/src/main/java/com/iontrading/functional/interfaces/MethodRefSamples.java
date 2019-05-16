package com.iontrading.functional.interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MethodRefSamples extends ParentSample{

    //Static
    private static Predicate<Integer> greaterThanFive_LambdaStyle = e -> greaterThanFive(e);
    private static Predicate<Integer> greaterThanFive = MethodRefSamples::greaterThanFive;

    //Static
    private static Consumer<Integer> sysOutConsumer_LambdaStyle = x -> System.out.print(x);
    private static Consumer<Integer> sysOutConsumer = System.out::print;

    //This
    private Predicate<Integer> greaterZero_LambdaStyle = x -> this.greaterZero(x);
    private Predicate<Integer> greaterZero = this::greaterZero;


    //Super
    private Predicate<Integer> greaterZeroPredicate = super::greaterZero;



    private Supplier<Map> mapSupplier = HashMap::new; // Constructor method reference


    public static void main(String[] args) {

        Stream.of(1, 2, 3,6,7)
                .filter(greaterThanFive) // Static method reference
                .forEach(System.out::println);
    }

    public void sortNumbers() {
        Stream.of(1, 2, 3)
                .filter(this.greaterZero) // Instance method reference
                .filter(greaterZeroPredicate) // Super method reference
                .forEach(sysOutConsumer);
    }

    public boolean greaterZero (int n) {
        return n>0;
    }


    private static boolean greaterThanFive(int number) {
        return number > 5;
    }

}

class ParentSample  {
    public boolean greaterZero (int n) {
        return n>=0;
    }
}

