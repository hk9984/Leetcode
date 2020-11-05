package Walmart;

import java.util.Arrays;
import java.util.Stack;

public class graph_bipartite {
	
	/*
    Time Complexity: O(N+E) where N is no. of nodes, E is no. of edges. 
     We explore each node once when we transform it from uncolored to colored, traversing all its edges in the          process.
     
    Space Complexity: O(N). To store the color array
    */
    public boolean isBipartite(int[][] graph) {
        
        if(graph.length == 0)
            return true;
        
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        
        for(int index=0; index < graph.length; index++) {
            if(color[index] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(index);
                color[index] = 0;
                
                while(!stack.isEmpty()) {
                    int node = stack.pop();
                    
                    int neigh_color = color[node] ^ 1;
                    
                    for(int neighbour : graph[node]) {
                        if(color[neighbour] == -1) {
                            color[neighbour] = neigh_color;
                            stack.push(neighbour);
                        }
                        else {
                            if(color[neighbour] != neigh_color)
                                return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
