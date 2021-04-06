package com.ishm.codingchallenge.hackerrank;

public class RepeatedCharCount {

    //https://www.geeksforgeeks.org/count-occurrences-of-a-character-in-a-repeated-string/
   /* Given an integer N and a lowercase string. The string is repeated infinitely.
    The task is to find the No. of occurrences of a given character x in first N letters.
            Input : N = 10 str = "abcac"
    Output : 4
    Explanation: "abcacabcac" is the substring from the infinitely repeated string. In first 10 letters 'a' occurs 4  times.

            Input: N = 10, str = "aba"
    Output : 7*/

    public static void main(String[] args) {
        long aCount = repeatedCharCount("aba",10l);
        System.out.println("a count "+ aCount);
    }

    static long repeatedCharCount(String s,Long n){
        int strLength = s.length();
        long q=0, r=0;
        q = n / strLength;
        r = n % strLength;
        System.out.println(r);
        long partialStrLength = (r == 0) ? 0 : r;

        long aCount = q * getCharCount(s, strLength)+ getCharCount(s, partialStrLength);

        return aCount;
    }

    public static long getCharCount(String s, long strLength){
        int count = 0;

        for(int i =0; i<strLength; i++){
            if(s.charAt(i) == 'a'){
                count ++;
            }
        }
        return count;
    }
}
