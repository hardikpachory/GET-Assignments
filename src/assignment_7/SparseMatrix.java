package assignment_7;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Index{
	/**
	 * The class index will help to store the location of an element in a sparse matrix
	 */
	
	int row;
	int col;
	
	public Index() {
		super();
	}
	
	public Index(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || getClass() != obj.getClass()) {
			return false;
		}
		Index index = (Index) obj;
		return row==index.row && col==index.col;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}

	@Override
	public String toString() {
		return "Index [row=" + row + ", col=" + col + "]";
	}
}


public final class SparseMatrix {
	/**
	 * The class will implement Sparse Matrix as a map of Index and its values
	 */
	
	private final Map<Index, Integer> sparseMatrix;
	private final int numberOfRows;
	private final int numberOfColumns;
	
	/**
	 * Constructor to create sparse matrix out of 2D array
	 * @param matrix  2D array
	 * @param rows    number of rows
	 * @param cols    number of cols
	 */
	public SparseMatrix(int[][] matrix, int rows, int cols) {
		sparseMatrix = new LinkedHashMap<Index, Integer>();
		numberOfRows = rows;
		numberOfColumns = cols;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(matrix[i][j]!=0) {
					sparseMatrix.put(new Index(i, j), matrix[i][j]);
				}
			}
		}
	}
	
	/**
	 * Constructor to create sparse matrix out of Map
	 * @param map  Map of index and value
	 * @param rows number of rows
	 * @param cols number of columns
	 */
	public SparseMatrix(Map<Index, Integer> map, int rows, int cols) {
		numberOfColumns = cols;
		numberOfRows = rows;
		sparseMatrix = new LinkedHashMap<Index, Integer>();
		sparseMatrix.putAll(map);
	}
	
	/**
	 * Get total number of Rows
	 * @return numberOfRows property
	 */
	public int getRows() {
		return numberOfRows;
	}
	
	/**
	 * Get sparse matrix map
	 * @return sparse matrix in form of map
	 */
	public Map<Index, Integer> getMatrixMap(){
		return sparseMatrix;
	}
	
	/**
	 * Get total number of columns
	 * @return numberOfColumns
	 */
	public int getCols() {
		return numberOfColumns;
	}

	/**
	 * Generate a 2D array using the map sparse matrix
	 * @return 2D sparse matrix
	 */
	public int[][] getMatrix(){
		int[][] arr = new int[numberOfRows][numberOfColumns];
		for(int i=0; i<numberOfRows; i++) {
			for(int j=0; j<numberOfColumns; j++) {
				arr[i][j] = 0;
			}
		}
		for(Index key : sparseMatrix.keySet()) {
			arr[key.getRow()][key.getCol()] = sparseMatrix.get(key);
		}
		return arr;
	}
	
	/**
	 * display the sparse matrix
	 */
	public void displaySparse() {
		int[][] matrix = getMatrix();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Check if the sparse matrix is a symmetric matrix
	 * @return true if symmetrix, else false
	 */
	public boolean isSymmetric() {
		if(numberOfColumns != numberOfRows)
			return false;
		return sparseMatrix.equals(this.getTranspose().getMatrixMap());
	}
	
	/**
	 * Helper function to check if Index ind exists
	 * @param ind Index as row and col
	 * @return    Return true if ind exists else false
	 */
	public boolean isValidKey(Index ind) {
		return sparseMatrix.containsKey(ind);
	}
	
	/**
	 * Perform matrix tranformation and return the sparseMatrix object
	 * @return SparseMatrix object
	 */
	public SparseMatrix getTranspose() {
		Map<Index, Integer> transpose = new LinkedHashMap<Index, Integer>();
		for(Map.Entry<Index, Integer> entry: sparseMatrix.entrySet()) {
			Index index = entry.getKey();
			
			transpose.put( new Index( index.getCol(), index.getRow() ), entry.getValue() );
		}
		SparseMatrix matrix = new SparseMatrix(transpose, numberOfColumns, numberOfRows);
//		System.out.println("Transpose Performed:");
//		matrix.displaySparse();
		return matrix;
	}
	
	/**
	 * Return the value of element at index key in sparse Matrix
	 * @param key Index for which element is to be find
	 * @return the value at index in matrix
	 */
	public int getValueOfKey(Index key) {
		return sparseMatrix.get(key);
	}
	
	/**
	 * Performs addition of two matrices
	 * @param otherMatrix SparseMatrix to add with
	 * @return            SparseMatrix object containing the sum of the matrices
	 */
	public SparseMatrix addMatrix(SparseMatrix otherMatrix) {
		Map<Index, Integer> result = new LinkedHashMap<Index, Integer>();
		
		if(this.getRows() != otherMatrix.getRows() || this.getCols() != otherMatrix.getCols()) {
			SparseMatrix matrix = new SparseMatrix(result, 0, 0);
			return matrix;
		}
		
		Set<Index> setIndex = new HashSet<Index>();
	
		for(Map.Entry<Index, Integer> entry : sparseMatrix.entrySet()) {
			Index index = entry.getKey();
			if(otherMatrix.isValidKey(index) && !setIndex.contains(index)) {
				setIndex.add(index);
				result.put(index, this.getValueOfKey(index) + otherMatrix.getValueOfKey(index));
			} else if(setIndex.contains(index)) {
				result.put(index, result.get(index) + entry.getValue());
			} else {
				setIndex.add(index);
				result.put(index, entry.getValue());
			}
		}
		for(Map.Entry<Index, Integer> entry : otherMatrix.getMatrixMap().entrySet()) {
			Index index = entry.getKey();
			if(!setIndex.contains(index)) {
				setIndex.add(index);
				result.put(index, entry.getValue());
			}
		}
		SparseMatrix ans = new SparseMatrix(result, numberOfRows, numberOfColumns);
		System.out.println("Addition Performed:");
		ans.displaySparse();
		return ans;
	}
	
	/**
	 * Perform the multiplication of two matrices
	 * @param otherMatrix SparseMatrix to multiply with
	 * @return            SparseMatrix object containing the product of the matrices
	 */
	public SparseMatrix multiplyMatrix(SparseMatrix otherMatrix) {
		int row1 = this.getRows();
		int row2 = otherMatrix.getRows();
		int col1 = this.getCols();
		int col2 = otherMatrix.getCols();
		if(row2!=col1) {
			Map<Index, Integer> map = new LinkedHashMap<Index, Integer>();
			return new SparseMatrix(map , 0, 0);
		}
		
		int i,j,k;
		
		int A[][] = getMatrix();
		int B[][] = otherMatrix.getMatrix();
		int C[][] = new int[row1][col2];
		
		for (i = 0; i < row1; i++) { 
            for (j = 0; j < col2; j++) { 
                for (k = 0; k < row2; k++) 
                    C[i][j] += A[i][k] * B[k][j]; 
            } 
        }
		SparseMatrix product = new SparseMatrix(C, row1, col2);
		System.out.println("Multiplication Performed:");
		product.displaySparse();
		return product;
	}
}
