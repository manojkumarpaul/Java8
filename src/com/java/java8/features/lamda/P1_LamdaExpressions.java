package com.java.java8.features.lamda;

@FunctionalInterface
interface GreetingI{
    void greet();
}

/*class Greet implements GreetingI{

    @Override
    public void greet() {
        System.out.println("Hello People");
    }
}*/
public class P1_LamdaExpressions {
    public void greet(GreetingI greetingI){
        greetingI.greet();
    }
    public static void main(String[] args) {
        //without using Lamda expressions (Object Oriented Programming)
        /*GreetingI greetingI = new Greet();
        greetingI.greet();*/

        //Using anonymous class (Object Oriented Programming)
        GreetingI greetingAnonymous = new GreetingI() {
            @Override
            public void greet() {
                System.out.println("Hello People from anonymous class");
            }
        };

        //Using Lamda expressions (Functional programming)
        GreetingI greetingLamda =   () -> System.out.println("Hello People from Lamda");

        P1_LamdaExpressions p1_lamdaExpressions = new P1_LamdaExpressions();
        p1_lamdaExpressions.greet(greetingAnonymous);
        p1_lamdaExpressions.greet(greetingLamda);
    }
}
