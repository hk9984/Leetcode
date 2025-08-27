package Graphs;
import java.util.*;

class Dijkstra {
    
    class Node {   
        int node;
        int wt;
        
        Node(int n, int w) {
            this.node = n;
            this.wt = w;
        }
    }
    
    public List<List<Node>> createAdjList(int V, int[][] edges) {
        
        List<List<Node>> adjList = new ArrayList<>();
        
        for(int i=0; i<V; i++)
            adjList.add(new ArrayList<>());
        
        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];
            
            adjList.get(node1).add(new Node(node2, weight));
            adjList.get(node2).add(new Node(node1, weight));
        }
        
        return adjList;
    }
    
    public void dijkstra(int V, List<List<Node>> adjList, int[] dist, int src) {
        for(int i=0; i<V; i++) 
            dist[i] = (i != src) ? Integer.MAX_VALUE : 0;
            
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.wt, n2.wt);
            }
        });
        
        minHeap.offer(new Node(src,0));
        
        while(!minHeap.isEmpty()) {
            Node n = minHeap.poll();
            int nodeNum = n.node;
            int weight = n.wt;
            //int dist = dist[nodeNum];
            
            for(Node neighbor: adjList.get(nodeNum)) {
                int neighNode = neighbor.node;
                int neighWt = neighbor.wt;
                
                if(dist[neighNode] > dist[nodeNum] + neighWt) {
                    dist[neighNode] = dist[nodeNum] + neighWt;
                    minHeap.offer(new Node(neighNode, dist[neighNode]));
                }
            }
        }
    }
    
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<List<Node>> adjList = createAdjList(V, edges);
        int[] dist = new int[V];
        dijkstra(V, adjList, dist, src);
        return dist;
        
    }
}
