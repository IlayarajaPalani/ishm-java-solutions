package com.ishm.codingchallenge.hackerrank;


public class ArrayLeftRotation {

    public static void main(String[] args) {
     int[] arr = {1,2,3,4,5};
     int[] arr1 = rotLeft(arr,4);
     for(int i=0;i<arr.length;i++) {
         System.out.print(arr1[i]+" ");
     }

    }
    static int[] rotLeft(int[] a, int d) {

        //Queue<Integer> myq = new LinkedList<>();

        int n = a.length;
        int[] rotated = new int[n];
        System.arraycopy(a,d,rotated,0,n-d);
        //System.arraycopy(a,d,rotated,0,n-d);
        System.arraycopy(a, 0, rotated, n - d, d);

        return rotated;
    }
}
