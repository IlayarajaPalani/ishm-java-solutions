package com.ishm.codingchallenge.hackerrank;

public class Palindrome {

    public static void main(String[] args) {
        String s = "tacocat";
        //eXample - THE EYES & THEY SEE are anagrams
        // whereas palindrome work or phrase that reads the same backwords like MADAM/ NOON
        System.out.println(countPalindromes(s));
    }

    public static int countPalindromes(String s) {
        // Write your code here
        int n = s.length();
        int dp[][] = new int[n][n];
        boolean p[][] = new boolean[n][n];
        for(int i=0;i<n; i++)
            p[i][i] = true;

            for(int i = 0; i<n-1; i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    p[i][i+1] = true;
                    dp[i][i+1] = 1;
                }
            }
            for(int gap=2; gap<n; gap++)
            {
                for(int i=0; i<n-gap; i++)
                {
                    int j = gap + i;
                    if(s.charAt(i) == s.charAt(j) && p[i+1][j-1])
                        p[i][j] = true;
                    if(p[i][j] == true)
                        dp[i][j] = dp[i][j-1]+dp[i+1][j] + 1 -dp[i+1][j-1];
                    else
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                }
            }


        return dp[0][n-1];

    }
}
