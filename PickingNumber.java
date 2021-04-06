package com.ishm.codingchallenge.hackerrank;

import java.util.Arrays;
import java.util.List;

public class PickingNumber {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(9, 6, 13, 16, 5, 18, 4, 10, 3, 19, 4, 5, 8, 1, 13, 10, 20, 17, 15, 10, 6);
        //10,13,20,18,17,7,10,6,5,16,18,13,20,19,7,16,13,20,17,4,17,8,19,12,7,17,1,18,3,16,4,5,3,15,17,6,17,14,11,11,7,11,6,15,15,12,6,17,19,8,6,13,9,10,19,14,18,7,9,11,16,11,20,4,20,10,7,8,4,2,12,11,8,12,13,19,8,8,5);
        System.out.println(pickingNumber(a));
    }

    public static int pickingNumber(List<Integer> a) {
        int[] subArray = new int[101]; // note in the problem statement length is max of 100.
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            int index = a.get(i);
            subArray[index]++;
        }

        for (int i = 1; i <= 100; i++) {
            result = Math.max(result, subArray[i] + subArray[i-1]);
        }
        return result;
    }

}

