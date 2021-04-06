package com.ishm.codingchallenge.collections;

public class Recursion {

    public static void main(String[] args) {
        String s = "Geeks";
        printReverse(s);
    }
    private static void printReverse(String str) {
        helper(0, str);
    }
    private static void helper(int index, String str) {
        if (str == null || index >= str.length()) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str.charAt(index));
    }
}


