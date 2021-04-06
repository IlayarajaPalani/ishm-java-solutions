package com.ishm.codingchallenge.leetcode;

import java.util.Random;
public class Minesweeper {
    int _row=5,_col=5,_countGameOver=0;
    int [][] _board=new int[_row][_col];
    boolean [][] _flagMatrix=new boolean[_row][_col];
    public void plotBoard(){
        int noOfBomb=_col;
        while(noOfBomb>0) {
            int i=getRandomNumber();
            int j=getRandomNumber();
            if (_board[i][j]!=-1) {
                _board[i][j]=-1;
                noOfBomb--;
            }
        }
    }
    public int getRandomNumber(){
        Random t = new Random();
        // random integers in [0, 100]
        int num;
        {
            num=t.nextInt(_col);
        }while(num>_col);
        return num;
    }
    boolean isValid(int i,int j){
        return((i>=0 && i<_row)&&(j>=0 && j<_col));
    }
    int getAdjBomb(int i,int j){
        int num=0;
        //System.out.println("i="+i+"j="+j);
        for (int k = i-1; k <=(i+1); k++) {
            for (int l= j-1; l<=(j+1); l++) {
                if (isValid(k,l)&&(_board[k][l]==-1)) {
                    num++;
                }
            }
        }
        return num;
    }
    public void calculateCounts(){
        for (int i = 0; i <_row; i++) {
            for (int j = 0; j <_col; j++) {
                if(_board[i][j]!=-1)
                    _board[i][j]=getAdjBomb(i,j);
            }
        }
    }
    public void print(){
        for (int i = 0; i <_row; i++) {
            for (int j = 0; j <_col; j++) {
                System.out.print(" "+_board[i][j]);
            }
            System.out.println("");
        }
    }
    public void displayFlagMatrix(){
        for (int i = 0; i <_row; i++) {
            for (int j = 0; j <_col; j++) {
                if (_flagMatrix[i][j]==true) {
                    System.out.print(" "+"*");
                }
                else{
                    System.out.print(" "+"+");
                }
            }
            System.out.println(" ");
        }
    }
    public boolean play(int r,int c){
        if (!(isValid(r,c))) {
            System.out.println("Please Enter row and col in correct range");
            return false;
        }
        if (_flagMatrix[r][c]==true) {
            System.out.println("This is a open position please enter other col and row");
            return false;
        }
        if (_board[r][c]==-1)
            return true;
        if (_board[r][c]!=0) {
            _countGameOver++;
            _flagMatrix[r][c]=true;
        }
        else{
            _flagMatrix[r][c]=true;
            _countGameOver++;
            openSpace(r, c);
        }
        return false;
    }
    void openSpace(int r,int c){
        for (int k = r-1; k <=(r+1); k++) {
            for (int l= c-1; l<=(c+1); l++) {
                if (isValid(k,l)&&(_board[k][l]!=-1)&&(_flagMatrix[k][l]==false)) {
                    _flagMatrix[k][l]=true;
                    _countGameOver++;
                    if (_board[k][l]==0) {
                        openSpace(k,l);
                    }
                }
            }
        }
    }
    public boolean checkGameOver(){
        return(_countGameOver==(_row*_row)-(_row));
    }
}
