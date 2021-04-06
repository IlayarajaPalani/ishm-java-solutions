package com.ishm.codingchallenge.hackerrank;

public class FizzBuzz {


    public static void main(String[] args) {
        fizzBuzz(16);
    }

    public static void fizzBuzz(int n) {

        for (int i = 1; i < n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}

