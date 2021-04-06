package com.ishm.codingchallenge.hackerrank;

public class ValleyCounting {
    public static void main(String[] args) {
            int countVally = countValley(8,"UDDDUDUU");
            System.out.println(countVally);
    }

    static int countValley(int n, String S){
        int valleyCtr = 0, alt = 0;
        for(int i=0;i<S.length(); i++){
            if(S.charAt(i) == 'U'){
                alt ++;
                if(alt == 0){
                    valleyCtr++;
                }
            }else{
                alt--;
            }
        }
        return valleyCtr;


    }
}
