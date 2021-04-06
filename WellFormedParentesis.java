package com.ishm.codingchallenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WellFormedParentesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    private static List<String> generateParenthesis(int n){
        List<String> output_arr = new ArrayList<>();
        backtrack(output_arr,"",0,0,n);
        return output_arr;
    }

    private static void backtrack(List<String> output_arr, String s, int open, int close, int n) {
        if(s.length() == n*2){
            output_arr.add(s);
            return;
        }

        if(open<n) backtrack(output_arr,s+"(",open+1,close,n);
        if(close<open) backtrack(output_arr,s+")",open,close+1,n);
    }

}
