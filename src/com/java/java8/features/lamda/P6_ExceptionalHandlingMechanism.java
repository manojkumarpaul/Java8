package com.java.java8.features.lamda;

import java.util.function.BiConsumer;

public class P6_ExceptionalHandlingMechanism {
    public static void main(String[] args) {
        int [] values = {1,2,3,4};
        int key = 0;

        process(values, key, handleException((v, k) -> System.out.println(v / k)));
    }

    private static BiConsumer<Integer, Integer> handleException(BiConsumer<Integer, Integer> biConsumer){
        return (v, k) -> {
            try {
                biConsumer.accept(v,k);
            } catch (Exception e) {
                System.out.println("Exception Occurred");
            }
        };
    }
    private static void process(int[] values, int key, BiConsumer<Integer, Integer> biConsumer) {
        for(int v:values)
            biConsumer.accept(v,key);
    }

}
