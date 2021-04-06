package com.ishm.codingchallenge.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlmostSorted2 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,5,10));
        System.out.println(minDeletions(arr));
    }

    public static int minDeletions(List<Integer> arr) {
        // Write your code here

        int n = arr.size();
        int res = 0;
        int[] lst = new int[n];
        for(int i = 0; i<n; i++){
            lst[i] = 1;
            //System.out.println(Arrays.toString(lst));
        }

        for(int i=1; i<n; i++)
            for(int j =0; j<i; j++)
                if(arr.get(i) > arr.get(j) && lst[i] < lst[j] + 1)
                    lst[i] = lst[j] + 1;

        for(int i=0; i <n; i++){
            if(res < lst[i])
                res = lst[i];

        }

        if(res==n){
            return 0;
        }else{
            return n-res-1;
        }


    }
}
