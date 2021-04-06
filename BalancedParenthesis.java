package com.ishm.codingchallenge.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesis {

    public static void main(String[] args) {

        String expr = "(({[[]])})";
        System.out.println(isBalance(expr));

    }

    private static boolean isBalance(String expr){
        Deque<Character> stack = new ArrayDeque<>();

        for(int i =0; i<expr.length(); i++){
            char x = expr.charAt(i);

            if(x=='(' || x == '{' || x == '['){
                stack.push(x);
            }
            //System.out.println(stack.getFirst());

            if(stack.isEmpty()) return false;

            switch (x){
                case')':
                    stack.pop();
                   // if(x== '}' || x == ']') return false;
                    break;
                case'}':
                    stack.pop();
                    //if(x == ')' || x == ']') return false;
                    break;
                case']':
                    stack.pop();
                    //if(x == ')' || x == '}') return false;
                    break;
            }
        }
        return stack.isEmpty();

    }
}
