package com.ishm.codingchallenge.leetcode;

import java.util.*;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = new int[] {1,7,2,4,7};
        System.out.println(solution(arr, arr.length, 8, 3));
    }

    public static int solution(int[] arr, int n, int x, int d) {

		/*
		use reachable to store the position frog can reach currently,
			the reachable is updated when a new leaf comes down in 3 situation,
		1. leaf_pos <= reachable-d
			clearly this leaf will not change the reachable's max
		2. leaf_pos > reachable
			we can't leverage this leaf now bc we can't reach it, but maybe in the future we can reach it,
			so I use priority queue to store it.
		3. reachable-d < leaf_pos <= reachable
			clearly this leaf will extend our reachable to leaf_pos+d
			during this process, if we have any unused leaf(in case 2) in the range [reachable+1, leaf_pos+d]
			lets say k, then we can extend the reachable to k+d
		So for each leaf, we do above update for reachable, then check if x is already reachable
		*/

        if (x <= d) return 0;
        // if no leave falls or no jump, return -1
        if (arr == null || arr.length == 0 || d == 0) return -1;
        int reachable = d;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {

            // Deal with 3 cases
            if (arr[i] > reachable) pq.offer(arr[i]); // case 2
            else if (reachable - d < arr[i]) { // case 3
                reachable = arr[i] + d;
                if (reachable >= x) return i;
                while (!pq.isEmpty()) { // use priority queue to get nearest leaf
                    int leaf_pos = pq.peek();
                    if (leaf_pos <= reachable) {
                        reachable = leaf_pos + d; // update reachable
                        if (reachable >= x) return i;
                        pq.poll();
                    } else break;
                }
            }
            // case 1 do nothing
        }

        return -1;
    }
}