package assignment_7;


public class SparseMatrixDemo {

	public static void main(String[] args) {
		
		 
		SparseMatrix sm = new SparseMatrix(new int[][] {
			{ 1, 1, 1 }, 
            { 2, 2, 2 }, 
            { 3, 3, 3 }, 
            { 4, 4, 4 }
		}, 4,3);
//		Map<Index,Integer> map = new LinkedHashMap<Index, Integer>();
//		map.put(new Index(0,3), 9);
//		map.put(new Index(1,1), 9);
//		map.put(new Index(2,1), 9);
//		map.put(new Index(2,3), 9);
//		map.put(new Index(3,2), 5);
//		System.out.println("Other way");
		
		SparseMatrix sm1 = new SparseMatrix(new int[][] {
			{ 1, 1, 1, 1 }, 
            { 2, 2, 2, 2 }, 
            { 3, 3, 3, 3 }
		}, 3,4);
		
		SparseMatrix sm2 = new SparseMatrix(new int[][] {
			{ 1, 0, 0, 0 }, 
            { 0, 1, 0, 0 }, 
            { 0, 0, 1, 0 },
            { 0, 0, 0, 1}
		}, 4,4);
		
		SparseMatrix sm3 = new SparseMatrix(new int[][] {
			{ 1, 9, 0, 1 }, 
            { 0, 1, 0, 1 }, 
            { 0, 0, 1, 1 },
            { 0, 0, 0, 1}
		}, 4,4);
		
		System.out.println("Addition: - ");
		sm2.addMatrix(sm3);
		
		System.out.println("Transpose: ");
		sm.getTranspose();
		
		System.out.println("Transpose: ");
		sm1.getTranspose();
		
		System.out.println("Addition: ");
		sm.addMatrix(sm1);
		System.out.println("Multiplication: ");
		sm.multiplyMatrix(sm1);
		System.out.println("Check Symmetry: ");
		System.out.println(sm2.isSymmetric());
		System.out.println(sm1.isSymmetric());
	}

}
