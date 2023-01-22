package com.java.java8.features.streams;

import java.util.Arrays;
import java.util.List;

public class P1_Streams {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(104,98,99,100,102,103,101,95);

        System.out.println("Number of temperature 100 & above " +
                integerList                             //Source
                        .stream()                       //Stream the source
                        .peek(System.out::println)      //Intermediate operations
                        .filter(temp -> temp >= 100)    //Intermediate operations
                        .peek(System.out::println)      //Intermediate operations
                        .count());                      //Terminal operations
    }

}
