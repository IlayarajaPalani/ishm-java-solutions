package com.ishm.codingchallenge.leetcode;

import java.util.*;

public class LargestItemAssociation {

    public static void main(String[] args) {

        List<PairString> pairs = Arrays.asList( //
                new PairString("item1", "item2"), // -> item1, item3, item2
                new PairString("item3", "item4"), //
                new PairString("item2", "item5") //
        );


        System.out.println(largestItemAssociation(pairs));
       // List<String> myList = largestItemAssociation(pairs);

    }

    private static List<String> largestItemAssociation(List<PairString> pairs) {
        if (pairs.isEmpty()) return null;

            Map<String, Set<String>> map = new HashMap<>();
            for (PairString pair : pairs) {
                Set<String> set = map.getOrDefault(pair.first, new TreeSet<>());
                set.add(pair.first);
                set.add(pair.second);
                set.addAll(map.getOrDefault(pair.second, new TreeSet<>()));
                map.put(pair.first, set);
                map.put(pair.second, set);
            }
            Set<String> checked = new HashSet<>();
            PriorityQueue<List<String>> pq = new PriorityQueue<>((l1, l2)
                    -> (l1.size() != l2.size() ? l2.size() - l1.size() : l1.get(0).compareTo(l2.get(0))));
            for (String item : map.keySet()) {
                if (checked.contains(item)) {
                    continue;
                }
                pq.add(new ArrayList<>(map.get(item)));
                checked.addAll(map.get(item));

            }
            //System.out.println(pq.peek());
            return pq.remove();

    }
}
class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return first + " ," + second;
    }
}
