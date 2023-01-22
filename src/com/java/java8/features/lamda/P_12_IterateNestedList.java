package com.java.java8.features.lamda;

import java.util.Arrays;
import java.util.List;

public class P_12_IterateNestedList {
    public static void main(String[] args) {
        List<Cat> listOfCats = Arrays.asList(new Cat("SiberianCat"),
                                             new Cat("IndiaPussyCat")
        );
        List<Bear> listOfBears = Arrays.asList(new Bear(listOfCats));
        List<Animal> listOfAnimals = Arrays.asList(new Animal("Land", listOfBears));

        beforeJava8(listOfAnimals);
        usingJava8(listOfAnimals);
    }

    private static void usingJava8(List<Animal> listOfAnimals) {
        String name = "SiberianCat";
        Cat cat = listOfAnimals.stream()
                .flatMap(a -> a.getListOfBears().stream())
                .flatMap(b -> b.getListOfCats().stream())
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
        System.out.println("Got the cat After Using Java 8: "+cat.getName());
    }

    private static void beforeJava8(List<Animal> listOfAnimals) {
        Cat c1 = null;
        String name = "SiberianCat";
        for (Animal a: listOfAnimals) {
            for (Bear b: a.getListOfBears()) {
                for (Cat c: b.getListOfCats()) {
                    if (c.getName().equalsIgnoreCase(name)) {
                        c1= c;
                        System.out.println("Got the cat Before Using Java 8: "+c.getName());
                        break;
                    }
                }
            }
        }
    }
}

class Cat{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Animal{
    private String animalType;
    private List<Bear> listOfBears;

    public Animal(String animalType, List<Bear> listOfBears) {
        this.animalType = animalType;
        this.listOfBears = listOfBears;
    }

    public List<Bear> getListOfBears() {
        return listOfBears;
    }

    public void setListOfBears(List<Bear> listOfBears) {
        this.listOfBears = listOfBears;
    }
}

class Bear{
    private List<Cat> listOfCats;

    public Bear(List<Cat> listOfCats) {
        this.listOfCats = listOfCats;
    }

    public List<Cat> getListOfCats() {
        return listOfCats;
    }

    public void setListOfCats(List<Cat> listOfCats) {
        this.listOfCats = listOfCats;
    }
}