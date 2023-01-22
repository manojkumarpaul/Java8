package com.java.java8.features.lamda;

@FunctionalInterface
interface StringLength{
    int getLength(String string);
}

public class P2_LengthOfString {
    public static void main(String[] args) {
        //one-way
        /*StringLength stringLength = s -> s.length();
        int i = stringLength.getLength("Oh My God");
        System.out.println(i);*/

        //another-way
        doPrintLength(s -> s.length());
    }

    private static void doPrintLength(StringLength stringLength) {
        System.out.println(stringLength.getLength("Oh My God"));
    }
}
