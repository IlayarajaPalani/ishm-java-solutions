package com.ishm.codingchallenge.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumElementintheArrayList {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4,3,2,3,5));
        System.out.println("MAx Value " + getMaxValue(arr));
    }

    public static int getMaxValue(List<Integer> arr) {

        if(arr.get(0)!= 1){
            arr.set(0,1);
        }
        int n = arr.size();
        for(int i=1;i<n; i++){
            if(arr.get(i)-arr.get(i-1) > 1){
                int setValue = arr.get(i-1) + 1;
                arr.set(i,setValue);
            }
        }

        return (arr.get(n-1));

    }
}
