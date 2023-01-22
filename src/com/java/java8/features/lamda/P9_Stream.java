package com.java.java8.features.lamda;

import java.util.Arrays;
import java.util.List;

public class P9_Stream {
    public static void main(String[] args) {
        List<Persons> listOfPersons = Arrays.asList(
                new Persons("AAAAA","ZZZZZZ",25),
                new Persons("BBBBB","YYYYYY",32),
                new Persons("CCCCC","XXXXXX",21),
                new Persons("DDDDD","WWWWWW",39)
        );

        listOfPersons.stream()
                .filter(p -> p.getLastName().startsWith("X"))
                .forEach(p -> System.out.println(p));
    }
}
