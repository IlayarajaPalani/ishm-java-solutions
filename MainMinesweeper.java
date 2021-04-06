package com.ishm.codingchallenge.leetcode;


import java.util.Scanner;
public class MainMinesweeper extends Minesweeper {
    public static void main(String[] args) {
        MainMinesweeper obj=new MainMinesweeper();
        obj.plotBoard();
        obj.calculateCounts();
        System.out.println("afate count");
        obj.print();
        int r,c;
        System.out.println("+++++++++++++++");
        obj.displayFlagMatrix();
        while(true){
            System.out.println("===============");
            Scanner input=new Scanner(System.in);
            System.out.println("enter row");
            r=input.nextInt();
            System.out.println("enter col");
            c=input.nextInt();
            if (obj.play(r,c)) {
                System.out.println("You Lose");
                break;
            }
            System.out.println("ok");
            if (obj.checkGameOver()) {
                obj.displayFlagMatrix();
                System.out.println("You Win Game");
                break;
            }
            obj.displayFlagMatrix();
            System.out.println("+++++++++++");
            obj.print();

        }
    }

}