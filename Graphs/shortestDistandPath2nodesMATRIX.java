package Leetcode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class shortestDistandPath2nodesMATRIX {

    static int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static int shortestDistance(int[][] grid, int srcRow, int srcCol, int destRow, int destCol) {

        

        if(grid[srcRow][srcCol] == 1 || grid[destRow][destCol] == 1) {
            System.out.println("No path");
            return -1;
        }
        
        Queue<Object[]> queue = new LinkedList();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.add(new Object[]{srcRow, srcCol, 0, "(" + srcRow + "," + srcCol + ")"});
        visited[srcRow][srcCol] = true;

        while(!queue.isEmpty()) {
            Object[] node = queue.poll();

            int row = (Integer)node[0];
            int col = (Integer)node[1];
            int currDist = (Integer)node[2];
            String currPath = (String)node[3];

            if(row == destRow && col == destCol) {
                System.out.println("Shortest Path: " + currPath);
                return currDist;
            }

            for(int[] dir: directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    queue.add(new Object[]{newRow, newCol, currDist + 1, currPath + "->" + "(" + newRow + "," + newCol + ")"});
                    visited[newRow][newCol] = true;
                }

            }


        }

        return -1;

        

        
    } 

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 0}
        };

        // Define source and destination coordinates
        int srcRow = 0, srcCol = 0;
        int destRow = 3, destCol = 3;

        System.out.println("Shortest Distance B/w source and dest: " + shortestDistance(grid, srcRow, srcCol, destRow, destCol));



    }
    
}
