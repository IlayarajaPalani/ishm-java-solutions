package com.ishm.codingchallenge.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWords {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"Hit"};

        System.out.println(mostCommonWord(paragraph, banned));

    }

    private static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banned_words = new HashSet<>();
        HashMap<String,Integer> valid_word_count = new HashMap<String, Integer>();

        String[] words = paragraph.toLowerCase().split("\\W+");

        for(String word : banned){
            banned_words.add(word);


        }

        for(String word : words) {
            if (!banned_words.contains(word)) {
                valid_word_count.put(word, valid_word_count.getOrDefault(word, 0) + 1);

            }

        }
        int max = 0;
        String result = "";
          for(String word : valid_word_count.keySet()){
              if(valid_word_count.get(word) > max){
                  max = valid_word_count.get(word);
                  result = word;
              }

          }
        return result;
    }
}
