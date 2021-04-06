package com.ishm.codingchallenge.leetcode;

public class RemoveDuplicatesinArray {

    public static void main(String[] args) {
        int [] arr={5,8,12,24,12};
        removeDuplicate(arr);
    }

    private static void removeDuplicate(int[] arr) {


        int n = arr.length;
        int res = 1;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[res-1]){
                arr[res]=arr[i];
                res++;
            }
        }
        }
    }

