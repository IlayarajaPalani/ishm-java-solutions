package com.ishm.codingchallenge.hackerrank;

public class SaveThePrisoner {
    public static void main(String[] args) {
        System.out.println(savePrisoner(5,20,2));
    }

    static int savePrisoner(int n, int m, int s){
        int r = m % n;
        if((r+s-1)%n == 0){
            return n;
        }else {
            return ((r + s - 1) % n);
        }
    }
}
