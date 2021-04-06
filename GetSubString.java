package com.ishm.codingchallenge.hackerrank;

import java.util.*;

public class GetSubString {

    public static void main(String[] args) {
        String s = "awaglk";

        System.out.println(computeSubStrings(s,4));

    }
    private static List<String> computeSubStrings(String S, int k) {
        if(S == null || S.length() == 0) {
            return Collections.emptyList();
        }
        List<String> myList = new LinkedList<>();
        List<Integer> mylist1 = new ArrayList<>();
        Set<String> subString = new HashSet<String>();
        Map<Character, Integer> freq = new HashMap<>();
        int left =0;
        char c;
        for(int i =0; i < S.length(); i++) {
            c= S.charAt(i);
            freq.put(S.charAt(i), freq.getOrDefault(c, 0)+1);

            if(i - left == k-1) {
                // if number of keys is equal to k-1 that means we have k-1 distinct characters
                if(freq.keySet().size() == k-1) {
                    subString.add(S.substring(left, i+1));
                }
                if(freq.get(S.charAt(left)) == 1) {
                    freq.remove(S.charAt(left));
                } else {
                    freq.put(S.charAt(left), freq.get(S.charAt(left)) - 1);
                }
                left++;
            }
        }
        return new ArrayList<>(subString);
    }

}
