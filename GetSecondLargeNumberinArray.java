package com.ishm.codingchallenge.hackerrank;

public class GetSecondLargeNumberinArray {
    public static void main(String[] args) {

        int[] arr1 = {24,23,24,26,12};
        System.out.println(secLargestNum(arr1));

    }

    static int getSecondLargeNumber(int[] arr1){
        int first, second;
        first = Integer.MAX_VALUE;
        second = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length ; i ++)
        {
            if (arr1[i] < first)
            {
                second = first;
                first = arr1[i];
            }

            else if (arr1[i] < second && arr1[i] != first)
                second = arr1[i];
        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second" +
                    "smallest element");

        else
            System.out.println("second Smallest" +
                    " element is " + second);
            return second;

    }

    public static int secLargestNum(int[] arr){

        int res = -1, largest = 0;//int[] arr1 = {24,23,24,26,12};
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[largest]){
                res=largest;
                largest=i;

            }else
            if(arr[i]!=arr[largest]){
                if(res==-1 || arr[i]>arr[res]){
                    res=i;
                }
            }
        }
        return arr[res];

    }
}
