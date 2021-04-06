package com.ishm.codingchallenge.collections;

import java.util.*;
import java.util.concurrent.*;

public class ArrayListAnalysis {

    public static void main(String[] args) {
        List<String> loans = new ArrayList<>();
/*
        loans.add("personal loan");
        loans.add("home loan");
        loans.add("auto loan");
        loans.add("credit line loan");
        loans.add("mortgage loan");
        loans.add("gold loan");
        String m = "asdas";
        m.length();
        HashMap<Character, Integer> mymap = new HashMap<>();
        // printing ArrayList before removing any element
        System.out.println(loans);

        // removing element using ArrayList's remove method during iteration like loan.remove(i)
        // This will throw ConcurrentModificationException
        Iterator<String> itr = loans.iterator();
        while(itr.hasNext()){
            String loan = itr.next();
            if(loan == "auto loan"){
                itr.remove();
            }
        }




        System.out.println(loans);

*/
        List<String> giftCard = new ArrayList<>();
        giftCard.add("Waltmart");
        giftCard.add("Amazon");
        giftCard.add("Kohls");

       // for(int i = 0; i<=giftCard.size(); i++){

         //   giftCard.remove(i);

        //}
        int i = giftCard.size();

        Iterator<String> itr = giftCard.iterator();
        while(itr.hasNext()){
            itr.next();
            itr.remove();
        }


        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("Test","MY");
        ConcurrentHashMap<String, String> chMap = new ConcurrentHashMap<>();
        System.out.println(hmap.get("Test"));

        System.out.println("Items removed " + giftCard.size());

    }
}
