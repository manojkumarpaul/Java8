package com.java.java8.features.lamda;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//The program is for limiting the forkjoinpool for parallel stream from using all processors and limiting to 4 only

public class P11_ForkJoinPoolForParallelStream {
    public static void main(String[] args) {
        final int numberOfThreads = 4;
        ForkJoinPool forkJoinPool;

        try {
            forkJoinPool = new ForkJoinPool(numberOfThreads);
            final List<Integer> primes = forkJoinPool.submit(() ->
                            IntStream.range(1,20).parallel()
                    .filter(PrimesPrint::isPrime)
                    .boxed().collect(Collectors.toList())
                    ).get();
            System.out.println(primes.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class PrimesPrint{
    public static boolean isPrime(int i) {
        System.out.println(Thread.currentThread().getName());
        if (i == 0 || i == 1) {
            //System.out.println(i + " is not prime number");
        } else {
            boolean flag = false;

            for (int start = 2; start <= i / 2; ++start) {
                // condition for nonprime number
                if (i % start == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                //System.out.println(i + " is a prime number.");
                return true;
            }
            //else
                //System.out.println(i + " is not a prime number.");
        }
        return false;
    }

}