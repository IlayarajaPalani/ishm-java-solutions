package com.ishm.codingchallenge.hackerrank;

import java.util.Arrays;

public class anagram {

    public static int NUMBER_LETTERS = 26;
    static int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        //int[] charCt = getCharCount("Hello");
// Time Complexity O(nLogn)
        char str1[] = { 't', 'e', 's', 't' };//eXample - THE EYES & THEY SEE are anagrams
        // whereas palindrome work or phrase that reads the same backwords like MADAM/ NOON
        char str2[] = { 't', 't', 'e', 'w' };

        // Function Call
        if (areAnagram2(str1, str2))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
    }

    public static int[] getCharCount(String s){
        int[] charCounts = new int[NUMBER_LETTERS];
        int offset = (int) 'a';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int code = c - offset;
            System.out.println(code);
            charCounts[code]++;
        }
        return charCounts;

    }

    static boolean areAnagram(char[] str1, char[] str2)
    {
        // Get lenghts of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    static boolean areAnagram2(char str1[], char str2[])
    {

        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;

        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }

}
