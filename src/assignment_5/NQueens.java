package assignment_5;

import java.util.Scanner;

public class NQueens {
	
	static int arr[][];
	
	/**
	 * Set the board all locations to 0
	 * @param n number of rows and cols on board
	 */
	static void setBoard(int n){
		arr = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n;j++)
				arr[i][j] = 0;
	}
	
	/**
	 * Helper function to handle recursions on nQUeens
	 * @param board            Integer matrix
	 * @param startRow         current index being checked 
	 * @param matrixDimension  number of total rows
	 * @return                 true or false
	 */
	static boolean nQueenHelper(int[][] board, int startRow, int matrixDimension) {
		if(startRow >= matrixDimension) {
			return true;
		}
		for(int i = 0; i<matrixDimension; i++) {
			if(isSafeSpot(board, i, startRow)) {
				board[i][startRow] = 1;
				
				if(nQueenHelper(board, startRow + 1, matrixDimension))
					return true;
				
				// Backtrack and reset the state of the board
				board[i][startRow] = 0;
			}
		}
		return false;
	}
	
	/**
	 * Helper function to check if the move will be safe or not
	 * @param board  Integer matrix
	 * @param row    current position of row
	 * @param col    current position of column
	 * @return       true if the queen is safe else false
	 */
	private static boolean isSafeSpot(int[][] board, int row, int col) {
		int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

       
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
            
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
	}
	
	/**
	 * Helper function that will help to setup the board and call the nQueen function 
	 * @param board            Integer matrix to set
	 * @param startRow         beginning index   
	 * @param matrixDimention  The size of the matrix
	 * @return                 True if nQueen solution exists, else false; 
	 */
	static boolean nQueen(int matrixDimention) {
		setBoard(matrixDimention);
		return nQueenHelper(arr, 0, matrixDimention);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N: ");
		int n = sc.nextInt();
		sc.close();
		if (!nQueen(n)) {
	            System.out.print("Solution does not exist");
	            return;
	        }
		 
		 for(int i=0; i<n; i++) {
			 for(int j=0;j<n;j++) {
				 System.out.print(arr[i][j] + " ");
			 }
			 System.out.println();
		 }
		 
	}

}