/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kruskal;

import java.util.Arrays;

/**
 *
 * @author Student
 */
public class Graph {
    
    private int noOfVert;
    private int noOfEdges;
    public Edge[] edge;
    
    public Graph(int v, int e){
        this.noOfVert = v;
        this.noOfEdges = e;
        edge = new Edge[e];
        
        for(int i = 0; i < e; i++){
            edge[i] = new Edge();
        }
    }
    
    public class Subset {
        int parent, rank;
    }
    
    public class Edge implements Comparable<Edge>{
        public int src;
        public int dest;
        public int weight;
        
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    int find(Subset[] subsets, int i){
        if(subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        
        return subsets[i].parent;
    }
    
    public void Union(Subset[] subsets, int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        
        if(subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if(subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    public void Kruskal(){
        Edge[] result = new Edge[noOfVert];        
        for(int i = 0 ; i < noOfVert; i++)
            result[i] = new Edge();
        
        Arrays.sort(edge);
        
        Subset[] subsets = new Subset[noOfVert];
        for(int i =0; i < noOfVert; i++)
            subsets[i] = new Subset();
        
        for(int i = 0; i < noOfVert; i++){
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        
        int index = 0, indexofResult = 0; 
        
        
        while(indexofResult < noOfVert - 1){
            Edge next_edge = edge[index++];
            
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            
            if(x != y){
                result[indexofResult++] = next_edge;
                Union(subsets, x, y);
            }
        }
        
        System.out.println("Edges in the MST");
        
        for(int i = 0; i < indexofResult; i++){
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
    }
}
