package Coupang;

import java.util.LinkedList;
import java.util.Queue;



public class numberOfIslands {
	
	/*
	 * Time Complexity for DFS method: O(MxN) where M is no. of rows and N is no. of columns
	 * Space Complexity for DFS method: worst case O(MxN) in case that the grid map is filled with lands where DFS 
	 * goes by MxN deep
	 * 
	 * */
	
	public static int numIslandsDFS(char[][] grid) {
        
        int numIslands = 0;
        
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;
                    helperDFS(grid, i, j);
                }
            }
        }
        
        return numIslands;
        
    }
    
    public static void helperDFS(char[][]grid, int row, int col) {
        grid[row][col] = '0';
        
        //checking up
        if(row-1 >= 0 && grid[row-1][col] == '1')
            helperDFS(grid, row-1, col);
        
        //checking down
        if(row+1 < grid.length && grid[row+1][col] == '1')
            helperDFS(grid, row+1, col);
        
        //checking left
        if(col-1 >= 0 && grid[row][col-1] == '1')
            helperDFS(grid, row, col-1);
        
        //checking right
        if(col+1 <grid[row].length && grid[row][col+1] == '1')
            helperDFS(grid, row, col+1);
    }
    
    
    
    /*
	 * Time Complexity for BFS method: O(MxN) where M is no. of rows and N is no. of columns
	 * Space Complexity for BFS method: O(min(M,N)) because in worst case where the 
	 * grid is filled with lands, the size of queue can grow up to min(M,N)
	 * 
	 * */
    public static int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
          return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;


        for (int r = 0; r < nr; ++r) {
          for (int c = 0; c < nc; ++c) {
            if (grid[r][c] == '1') {
              ++num_islands;
              grid[r][c] = '0'; // mark as visited
              Queue<Integer> neighbors = new LinkedList<>();
              neighbors.add(r * nc + c);
              while (!neighbors.isEmpty()) {
                int id = neighbors.remove();
                int row = id / nc;
                int col = id % nc;
                if (row - 1 >= 0 && grid[row-1][col] == '1') {
                  neighbors.add((row-1) * nc + col);
                  grid[row-1][col] = '0';
                }
                if (row + 1 < nr && grid[row+1][col] == '1') {
                  neighbors.add((row+1) * nc + col);
                  grid[row+1][col] = '0';
                }
                if (col - 1 >= 0 && grid[row][col-1] == '1') {
                  neighbors.add(row * nc + col-1);
                  grid[row][col-1] = '0';
                }
                if (col + 1 < nc && grid[row][col+1] == '1') {
                  neighbors.add(row * nc + col+1);
                  grid[row][col+1] = '0';
                }
              }
            }
          }
        }
        return num_islands;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid = new char[][] {
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}	
		};
		
		System.out.println("Number of Islands with DFS: " + numIslandsDFS(grid));
		grid = new char[][] {
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}	
		};
		
		System.out.println("Number of Islands with BFS: " + numIslandsBFS(grid));
		

	}

}
