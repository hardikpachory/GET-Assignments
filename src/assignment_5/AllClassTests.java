package assignment_5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class AllClassTests {

	@ParameterizedTest
	@ValueSource(ints = {2,3})
	void NQueenTestOne(int queens) {
		assertFalse(NQueens.nQueen(queens));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {4,5})
	void NQueenTestTwo(int queens) {
		assertTrue(NQueens.nQueen(queens));
	}

	
	@ParameterizedTest
	@MethodSource
	void searchLinearTestOne(int ind, int[] arr) {
		assertEquals(ind, Search.linearSearch(arr, 4));
	}
	
	static Stream<Arguments> searchLinearTestOne(){
		return Stream.of(Arguments.of(-1, new int[] {1,2,3,5,6}),
						 Arguments.of(3, new int[] {9,8,3,4,1})
				);
	}
	
	
	@ParameterizedTest
	@MethodSource
	void searchBinaryTestOne(int ind, int[] arr) {
		assertEquals(ind, Search.binarySearch(arr, 6));
	}
	static Stream<Arguments> searchBinaryTestOne(){
		return Stream.of(Arguments.of(-1, new int[] {1, 3, 8, 9} ),
						 Arguments.of(6, new int[] {0,1,2,3,4,5,6} )
				);
	}
	
	@ParameterizedTest
	@MethodSource
	void LcmTestOne(int expeted, int[] twoNumber) {
		assertEquals(expeted, MathsHcfAndLcm.getLCM(twoNumber[0], twoNumber[1]));
	}
	
	static Stream<Arguments> LcmTestOne(){
		return Stream.of(Arguments.of(1800, new int[] {72, 50}),
						 Arguments.of(75, new int[] {15, 25})
				);
	}
	
	@ParameterizedTest
	@MethodSource
	void HcfTestOne(int expeted, int[] twoNumber) {
		assertEquals(expeted, MathsHcfAndLcm.getHCF(twoNumber[0], twoNumber[1]));
	}
	
	static Stream<Arguments> HcfTestOne(){
		return Stream.of(Arguments.of(4, new int[] {96, 404}),
						 Arguments.of(1, new int[] {13, 29})
				);
	}
	
}
