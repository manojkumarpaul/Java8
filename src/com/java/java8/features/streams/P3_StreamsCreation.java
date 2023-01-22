package com.java.java8.features.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class P3_StreamsCreation {
    public static void main(String[] args) {
        createFromArray();
        createFromCollection();
        createFromStreamOf();
        createFromFile();
        createInfiniteStream();
        createFiniteStream();
    }

    private static void createFiniteStream() {
        Stream.iterate(2, n -> n+2)
                .limit(5)
                .forEach(System.out::println);
        //Finite loop printing numbers from 2,4,6,8,10
    }

    private static void createInfiniteStream() {
        Stream<Integer> infiniteStream = Stream.generate( () -> {
            return (int) (Math.random() * 10);
        });

        infiniteStream.forEach(System.out::println);
        //Infinite loop printing numbers single digit

        infiniteStream = Stream.iterate(2, n -> n+2);
        infiniteStream.forEach(System.out::println);
        //Infinite loop printing numbers from 2,4,6,8....etc
    }

    private static void createFromFile() {
        List<Cat> cats = loadCats("Cats.txt");
        cats.forEach(System.out::println);
    }

    private static List<Cat> loadCats(String fileName) {
        List<Cat> catList = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(line -> {
                String[] catsArray = line.split("/");
                catList.add(new Cat(catsArray[0], catsArray[1]));
            });
        }catch (IOException e){
            e.printStackTrace();
        }
        return catList;
        //Cat{name= POPO, color= Orange}
        //Cat{name= LOLO, color= Red}
    }

    private static void createFromStreamOf() {
        Stream<Integer> integerStream = Stream.of(1,2,3);
        System.out.println("No. of entries in Integer Stream is: ");

        Stream<P2_StreamsLaziness> p2_streamsLazinessStream = Stream.of(new P2_StreamsLaziness(), new P2_StreamsLaziness());
        System.out.println("No. of entries in UserObjects Stream is: "+p2_streamsLazinessStream.count());
        //No. of entries in UserObjects Stream is: 2
    }

    private static void createFromCollection() {
        List<String> stringList = Arrays.asList("AAAA","BBBB","CCCC");
        Stream<String> stringStream = stringList.stream();
        System.out.println("No. of elements in the List Stream is: "+stringStream.count());

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Tisya Paul", 4);
        stringIntegerMap.put("Aaron Paul", 10);

        //Map is not a collection, and need to convert to collection before streaming.
        System.out.println("No. of entries in Map Stream is: "+
                stringIntegerMap
                        .entrySet()
                        .stream()
                        .count());

        //No. of elements in the List Stream is: 3
        //No. of entries in Map Stream is: 2
    }

    private static void createFromArray() {
        Double[] doublesNumbers = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
        Stream<Double> doubleStream = Arrays.stream(doublesNumbers);
        System.out.println("No. of elements in Double Stream is "+doubleStream.count());
        //No. of elements in Double Stream is 9
    }
}

class Cat{
    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    private String name, color;
    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{name= "+this.name+", color= "+this.color+"}";
    }
}