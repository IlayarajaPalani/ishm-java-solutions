package com.ishm.codingchallenge.leetcode;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        System.out.println(numIslands(grid));

    }

    private static int numIslands(int[][] grid) {

        int h = grid.length;
        if(h == 0)
            return 0;
        int w = grid[0].length;
        int cnt = 0;
        for(int i =0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j] == 1){
                    bfs(grid,i,j,h,w);
                    cnt++;
                }

            }
        }

        return cnt;
    }

    private static void bfs(int[][] grid, int x, int y, int h, int w) {
        if(x<0 || x>= h || y < 0 || y >= w || grid[x][y]!=0)
            return;
        grid[x][y] = 2;

        bfs(grid,x+1,y,h,w);
        bfs(grid,x,y+1,h,w);
        bfs(grid,x-1,y,h,w);
        bfs(grid,x, y-1,h,w);
    }
}
