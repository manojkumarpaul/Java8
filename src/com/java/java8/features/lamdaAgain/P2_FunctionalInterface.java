package com.java.java8.features.lamdaAgain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.*;

@FunctionalInterface
interface ValidateInteger<T> {
    boolean isNegative(T t);
}
public class P2_FunctionalInterface {
    public static void main(String[] args) {
        ValidateInteger<Integer> validateInteger1 = new ValidateInteger<Integer>() {
            @Override
            public boolean isNegative(Integer integer) {
                return integer < 0;
            }
        };

        ValidateInteger<Integer> validateInteger2 = i -> i<0;

        System.out.println(validateInteger1.isNegative(3));
        System.out.println(validateInteger2.isNegative(-1));

        //Predicate<T> is a java system functional interface
        letsUsePredicate();

        //BiPredicate<T,U> is a java system functional interface with two params
        letsUseBiPredicate();

        //Supplier<T> is a java system functional interface
        letsUseSupplier();

        //Consumer<T> is a java system functional interface
        letsUseConsumer();

        //Function<T,R> is a java system functional interface
        letsUseFunction();

        //Function<T,R> is a java system functional interface
        letsUseUnaryBinaryOperator();
    }

    private static void letsUseUnaryBinaryOperator() {
        UnaryOperator<String> unaryOperator = s -> "Name is: "+ s;
        System.out.println(unaryOperator.apply("Manoj Paul"));

        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        System.out.println(binaryOperator.apply("Jai Shri ", "Ram"));
    }

    private static void letsUseFunction() {
        Function<String, Integer> function = s -> s.length();
        System.out.println("Length of string: "+function.apply("Hello World"));

        BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.length() + s2.length();
        System.out.println(biFunction.apply("Learn from your mistake, do not repeat","Manoj"));
    }

    private static void letsUseConsumer() {
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Learn from your mistake, do not repeat"); //Learn from your mistake, do not repeat

        List<String> names = new ArrayList();
        names.add("Manoj");
        names.add("Payal");
        names.add("Aaron");
        names.add("Tisya");

        names.forEach(printConsumer);/*Manoj
                                        Payal
                                        Aaron
                                        Tisya*/

        var mapCapitalCities = new HashMap<String, String>();
        BiConsumer<String, String> biConsumerPopulateMap = (k, v) -> mapCapitalCities.put(k, v);
        biConsumerPopulateMap.accept("Assam","Dispur");
        biConsumerPopulateMap.accept("Karnataka","Bengaluru");

        BiConsumer<String, String> biConsumerPopulateMapPrint = (k, v) -> System.out.println(k+ " Capital is "+v);
        mapCapitalCities.forEach(biConsumerPopulateMapPrint);
        /*
        * Assam Capital is Dispur
        Karnataka Capital is Bengaluru
        * */
    }

    private static void letsUseSupplier() {
        Supplier<StringBuilder> stringBuilderSupplier = () -> new StringBuilder();
        System.out.println(stringBuilderSupplier.get().append("Anything"));

        Supplier<LocalTime> fetchTime = () -> LocalTime.now();
        System.out.println(fetchTime.get());

        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println(randomNumber.get());
    }

    private static void letsUseBiPredicate() {
        BiPredicate<String,Integer> biPredicate = (t,u) -> t.length() == u;
        String messageString = "Bengaluru City";
        int leng = 14;
        System.out.println(leng+" Length menctioned is "+biPredicate.test(messageString, leng));
    }

    private static void letsUsePredicate() {
//For Integer type
        Predicate<Integer> predicate = i -> i<0;

        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));

        Predicate<Integer> predicateEvenOdd = i -> i % 2 == 0;
        int x = 2;
        System.out.println("The condition of the number " +x+ " to be even is : "+predicateEvenOdd.test(x));
        x=3;
        System.out.println("The condition of the number " +x+ " to be even is : "+check(x, i -> i % 2 == 0));

//For String type
        String messageString = "Mr.Paul is good";

        //Predicate<String> predicateContains = s -> s.startsWith("Mr.");
        System.out.println("Does "+messageString+" starts with Mr.? "+check(messageString, s -> s.startsWith("Mr.")));
        messageString = "Ms.Payal is good";
        System.out.println("Does "+messageString+" starts with Mr.? "+check(messageString, s -> s.startsWith("Mr.")));
    }

    private static <T> boolean check(T t, Predicate<T> lamda){
        return lamda.test(t);
    }
}
