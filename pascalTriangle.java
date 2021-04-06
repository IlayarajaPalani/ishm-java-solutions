package com.ishm.codingchallenge.hackerrank;

public class pascalTriangle {
    // Function to print first
    // n lines of Pascal's Triangle
    static void printPascal(int n)
    {

        // Iterate through every line
        // and print entries in it
        for (int line = 0; line < n; line++)
        {
            // Every line has number of
            // integers equal to line number
            for (int i = 0; i <= line; i++)
                System.out.print(binomialCoeff
                        (line, i)+" ");

            System.out.println();
        }
    }

    // Link for details of this function
    // https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
    static int binomialCoeff(int n, int k) // formulae n!/k!(n-k)! -> 4! = 4*3*2*1 = 24
    {
        int res = 1;

        if (k > n - k)
            k = n - k;

        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // Driver code
    public static void main(String args[])
    {
        int n = 7;
        printPascal(n);
        printPascalBestCase(n);
    }

    public static void printPascalBestCase(int n)
    {
// An auxiliary array to store generated pascal triangle values
        int[][] arr = new int[n][n];

// Iterate through every line and print integer(s) in it
        for (int line = 0; line < n; line++)
        {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++)
            {
                // First and last values in every row are 1
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else // Other values are sum of values just above and left of above
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
                System.out.print(arr[line][i]+" ");
            }
            System.out.println("");
        }
    }
}
