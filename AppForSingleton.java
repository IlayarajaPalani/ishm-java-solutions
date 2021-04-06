package com.ishm.codingchallenge.collections;

import java.time.LocalDateTime;

public class AppForSingleton {

    private static AppForSingleton appForSingleton;
    public String s;
    private AppForSingleton(){
        // private cotnructor To stop classes from creating multiple objects
        s = "Hello i am from Singleton Class";
    }

    public static AppForSingleton getInstance(){
        if(appForSingleton == null){
            appForSingleton = new AppForSingleton();
        }
        return appForSingleton;
    }

    public void printText(int i){
        System.out.println("Printing Text" + i);
    }
}




