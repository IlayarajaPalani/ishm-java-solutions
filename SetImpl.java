package com.ishm.codingchallenge.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class setImpl {

    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 100;
    private int size;
    private List<List<Integer>> parentList;


    /** Initialize your data structure here. */
    public setImpl() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i=0; i<ARRAY_SIZE; i++){
            parentList.add(null);
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int key) {
        int index = ARRAY_SIZE % key;
        List<Integer> childList = parentList.get(index);
        if(childList == null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.add(index,list);
        }else
        if(!childList.contains(key)){
            childList.add(key);
        }


    }

    public void remove(int key) {
        int index = ARRAY_SIZE % key;
        List<Integer> childList = parentList.get(index);
        if(childList != null){
            childList.remove(Integer.valueOf(key));
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = ARRAY_SIZE % key;
        List<Integer> childList = parentList.get(index);
        return childList!=null && childList.contains(key);
    }
}
