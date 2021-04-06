package com.ishm.codingchallenge.leetcode;

import java.util.*;

public class FlighSeatResrvation {

    public static void main(String[] args) {
        System.out.println( maxNumberOfFamilies1(2, "1A 2F 1C"));
    }


    private static int maxNumberOfFamilies1(int N, String S) {
        int count = 0;
        String worstSce = "AJ";
        String firstCombination = "BCDE";
        String secondCombination = "FGHI";
        String thirdCombination = "DEFG";

        boolean firstComb = false;
        boolean secComb = false;
        boolean thirdComb = false;

        Map<Integer, List<String>> seatCountMap = new HashMap();

        if(!S.isEmpty()) {
            String[] seatNumSplit = S.split(" ");
            for(String seatNum : seatNumSplit) {
                Integer rowNum = Integer.parseInt(""+seatNum.charAt(0));//1,2,1
                    List<String> colList = seatCountMap.get(rowNum);
                if(colList != null){
                    colList.add(String.valueOf(seatNum.charAt(1)));
                    seatCountMap.put(rowNum, colList);
                }else {
                    colList = new ArrayList<String>();
                    colList.add(String.valueOf(seatNum.charAt(1)));
                    seatCountMap.put(rowNum, colList);//"1A 2F 1C"
                }
            }
        }

        if(seatCountMap.isEmpty()) { // SEATcOUNTmAP (1,A&C, 2,F)
            count = N*2;
        }else {
            for(int i=1; i<=N; i++) {
                firstComb = true;
                secComb = true;
                thirdComb = true;
                if(seatCountMap.get(i)==null || seatCountMap.get(i).isEmpty()) {
                    count +=2;
                }else {
                    for(String rowSeat : seatCountMap.get(i)) {
                        if(worstSce.contains(rowSeat)) {
                            continue;
                        }
                        if(firstComb && firstCombination.contains(rowSeat)) {
                            firstComb = false;
                        }else if(secComb && secondCombination.contains(rowSeat)) {
                            secComb = false;
                        } else if(thirdComb && thirdCombination.contains(rowSeat)){
                            thirdComb = false;
                        }
                    }
                    if(firstComb) {
                        count++;
                    }
                    if(secComb) {
                        count++;
                    }if(!firstComb && !secComb && thirdComb){
                        count++;
                    }
                }
            }
        }



        return count;
    }



























    private static int maxNumberOfFamilies(int n, String S) {

        if(S == null) return 2*n;
        String[] strArr = S.split(" ");

        int optimal_allocations = 0;
        HashMap<Integer, Set<Integer>> map =
                new HashMap<Integer, Set<Integer>>();

         for (int i = 0; i < strArr.length; i++) {
            int row = Integer.parseInt(String.valueOf(strArr[i].charAt(0)));
            int col =  Integer.parseInt(String.valueOf(strArr[i].charAt(1) - 'A')) + 1;
            if (map.containsKey(row)) {
                Set<Integer> set = map.get(row);
                set.add(col);
            }
            else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(col);
                map.put(row, set);
            }
        }

        for(Set<Integer> set : map.values()) {
            int pos1 = 1, pos2 = 1, pos3 = 1;
            for(Integer  seatNo : set) {
                if(seatNo == 2 || seatNo == 3)
                    pos1 = 0;
                if(seatNo == 4 || seatNo == 5) {
                    pos1 = 0;
                    pos2 = 0;
                }
                if(seatNo == 6 || seatNo == 7) {
                    pos2 = 0;
                    pos3 = 0;
                }
                if(seatNo == 8 || seatNo == 9)
                    pos3 = 0;
            }
            optimal_allocations += Math.max(pos1+pos3, pos2);
        }

        optimal_allocations += (n - map.size()) * 2;

        return optimal_allocations;
    }
}
