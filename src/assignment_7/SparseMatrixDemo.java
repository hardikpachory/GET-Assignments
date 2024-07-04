package assignment_7;


public class SparseMatrixDemo {

	public static void main(String[] args) {
		SparseMatrix sm = new SparseMatrix( new int[][] { {3,2}, {2,3}} ,2,2 );
		System.out.println("First Matrix - ");
		sm.displaySparse();
		System.out.println("\nIs matrix Symmetric: " + sm.isSymmetric());
		System.out.println();
		SparseMatrix sm2 = new SparseMatrix( new int[][] { {1,5}, {3,7} } ,2,2 );
		System.out.println("Second Matrix - ");
		sm2.displaySparse();
		System.out.println("\nIs matrix Symmetric: " + sm2.isSymmetric());
		System.out.println();
		sm.addMatrix(sm2);
		System.out.println();
		sm.multiplyMatrix(sm2);
		System.out.println("\nTranspose performed:");
		SparseMatrix sm3 = sm2.getTranspose();
		sm3.displaySparse();
		
	}

}
