package Leetcode.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shortestDist2nodesADJLIST {

    public static int shortestPath(List<List<Integer>> adj, int src, int dest) {

        boolean[] visited = new boolean[adj.size()];

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{src, 0, String.valueOf(src)});
        visited[src] = true;

        //int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty()) {
            Object[] vertex = queue.poll();

            int v = (Integer)vertex[0];
            int currDist = (Integer)vertex[1];
            String pathSoFar = (String)vertex[2];

            if(v == dest) {
                System.out.println("Resultant Path: " + pathSoFar);
                return currDist;
            }

            for(int edge: adj.get(v)) {
                if(!visited[edge]) {
                    visited[edge] = true;
                    queue.add(new Object[]{edge,currDist+1, pathSoFar + "->" + edge});
                }
            }
        }


        return -1;
    }


    public static int altshortestPath(List<List<Integer>> adj, int src, int dest) {

        boolean[] visited = new boolean[adj.size()];

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{src, 0, ""});
        visited[src] = true;

        //int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty()) {
            Object[] vertex = queue.poll();

            int v = (Integer)vertex[0];
            int currDist = (Integer)vertex[1];
            String pathSoFar = (String)vertex[2];

            if(v == dest) {
                System.out.println("Resultant Path: " + pathSoFar + v);
                return currDist;
            }

            for(int edge: adj.get(v)) {
                if(!visited[edge]) {
                    visited[edge] = true;
                    queue.add(new Object[]{edge,currDist+1, pathSoFar + v + "->"});
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(0).add(2); adj.get(2).add(0);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(3).add(4); adj.get(4).add(3);

        int src = 4,dest = 1;

        System.out.println("Shortest Path: " + shortestPath(adj, src, dest));   

        System.out.println("Shortest Path alt: " + altshortestPath(adj, src, dest));

        /* This is the graph representation
           
            0 - 1 - 3 - 4   
            \
              2
        */

    }
    
}
