package com.ishm.codingchallenge.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieGraph {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        System.out.println(minDays(grid));

    }

    private static int minDays(int[][] grid) {

        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;

        int target = h * w;
        int cnt = 0, res = 0;
        Queue<int[]> zomq = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1) {
                    zomq.offer(new int[]{i, j});
                    cnt++;
                }

            }
        }


        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!zomq.isEmpty()) {
            int size = zomq.size();
            if(cnt == target) return res;

            for(int i=0;i<size;i++) {
                int[] currIndex = zomq.poll();
                for (int[] dir : dirs) {

                    int x = currIndex[0] + dir[0];
                    int y = currIndex[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        zomq.offer(new int[]{x, y});
                        cnt++;
                    }

                }
            }

            res++;
        }
        return res;

    }
}
