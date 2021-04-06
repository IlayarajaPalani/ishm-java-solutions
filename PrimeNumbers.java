package com.ishm.codingchallenge.hackerrank;

public class PrimeNumbers {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        findPrime(arr);
    }

    public static void findPrime(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean isPrime = true;
            if (array[i] == 1)
                isPrime = false;
            else {
                // check to see if the numbers are prime
                for (int j = 2; j <= array[i] / 2; j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            // print the number
            if (isPrime)
                System.out.println(array[i] + " is a prime number in the array ");
        }
    }
}
