package com.ishm.codingchallenge.leetcode;

public class CheckifSortedArray {
    public static void main(String[] args) {
        int [] arr={5,8,12,24,35,46,58,68,22,79,89};
        int n = arr.length;




        if(comp(arr,n)){
            System.out.println("Dual Loop Yes");
        }else{
            System.out.println("Dual loop No");
        }

        if(quickComp(arr)){
            System.out.println("quick Loop Yes");
        }else{
            System.out.println("quick loop No");
        }

    }

    public static boolean comp(int[] arr, int n){

        for(int m = 0;m<n;m++){
            for(int l=m+1;l<n;l++){
                if(arr[l]<arr[m]){
                    return false;
                }
            }

        }
        return true;

    }

    public static boolean quickComp(int[] arr){
        for(int p=1;p<arr.length;p++){
            if(arr[p]<arr[p-1]){
                return false;
            }
        }
        return true;
    }
}
