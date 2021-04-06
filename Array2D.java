package com.ishm.codingchallenge.hackerrank;



public class Array2D {


    public static void main(String[] args){



        int[][] arr = {{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,9,2,-4,-4,0},{0,0,0,-2,0,0},{0,0,-1,-2,-4,0}};



        System.out.println(hourglassSum(arr));


    }

    private static int hourglassSum(int[][] arr) {

        int R = 4;
        int C = 4;
        if(R<4 || C<4) return -1;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<R;i++){
            for(int j=0; j<4;j++){
                int sum = arr[i][j] + arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]
                        +arr[i+2][j+1]+arr[i+2][j+2];

                max_sum = Math.max(max_sum,sum);
            }

        }


        return max_sum;
    }

}

