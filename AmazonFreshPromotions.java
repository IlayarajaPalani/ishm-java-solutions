package com.ishm.codingchallenge.leetcode;

import java.util.Set;

public class AmazonFreshPromotions {

    public static void main(String[] args) {
        String[][] codelist = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingcart = {"apple", "apple", "banana","orange", "banana"};
        //System.out.println("2d array length: "+codelist.length);

        //System.out.println("first list length: "+codelist[1].length);

        //System.out.println(codelist[1][0]);


        System.out.println("Customer is Winner : "+assessPromotion(codelist,shoppingcart));
    }

    private static int assessPromotion(String[][] codeList, String[] shoppingCart) {
        if(codeList.length == 0 || codeList == null) return 1;
        if(shoppingCart.length ==0 || shoppingCart == null) return 0;

        int i=0,j=0;
        while(i < codeList.length && j+codeList[i].length <= shoppingCart.length){
            boolean match = true;

            for(int k=0; k<codeList[i].length; k++) {
                if (!codeList[i][k].equals("anything") && !shoppingCart[j+k].equals(codeList[i][k])) {
                    match = false;
                    break;
                }

            }
            if(match){
                j+=codeList[i].length;
                i++;
            }else{
                j++;
            }


        }

        return (i == codeList.length) ? 1 : 0 ;

    }

}
