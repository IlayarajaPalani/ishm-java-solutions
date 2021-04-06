package com.ishm.codingchallenge.hackerrank;

import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int cycle = sc.nextInt();
            System.out.println(utopianTree(cycle));
        }
        sc.close();
    }

    private static int utopianTree(int cycle) {
       return(1<< ((cycle >> 1 ) + 1)) - 1 << cycle%2;
        //Generally speaking - i << k is equivalent to i*(2^k), while i >> k is equivalent to i/(2^k)./

    }

    private static int anotherUtopian(int cycle) { // Didnt work in the hacker rank
        int h = 1;
        for(int i = 1; i<cycle; i++){
            if(i%2!=0){
                h = h*2;
            }else{
                h++;
            }
        }
        return h;
    }


}
