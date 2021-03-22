package Backtracking;

public class NQueen {

	private int noofCol = 8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NQueen();
	}
	
	public NQueen() {
		int[][] board = new int[noofCol][noofCol];
		
		if(!NQUtil(board, 0)) {
			System.out.println("Solutiuon does not exist");
		}
		
		for(int i = 0; i < noofCol; i++) {
			for(int j = 0; j < noofCol; j++) {
				System.out.print(board[i][j] + " ");	
			}
			System.out.println();
		}
	}
	
	
	boolean isQueenSafe(int[][] board, int row, int col) {
		for(int i = 0; i < col; i++) {
			if(board[row][i] == 1)
				return false;
		}
		
		//Upper diagonal
		for(int i=row, j=col; i >= 0 && j >=0; i--,j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		for(int i=row, j=col; j >=0 && i < noofCol; i++,j-- ) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	public boolean NQUtil(int[][] board, int col) {
		if(noofCol <= col)
			return true;
		
		for(int i = 0; i < noofCol; i++) {
			if(isQueenSafe(board, i, col)) {
				board[i][col] = 1;
				
				if(NQUtil(board, col +1)) return true;
				
				board[i][col] = 0;
			}
		}
		
		
		return false;
	}
}
