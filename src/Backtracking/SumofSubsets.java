package Backtracking;

public class SumofSubsets {

	static int subsetCount = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[] {1, 3, 5, 2};
		
		subset( data, 0, 0, 6);
		
		System.out.println("Total subset count : " + subsetCount );
		
	}
	
	public static void subset(int[] data, int currentsum, int startIndex, int total) {
		if(currentsum == total) {
			subsetCount++;
			
			if(startIndex < data.length) {
				subset(data, currentsum - data[startIndex-1], startIndex, total);
			}
		}else {
			for(int i = startIndex; i < data.length; i++ ) {
				subset(data, currentsum + data[i], i+1, total);
			}
		}
	}
}
