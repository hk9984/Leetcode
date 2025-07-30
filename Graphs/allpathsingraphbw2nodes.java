package Leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * 
 * Goal:

Print all valid paths from source to destination using only up, down, left, right moves

Avoid cycles and blocked cells
 */

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class allpathsingraphbw2nodes {

    private static final int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public static void dfs(int[][]grid, int currRow, int currCol, int destRow, int destCol, String path, List<String> resultPaths) {

        
        
        if(currRow == destRow && currCol == destCol) {
            resultPaths.add(path + "(" + currRow + "," + currCol + ")");
            return;
        }

        grid[currRow][currCol] = 0; //mark visited

        for(int[] dir: directions) {
            int newRow = currRow + dir[0];
            int newCol = currCol + dir[1];

            if(newRow >= 0 && newRow < grid.length  && newCol >= 0 && newCol < grid[0].length &&  grid[newRow][newCol] == 1) {
                dfs(grid, newRow, newCol, destRow, destCol, path + "(" + currRow + "," + currCol + ")->", resultPaths);
            }
        }

        grid[currRow][currCol] = 1;


    }

    public static List<String> findAllPaths(int[][] grid, int srcRow, int srcCol, int destRow, int destCol) {

        if(grid[srcRow][srcCol] != 1 || grid[destRow][destCol] != 1)
            return null;

        List<String> resultPaths = new ArrayList<String>();

        dfs(grid, srcRow, srcCol, destRow, destCol, "", resultPaths);

        return resultPaths;
        // int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};


        // Queue<Object[]> queue = new LinkedList();

        // queue.add(new Object[]{srcRow, srcCol, new ArrayList<String>()});

        // while(!queue.isEmpty()) {
        //     Object[] node = queue.poll();
        //     int row = (Integer)node[0];
        //     int col = (Integer)node[1];

        //     ArrayList<String> nodePaths = (ArrayList<String>)node[2];

        //     grid[row][col] = 0;

        //     if(srcRow == destRow && srcCol == destCol) {
        //         for(String path: nodePaths)
        //             resultPaths.add(path);
        //         continue;
        //     }

        //     for(int[] dir : directions) {
        //         int newRow = row + dir[0];
        //         int newCol = col + dir[1];

        //         if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] = )
        //     }
        // }
        // return null;

    }




    public static void main(String[] args) {

        int[][] grid = {
            { 1, 1, 0 },
            { 1, 1, 1 },
            { 0, 1, 1 }
        };

        int srcRow = 0, srcCol = 0;
        int destRow = 2, destCol = 2;

        List<String> allPaths = findAllPaths(grid, srcRow, srcCol, destRow, destCol);
        System.out.println("All paths from (" + srcRow + "," + srcCol + ") to (" + destRow + "," + destCol + "):");
        for (String path : allPaths) {
            System.out.println(path);
        }
    }
    
}
