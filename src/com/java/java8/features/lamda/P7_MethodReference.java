package com.java.java8.features.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P7_MethodReference {
    private static List<Persons> personsList;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printMessage()); // with lamda expression
        t1.start();

        Thread t2 = new Thread(P7_MethodReference::printMessageToo); // with method reference no argument method
        t2.start();

        loadAList();
        //print the list
        System.out.println("Printing all persons");
        printConditionally(personsList, p -> true, System.out::println); // with method reference argument method

    }

    private static void loadAList() {
        personsList = Arrays.asList(
                new Persons("AAAAA","ZZZZZZ",25),
                new Persons("BBBBB","YYYYYY",32),
                new Persons("CCCCC","XXXXXX",21),
                new Persons("DDDDD","WWWWWW",39)
        );
    }

    private static void printConditionally(List<Persons> listOfPersons, Predicate<Persons> predicate,
                                           Consumer<Persons> consumer) {
        for(Persons p: listOfPersons) {
            if(predicate.test(p))
                consumer.accept(p);
        }
    }

    public static void printMessage(){
        System.out.println("Hi Aaron");
    }

    public static void printMessageToo(){
        System.out.println("Hi Cia");
    }
}
