/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

/**
 *
 * @author 1
 */
public class BellmanfordSP {
    
    class Edge { 
        int src, dest, weight; 
        Edge() 
        { 
            src = dest = weight = 0; 
        } 
    }; 
  
    int V, E; 
    Edge edge[]; 
  
    BellmanfordSP(int v, int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[e]; 
        for (int i = 0; i < e; ++i) 
            edge[i] = new Edge(); 
    } 
    
    void BellmanFord(BellmanfordSP bsp, int src) 
    { 
        int V = bsp.V, E = bsp.E; 
        int dist[] = new int[V]; 
  
        for (int i = 0; i < V; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        dist[src] = 0; 
  
        for (int i = 1; i < V; ++i) { 
            for (int j = 0; j < E; ++j) { 
                int u = bsp.edge[j].src; 
                int v = bsp.edge[j].dest; 
                int weight = bsp.edge[j].weight; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
                    dist[v] = dist[u] + weight; 
            } 
        } 
  
        for (int j = 0; j < E; ++j) { 
            int u = bsp.edge[j].src; 
            int v = bsp.edge[j].dest; 
            int weight = bsp.edge[j].weight; 
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
                System.out.println("Graph contains negative weight cycle"); 
                return; 
            } 
        } 
        printArr(dist, V); 
    } 
  
    void printArr(int dist[], int V) 
    { 
        System.out.println("Vertex Distance from Source"); 
        for (int i = 0; i < V; ++i) 
            System.out.println(i + "\t\t" + dist[i]); 
    } 
  
    public static void main(String[] args) 
    { 
        int V = 5; // Number of vertices in graph 
        int E = 8; // Number of edges in graph 
  
        BellmanfordSP graph = new BellmanfordSP(V, E); 
  
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = -1; 
  
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 4; 
  
        graph.edge[2].src = 1; 
        graph.edge[2].dest = 2; 
        graph.edge[2].weight = 3; 
  
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 2; 
  
        graph.edge[4].src = 1; 
        graph.edge[4].dest = 4; 
        graph.edge[4].weight = 2; 
  
        graph.edge[5].src = 3; 
        graph.edge[5].dest = 2; 
        graph.edge[5].weight = 5; 
        
        graph.edge[6].src = 3; 
        graph.edge[6].dest = 1; 
        graph.edge[6].weight = 1; 
  
        graph.edge[7].src = 4; 
        graph.edge[7].dest = 3; 
        graph.edge[7].weight = -3; 
        
        graph.BellmanFord(graph, 0); 
    } 
} 
