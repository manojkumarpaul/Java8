package com.java.java8.features.lamdaAgain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class P4_MethodReferences {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Aaron", "Tisya");
        //Consumer<String> consumer = s -> System.out.println(s);

        nameList.forEach(s -> System.out.println(s)); //lamda
        nameList.forEach(System.out::println); //method reference

        letsUseBoundMethodReference();
        letsUseUnBoundMethodReference();
        letsUseUnBoundStaticMethodReference();
        letsUseMethodReferenceContext();
    }

    private static void letsUseMethodReferenceContext() {

        Supplier<String> supplierLamda = () -> Person.howMany();
        Supplier<String> supplierMR = Person::howMany;
        System.out.println(supplierLamda.get());
        System.out.println(supplierMR.get());

        Function<Person, String> functionLamda = person -> Person.howMany();
        Function<Person, String> functionMR = Person::howMany;
        System.out.println(functionLamda.apply(new Person()));
        System.out.println(functionMR.apply(new Person()));

        BiFunction<Person, Person, String> biFunctionLamda = (p1,p2) -> Person.howMany();
        BiFunction<Person, Person, String> biFunctionMR = Person::howMany;
        System.out.println(biFunctionLamda.apply(new Person(), new Person()));
        System.out.println(biFunctionMR.apply(new Person(), new Person()));
    }

    private static void letsUseUnBoundStaticMethodReference() {
        Consumer<List<Integer>> listConsumer_L = list -> Collections.sort(list); //Collections.sort(list) is static
        Consumer<List<Integer>> listConsumer_MR = Collections::sort;

        List<Integer> integerList = Arrays.asList(5,5,6,3,7,2,9);

        listConsumer_L.accept(integerList);
        System.out.println(integerList);

        integerList = Arrays.asList(8,5,6,3,7,2,9);
        listConsumer_MR.accept(integerList);
        System.out.println(integerList);
    }

    private static void letsUseUnBoundMethodReference() {
        String name = "Payal Paul";
        Function<String, String> stringFunction_L = s -> s.toUpperCase(); //lamda
        Function<String, String> stringFunction_MR = String::toUpperCase; //MR

        System.out.println(stringFunction_L.apply(name));
        System.out.println(stringFunction_MR.apply(name));

        BiFunction<String, String, String> stringBiFunction_L = (s, t) -> s.concat(t);
        BiFunction<String, String, String> stringBiFunction_MR = String::concat; //"Payal ".concat("Paul")

        System.out.println(stringBiFunction_L.apply("Payal ", "Paul"));
        System.out.println(stringBiFunction_MR.apply("Payal ", "Paul"));

    }

    private static void letsUseBoundMethodReference() {
        String name = "Mr. Manoj Kumar Paul";
        Supplier<String> supplier = () -> name.toUpperCase(); //lamda
        Supplier<String> sup = name::toUpperCase; //method reference
        System.out.println(supplier.get());
        System.out.println(sup.get());

        Predicate<String> booleanPredicate = title -> name.startsWith(title); //lamda
        Predicate<String> booleanPredicatee = name::startsWith; //method reference
        System.out.println(booleanPredicate.test("Mr."));
        System.out.println(booleanPredicatee.test("Ms."));
    }
}

class Person{
    public static String howMany(Person... person){
        return person.toString();
    }
}
