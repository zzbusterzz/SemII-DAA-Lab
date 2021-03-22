package Backtracking;

public class GraphColor {

	static int V = 4;
	static int color[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalNodes = 4;
		
		int [][] graph = {	{0,1,1,1},
							{1,0,1,0},
							{1,1,0,1},
							{1,0,1,0}
						};
		
		
		int noofColors = 3;//No of colors
		
		SetColor(graph, noofColors);
		
		for (int i = 0; i < V; i++) 
            System.out.print(" " + color[i] + " "); 
        System.out.println(); 
	}
	
	public static void SetColor(int[][] graph, int noofColors) {
		color = new int[V];
		
		
		if(!graphColorUtil(graph, noofColors, color, 0 ))
		{
			System.out.println("Solution does not exist"); 
		}
	}
	
	public static boolean graphColorUtil(int[][] graph, int cl, 
									int[] color, int vert) {
		
		if(vert == V)
			return true;
		
		for(int c = 1; c <= cl; c++) {
			if(isSafe(vert, graph, color, c) ) {
				color[vert] = c;
				
				if(graphColorUtil(graph, cl,color, vert+1)) return true;
				
				color[vert] = 0;
				
			}
		}
		
		return false;
	}
	
	public static boolean isSafe(int v, int[][] graph, int[] color, int c) { 

		for(int i = 0; i < V; i++) {
			if(graph[v][i] == 1 && c == color[i])
				return false;	
		}
		
		return true;
	}
}
