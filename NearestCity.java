package com.ishm.codingchallenge.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NearestCity {
    public static String[] findNearestCities(int numOfCities,String[] cities, int[] xCoordinates,int[] yCoordinates,int numOfQueries,
                                             String[] queries) {
        PriorityQueue<Map.Entry<String,Integer>> pq[] = new PriorityQueue[numOfCities];
        HashMap<String,Integer> map1 = new HashMap<>();
        for(int i = 0;i<cities.length;i++){
            map1.put(cities[i],i); //String[] cities = {"green","yellow","red","blue","grey","pink"};
        }
        for(int i = 0;i<pq.length;i++)
            pq[i] = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue()!=0?a.getValue()-b.getValue():a.getKey().compareTo(b.getKey()));
        for(int i = 0;i<xCoordinates.length;i++){
            for(int j = 0;j<xCoordinates.length;j++){
                if(i == j)
                    continue;
                if(xCoordinates[i] == xCoordinates[j]){
                    int x = Math.abs(xCoordinates[i] - xCoordinates[j]);//0
                    int y = Math.abs(yCoordinates[i] - yCoordinates[j]);//5
                    int d = x+y;//5
                    HashMap<String,Integer> m = new HashMap<>();
                    m.put(cities[j],d);
                    for(Map.Entry<String,Integer> e : m.entrySet())
                        pq[i].offer(e);
                }
            }
        }
        for(int i = 0;i<yCoordinates.length;i++){
            for(int j = 0;j<yCoordinates.length;j++){
                if(i == j)
                    continue;
                if(yCoordinates[i] == yCoordinates[j]){
                    int x = Math.abs(xCoordinates[i] - xCoordinates[j]);
                    int y = Math.abs(yCoordinates[i] - yCoordinates[j]);
                    int d = x+y;
                    HashMap<String,Integer> m = new HashMap<>();
                    m.put(cities[j],d);//grey,5
                    for(Map.Entry<String,Integer> e : m.entrySet())
                        pq[i].offer(e);//grey=5
                }
            }
        }
        String res[] = new String[numOfQueries];
        for(int i = 0;i<queries.length;i++){
            int idx = map1.get(queries[i]);//4
            if(!pq[idx].isEmpty()){
                Map.Entry<String,Integer> e = pq[idx].peek();
                res[i] = e.getKey();
            }
            else res[i]= "NONE";
        }
        return res;
    }
    public static void main(String[] args) {
        int numOfCities = 6;
        String[] cities = {"green","yellow","red","blue","grey","pink"};
        int[] xCoordinates = {10,20,15,30,10,15} ;
        int[] yCoordinates = {30,25,30,40,25,25};
        int numOfQueries = 4;
        String[] queries = {"grey","blue","red","pink"};
        String res[] = findNearestCities(numOfCities,cities,xCoordinates,yCoordinates,numOfQueries,queries);
        for(String s : res)
            System.out.print(s + " ");
    }
}

    /*Given a list of cities amazonn fulfillment centers, find the nearest cities that shares either an x or a y coordinate with the queried point.

        The distance is denoted on a Euclidean plane: the difference in x plus the difference in y.

        Input

        numOfPoints, an integer representing the number of points;

        points, a list of strings representing the names of each point [i];

        xCoordinates, a list of integers representing the X coordinates of each point[i];

        yCoordinates, a list of integers representing the Y coordinates of each point[i];

        numOfQueriedPoints, an integer representing the number of points queried;

        queriedPoints, a list of strings representing the names of the queried points.

        Output

        Return a list of strings representing the name of the nearest points that shares either an x or a y coordinate with the queried point.

        Example 1:

        Input:

        numOfPoints = 3

        points = ["p1","p2","p3"]

        xCoordinates = [30, 20, 10]

        yCoordinates = [30, 20, 30]

        numOfQueriedPoints = 3

        queriedPoints = ["p3", "p2", "p1"]

        Output:

        ["p1", NONE, "p3"]

        Example 2:

        Input:

        numOfPoints = 5

        points = ["p1", "p2","p3", "p4", "p5"]

        xCoordinates = [10, 20, 30, 40, 50]

        yCoordinates = [10, 20, 30, 40, 50]

        numOfQueriedPoints = 5

        queriedPoints = ["p1", "p2", "p3", "p4", "p5"]

        Output

        [NONE, NONE, NONE, NONE, NONE]*/