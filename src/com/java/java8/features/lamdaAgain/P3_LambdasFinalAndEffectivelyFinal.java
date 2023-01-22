package com.java.java8.features.lamdaAgain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class P3_LambdasFinalAndEffectivelyFinal {

    public static void main(String[] args) {
        int x = 32; //This is effectively final var - without final keyword and you cant change in lamda.
        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Manoj");
        listOfNames.add("Aaron");

        Predicate<String> lamda = s -> {
            System.out.println("x== "+x);
            //x= 15;//we cant do this
            return listOfNames.isEmpty() & x%2 == 0;
        };
        filterData(listOfNames, lamda);
        //x = 15; //we can do it if lamda not using it
        System.out.println("List elements== "+listOfNames);
    }

    private static void filterData(List<String> listOfNames, Predicate<String> lamda) {
        Iterator<String> i = listOfNames.iterator();
        while(i.hasNext()){
            if(lamda.test((i.next())))
                i.remove();
        }
    }

}
