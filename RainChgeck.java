package com.ishm.codingchallenge.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RainChgeck {

    public static void main(String[] args) {
    /*    List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(true);
        System.out.println(list.size());
        System.out.println(list.get(1));
        //System.out.println("Hello World".substring(6,12)+"Hello World".substring(12,6));

        for(int i =0; i<10; i=i++){
            i+=1;
            System.out.println("Hello World");
        }*/

        int count = 0;
        if(count < 3){
            count ++;
            main(null);
        }else{
            return;
        }
        System.out.println("Hello World");


    String[] array = {"ABC","0","10","2"};
            List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(list.toString());
    }

}
