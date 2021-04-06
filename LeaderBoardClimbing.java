package com.ishm.codingchallenge.hackerrank;

import java.util.*;

public class LeaderBoardClimbing {

    public static void main(String[] args) {

        List<Integer> ranked = new ArrayList<>(Arrays.asList(100,90,90,80,75,60));
        List<Integer> player = new ArrayList<>(Arrays.asList(50,65,77,90,102));
        System.out.println(climbingLeaderboard(ranked,player));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int n = ranked.size();
        System.out.println(n);
        System.out.println(ranked.get(n-1));
        int m = player.size();
        int[] rank = new int[n];
        List<Integer> res = new ArrayList<>();
        rank[0] = 1;
        for(int i = 1; i<n; i++){
            if(ranked.get(i) == ranked.get(i - 1)){
                rank[i] = rank[i-1];
            }else{
                rank[i] = rank[i-1]+1;
            }

        }
        System.out.println("rank "+ Arrays.toString(rank));


        for(int i=0;i<m;i++){
            int playerScore = player.get(i);
            if(playerScore > ranked.get(0)) {
                res.add(i,1);
            }else if(playerScore < ranked.get(n-1)){
                System.out.println(rank[n-1]+1);
                res.add(i,rank[n-1]+1);
            } else {
                int index = binarySearch(ranked,playerScore);
                res.add(i, rank[index]);
            }


        }
        return res;
    }

    static int binarySearch(List<Integer> a, int playerScore){

        int lo = 0;
        int hi = a.size()-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(a.get(mid) == playerScore){
            }else if(a.get(mid) > playerScore && playerScore >= a.get(mid+1)){
                return mid+1;
            }else if(a.get(mid) < playerScore){
                hi = mid - 1;
            }else if(a.get(mid) > playerScore){
                lo = mid + 1;
            }
        }

        return -1;
    }
}
