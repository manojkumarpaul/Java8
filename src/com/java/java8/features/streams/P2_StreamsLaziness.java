package com.java.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;



public class P2_StreamsLaziness {
    public static void main(String[] args) {
        usingFilter();
        usingMap();
        usingMoreSample();
    }

    private static void usingMoreSample() {
        List<String> names = Arrays.asList("Tisya","Aaron","Payal","Manoj","Paul");
        names.stream()
                .peek(System.out::println)
                .filter(c -> {
                    System.out.println("Filter1 : "+c);
                    return c.startsWith("T") || c.startsWith("A"); // Tisya, Aaron
                })
                .filter(s -> {
                    System.out.println("Filter2 : "+ s);
                    return s.length() > 4;
                })
                .limit(1)       //intermediate operation Stream<T> limit(long)
                .forEach(System.out::println);
        /*
         Tisya
         Filter1 : Tisya
         Filter2 : Tisya
         Tisya*/

    }

    private static void usingMap() {
        Stream.of("Tisya","Aaron","Payal","Manoj","Paul")
                .map(s -> {
                    System.out.println("FilterMap is : "+ s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("Map Anymatch: "+s);
                    return s.startsWith("P");
                });
        /*
        FilterMap is : Tisya
        Map Anymatch: TISYA
        FilterMap is : Aaron
        Map Anymatch: AARON
        FilterMap is : Payal
        Map Anymatch: PAYAL*/
    }

    private static void usingFilter() {
        Stream.of("Tisya","Aaron","Payal","Manoj","Paul")
                .filter(s -> {
                    System.out.println("Filter is : "+ s);
                    return true;
                })
                .forEach(s -> System.out.println("For each : "+s));

        /*
        Filter is : Tisya
        For each : Tisya
        Filter is : Aaron
        For each : Aaron
        Filter is : Payal
        For each : Payal
        Filter is : Manoj
        For each : Manoj
        Filter is : Paul
        For each : Paul*/
    }
}
