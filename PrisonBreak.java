package com.ishm.codingchallenge.collections;

import java.util.Arrays;
import java.util.List;

public class PrisonBreak {

    public static void main(String[] args) {

        //
        System.out.println(getMaxPrisonHole(3,2, Arrays.asList(1,2,3), Arrays.asList(1,2)));
    }

    private static int getMaxPrisonHole(int n, int m, List<Integer> xList, List<Integer> yList) {
        boolean[] xBol = new boolean[n+1];
        Arrays.fill(xBol,true);
        boolean[] yBol = new boolean[m+1];
        Arrays.fill(yBol,true);


        for(int x:xList){
            xBol[x]=false;
        }


        for(int y:yList){
            yBol[y]=false;
        }


        int cx =0, xMax = Integer.MIN_VALUE, cy=0, yMax=Integer.MIN_VALUE;

        for(int i=0;i<xBol.length;i++) {
            if(xBol[i]){
                cx=0;
            } else {
                cx++;
                xMax=Math.max(cx,xMax);
            }
        }


        for(int i=0;i<yBol.length;i++) {
            if(yBol[i]){
                cy=0;
            } else {
                cy++;
                yMax=Math.max(cy,yMax);
            }
        }

        return (xMax+1) * (yMax+1);
    }
}
