package com.ishm.codingchallenge.hackerrank;

public class StairCase {
    public static void main(String[] args) {
        stairCase(5);
    }

    static void stairCase(int n){
        String str = "#";
        for(int i=0; i < n; i ++){
            System.out.printf("%"+n+"s\n",str);/*
            what printf does is it formats the string here.
            ("%"+n+"s\n",str) this gives assume n = 5 then it will be (%5s\n,str)
            Which says 5 char with 4 spaces followed by string #. as we add the # below
            second iteration, str = ## and the space will be 3
            */
            str+= "#";
        }

    }
}
