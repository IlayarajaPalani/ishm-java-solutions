package com.ishm.codingchallenge.leetcode;

import java.util.*;

public class TopKKeyWords {
    public static void main(String[] args) {

        int k = 2;
        List<String> keywords = new ArrayList<>(Arrays.asList("anacell", "cetracular", "betacellular"));
        List<String> reviews = new ArrayList<>(Arrays.asList("Anacell provides the best services in the city","betacellular has awesome services","Best services provided by anacell, everyone should use anacell"));

        System.out.println(getFrequent(k,keywords,reviews));

    }

    public static List<String> getFrequent(int k, List<String> keywordsList, List<String> words){
        Map<String,Integer> count= new HashMap<>();
        for(String word:words){
            for(String s:word.split("\\s+")){
                if(keywordsList.contains(s)){
                    count.put(s,count.getOrDefault(s,0)+1);
                }
            }
        }

        List<String> ls = new ArrayList<>(count.keySet());
        Collections.sort(ls, (a,b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));

        return ls.subList(0,k);
    }
}
