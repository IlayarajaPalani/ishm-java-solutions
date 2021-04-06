package com.ishm.codingchallenge.collections;

import java.util.HashMap;

public class LoggingSingleton {

    private static LoggingSingleton loggingSingleton;
    public String s;
    private LoggingSingleton(){
        s = "Singleton Logging Instance";
    }

    public static LoggingSingleton getInstance(){
        if(loggingSingleton == null){
            loggingSingleton = new LoggingSingleton();
        }
        return loggingSingleton;
    }
}

class AccessLoggin {
    public static void main(String[] args) {
        LoggingSingleton lg1 = LoggingSingleton.getInstance();
        LoggingSingleton lg2 = LoggingSingleton.getInstance();
        lg1.s = lg1.s.toLowerCase();

        System.out.println(lg1.s);
        System.out.println(lg2.s);

        lg2.s = lg2.s.toUpperCase();
        System.out.println(lg1.s);
        System.out.println(lg2.s);
    }

}

