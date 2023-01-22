package com.java.java8.features.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P4_Java7WayOfSortingList {
    public static void main(String[] args) {
        List<Person> listOfPersons = Arrays.asList(
                new Person("AAAAA","ZZZZZZ",25),
                new Person("BBBBB","YYYYYY",32),
                new Person("CCCCC","XXXXXX",21),
                new Person("DDDDD","WWWWWW",39)
        );

        //sort the list
        //ComparatorList listComparator = new ComparatorList();
        Collections.sort(listOfPersons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        //print the list
        System.out.println("Printing all persons");
        doPrint(listOfPersons);
        //create a method that prints those lastname begining with X
        System.out.println("Printing all persons with lastname X");

        printConditionally(listOfPersons, new Condition() {
            @Override
            public boolean testMe(Person p) {
                return p.getLastName().startsWith("X");
            }
        });

        //create a method that prints those Firstname begining with B
        System.out.println("Printing all persons firstname B");

        printConditionally(listOfPersons, new Condition() {
            @Override
            public boolean testMe(Person p) {
                return p.getFirstName().startsWith("B");
            }
        });
    }

    private static void printConditionally(List<Person> listOfPersons, Condition condition) {
        for(Person p: listOfPersons) {
            if(condition.testMe(p))
                System.out.println(p);
        }
    }

    private static void doPrint(List<Person> listOfPersons) {
        for(Person p: listOfPersons) {
            System.out.println(p);
        }
    }
}

interface Condition{
    boolean testMe(Person p);
}

/*class ComparatorList implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        return p1.getLastName().compareTo(p2.getLastName());
    }
}*/

class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(){

    }

    public Person(String firstName, String lastName, int age) {
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
