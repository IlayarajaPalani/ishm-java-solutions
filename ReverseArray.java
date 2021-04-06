package com.ishm.codingchallenge.leetcode;

public class ReverseArray {

    public static void main(String[] args) {
        int [] arr={5,8,12,24,35,46,58,68,22,79,89};
        int low = 0, high = arr.length-1;
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");

        }
    }
}
