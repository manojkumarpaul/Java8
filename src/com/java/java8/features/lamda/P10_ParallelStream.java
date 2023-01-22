package com.java.java8.features.lamda;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class P10_ParallelStream {
    public static void main(String[] args) {
        int arrayOfIntegers [] = {1,2,3,4,5,6,7,8,9};
        IntStream intStream = Arrays.stream(arrayOfIntegers);
        System.out.println("Sequential Stream");
        intStream.forEach(i -> System.out.println(i + " "+ Thread.currentThread().getName()));

        System.out.println("Parallel Stream");
        intStream = Arrays.stream(arrayOfIntegers).parallel();
        intStream.forEach(i -> System.out.println(i + " "+ Thread.currentThread().getName()));

        System.out.println("Available processors::" + Runtime.getRuntime().availableProcessors());
        System.out.println("ForkJoin Pool Size:: "+ ForkJoinPool.commonPool().getPoolSize());
        System.out.println("Allowed for parallel processing:: "+ ForkJoinPool.commonPool().getParallelism());
    }
}
