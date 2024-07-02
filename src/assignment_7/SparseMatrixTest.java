package assignment_7;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SparseMatrixTest {

	@ParameterizedTest
	@MethodSource("getArrayStream1")
	@DisplayName("isSymmetric() Test Case: All AssertTrue")
	void isSymmetricTest(int [][] arr) {
		assertTrue( new SparseMatrix(arr,3,3).isSymmetric() );
	}
	
	@ParameterizedTest
	@MethodSource("getArrayStream2")
	@DisplayName("isSymmetric() Test Case: All AssertFalse")
	void isSymmetricTestTwo(int[][] arr) {
		assertFalse(new SparseMatrix(arr, 3, 3).isSymmetric());
	}
	
	@Test
	@DisplayName("getTranspose() Test Case")
	void getTransposeTestOne() {
		assertTrue(Arrays.deepEquals( new SparseMatrix( new int[][] { {1,4,7},{2,5,8},{3,6,9} }, 3,3).getMatrix(), 
				new SparseMatrix( new int[][] { {1,2,3},{4,5,6},{7,8,9} }, 3,3 ).getTranspose().getMatrix()));
	}
	
	@Test
	@DisplayName("getTranspose() Test Case")
	void getTransposeTestTwo() {
		assertTrue(Arrays.deepEquals( new SparseMatrix( new int[][] { {1},{2},{3} }, 3,1).getMatrix(), 
				new SparseMatrix( new int[][] { {1,2,3}}, 1,3 ).getTranspose().getMatrix())
				);
	}
	
	@Test
	@DisplayName("addMatrix(SparseMatrix obj) Test Case")
	void additionTest() {
		assertTrue(
				Arrays.deepEquals( 
						new SparseMatrix( new int[][] { {2},{4},{6} }, 3,1).getMatrix(), 
						new SparseMatrix( 
								new int[][] { {1}, {2},{3}} ,3,1 ).addMatrix(
										new SparseMatrix( new int[][] { {1}, {2},{3} } ,3,1 )
								).getMatrix()
						)
				);
	}
	
	@Test
	@DisplayName("multiplyMatrix(SparseMatrix obj) Test Case")
	void multiplyTest() {
		assertTrue(
				Arrays.deepEquals( 
						new SparseMatrix( new int[][] { {15,43},{5,17} }, 2,2).getMatrix(), 
						new SparseMatrix( 
								new int[][] { {3,4}, {2,1}} ,2,2 ).multiplyMatrix(
										new SparseMatrix( new int[][] { {1,5}, {3,7} } ,2,2 )
								).getMatrix()
						)
				);
	}
	
	static Stream<Object[]> getArrayStream2(){
		return Stream.of(new Object[] { 
					new int[][] {{1,2,3},{2,4,2},{3,6,1}}
				}, new Object[] {
					new int[][] {{1,0,0}, {0,1,1},{0,0,1} }
				});
	}
	
	static Stream<Object[]> getArrayStream1(){
		return Stream.of(new Object[] { 
					new int[][] {{1,2,3},{2,4,6},{3,6,1}}
				}, new Object[] {
					new int[][] {{1,0,0}, {0,1,0},{0,0,1} }
				});
	}
}
