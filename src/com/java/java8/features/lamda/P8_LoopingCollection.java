package com.java.java8.features.lamda;

import java.util.Arrays;
import java.util.List;

public class P8_LoopingCollection {
    public static void main(String[] args) {
        List<Persons> listOfPersons = Arrays.asList(
                new Persons("AAAAA","ZZZZZZ",25),
                new Persons("BBBBB","YYYYYY",32),
                new Persons("CCCCC","XXXXXX",21),
                new Persons("DDDDD","WWWWWW",39)
        );

        System.out.println("Using lamda expression");
        listOfPersons.forEach(p -> System.out.println(p));
        System.out.println("Using method reference");
        listOfPersons.forEach(System.out::println);
    }
}
