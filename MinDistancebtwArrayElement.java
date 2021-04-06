package com.ishm.codingchallenge.hackerrank;

import java.util.HashMap;

public class MinDistancebtwArrayElement {

    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,1,7,8,9,1,2,0,1};

        int minD = getMinDistance(a);
        System.out.println(minD);

    }

    public static int getMinDistance(int[] a){
        HashMap<Integer,Integer> hmap = new HashMap<>(); //HashMap<arrayValue, indexinthearray>
        int minDistance = Integer.MAX_VALUE, prevIndex = 0, currIndex = 0;
        for(int i = 0;i< a.length;i++ ){
            if(hmap.containsKey(a[i])){
                currIndex = i;
                prevIndex = hmap.get(a[i]);
                minDistance = Math.min((currIndex-prevIndex), minDistance);
            }
            hmap.put(a[i],i);
        }

        return (minDistance == Integer.MAX_VALUE ? -1 : minDistance);
    }
}
