package com.ishm.codingchallenge.hackerrank;

public class JumpingCloud {
    public static void main(String[] args) {
        int[] a = new int[]{0,0,1,0,0,0,0,1,0,0};
        //int[] a = new int[]{0,0,1,0,0,1,0};
        //int ans = minJumps(10,a);
        int ans = minJump2(a);
        System.out.println(ans);

    }

    public static int minJumps(int n, int[] a){
        int tmp =0;
        int jmp = 0;
        for(int i = 0; i<n; i++){
            if(tmp<n-2) {
                if (a[tmp + 2] == 0) {
                    tmp = tmp + 2;
                    jmp++;
                } else {
                    tmp = tmp + 1;
                    jmp++;
                }
            }
          }
        if((n%2==0) && a[tmp+1] == 0){
            jmp = jmp+1;
        }
        return jmp;
    }
    public static int minJump2(int[] a){
        int len = a.length;
        int jmp = -1;
        for(int i=0;i<len; i++, jmp++) {
            if (i + 2 < len && a[i + 2] == 0) {
                i++;
                }
            }
        return jmp;
        }
}
