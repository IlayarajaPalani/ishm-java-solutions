package com.ishm.codingchallenge.collections;

public class AccessSingleton {
    public static void main(String[] args) {
        AppForSingleton app1 = AppForSingleton.getInstance();
        AppForSingleton app2 = AppForSingleton.getInstance();
        app1.s = (app1.s).toUpperCase();

        System.out.println(app1.s);
        System.out.println(app2.s);

        app2.s = app2.s.toLowerCase();
        System.out.println(app1.s);
        System.out.println(app2.s);


    }


}
