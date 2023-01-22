package com.java.java8.features.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P5_Java8WayOfSortingList {
    public static void main(String[] args) {
        List<Persons> listOfPersons = Arrays.asList(
                new Persons("AAAAA","ZZZZZZ",25),
                new Persons("BBBBB","YYYYYY",32),
                new Persons("CCCCC","XXXXXX",21),
                new Persons("DDDDD","WWWWWW",39)
        );

        //sort the list by lastname
        //ComparatorList listComparator = new ComparatorList();
        Collections.sort(listOfPersons, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        //print the list
        System.out.println("Printing all persons");
        doPrint(listOfPersons);
        //create a method that prints those lastname begining with X
        System.out.println("Printing all persons with lastname X");
        printConditionally(listOfPersons,
                p -> p.getLastName().startsWith("X"),
                p -> System.out.println(p));

        //create a method that prints those Firstname begining with B
        System.out.println("Printing all persons firstname B");
        printConditionally(listOfPersons,
                p -> p.getFirstName().startsWith("B"),
                p -> System.out.println(p));
    }

    /*private static void printConditionally(List<Persons> listOfPersons, Conditions condition) {
        for(Persons p: listOfPersons) {
            if(condition.testMe(p))
                System.out.println(p);
        }
    }*/

    private static void printConditionally(List<Persons> listOfPersons, Predicate<Persons> predicate,
                                           Consumer<Persons> consumer) {
        for(Persons p: listOfPersons) {
            if(predicate.test(p))
                consumer.accept(p);
        }
    }

    private static void doPrint(List<Persons> listOfPersons) {
        for(Persons p: listOfPersons) {
            System.out.println(p);
        }
    }
}

/*interface Conditions{
    boolean testMe(Persons p);
}*/

/*class ComparatorList implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        return p1.getLastName().compareTo(p2.getLastName());
    }
}*/

class Persons{
    private String firstName;
    private String lastName;
    private int age;

    public Persons(){

    }

    public Persons(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
