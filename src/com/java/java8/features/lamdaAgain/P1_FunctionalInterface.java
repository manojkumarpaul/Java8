package com.java.java8.features.lamdaAgain;

/*
 * @FunctionalInterface can have only one method
 * */
@FunctionalInterface
interface FunctionalInterfaceSample {
    void method();
}
public class P1_FunctionalInterface {
    static FunctionalInterfaceSample fISInstance = new FunctionalInterfaceSample() {
        @Override
        public void method() {
            System.out.println("Hello! Before Java 8 - Static");
        }
    };

    public static void main(String[] args) {
        fISInstance.method();

        FunctionalInterfaceSample fIS = new FunctionalInterfaceSample() {
            @Override
            public void method() {
                System.out.println("Hello! Before Java 8");
            }
        };

        fIS.method();

        //Java 8 Lamda Expression
        FunctionalInterfaceSample lamda1 = () -> {
            System.out.println("Java 8 - Lamda expression sample 1");
        };

        //Java 8 Lamda Expression - for a one liner, we can remove curly braces
        FunctionalInterfaceSample lamda2 = () -> System.out.println("Java 8 - Lamda expression sample 2");

        lamda1.method();
        lamda2.method();
    }

}
