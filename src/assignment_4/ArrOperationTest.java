package assignment_4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrOperationTest {

	// Test cases for maxMirror function

	@Test  // Annotation that coming function is a test case
	@DisplayName("maxMirror Test: 1")  // To identify the test case by name given by us
//  @Order(n) to set the order of execution
	void maxMirrorTestOne() {
		assertEquals(3, ArrOperation.maxMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }));
	}

	@Test
	@DisplayName("maxMirror Test: 2")
	void maxMirrorTestTwo() {
		assertEquals(7, ArrOperation.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 }));
	}

	@Test
	@DisplayName("maxMirror Test: 3")
	void maxMirrorTestThree() {
		assertEquals(3, ArrOperation.maxMirror(new int[] { 1, 2, 1, 3 }));
	}

	@Test
	@DisplayName("maxMirror Test: 4")
	void maxMirrorTestFour() {
		assertThrows(AssertionError.class, () -> ArrOperation.maxMirror(new int[] {}));
	}

	// Test cases for countClumps function

	@Test
	@DisplayName("countClumps Test: 1")
	void countClumpsTestOne() {
		assertEquals(2, ArrOperation.countClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
	}

	@Test
	@DisplayName("countClumps Test: 2")
	void countClumpsTestTwo() {
		assertEquals(1, ArrOperation.countClumps(new int[] { 1, 1, 1, 1 }));
	}

	@Test
	@DisplayName("countClumps Test: 3")
	void countClumpsTestThree() {
		assertThrows(AssertionError.class, () -> ArrOperation.countClumps(new int[] {}));
	}

	// Test cases for fixXY function

	@Test
	@DisplayName("fixXY Test: 1")
	void fixXYTestOne() {
		assertArrayEquals(new int[] { 9, 4, 5, 4, 5, 9 }, ArrOperation.fixXY(new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5));
	}

	@Test
	@DisplayName("fixXY Test: 2")
	void fixXYTestTwo() {
		assertArrayEquals(new int[] { 1, 4, 5, 1 }, ArrOperation.fixXY(new int[] { 1, 4, 1, 5 }, 4, 5));
	}

	@Test
	@DisplayName("fixXY Test: 3")
	void fixXYTestThree() {
		assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 }, ArrOperation.fixXY(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 4, 5));
	}

	@Test
	@DisplayName("fixXY Test: 4")
	void fixXYTestFour() {
		assertThrows(AssertionError.class, () -> ArrOperation.fixXY(new int[] {}, 4, 5));
	}

	@Test
	@DisplayName("fixXY Test: 5")
	void fixXYTestFive() {
		assertThrows(AssertionError.class, () -> ArrOperation.fixXY(new int[] { 1, 4, 1, 5, 5, 4, 4, 1 }, 4, 5));
	}

	@Test
	@DisplayName("fixXY Test: 6")
	void fixXYTestSix() {
		assertThrows(AssertionError.class, () -> ArrOperation.fixXY(new int[] { 1, 4, 1, 5, 5, 4, 5, 4 }, 4, 5));
	}

	// Test Cases for splitArray function

	@Test
	@DisplayName("splitArray Test: 1")
	void splitArrayTestOne() {
		assertThrows(AssertionError.class, () -> ArrOperation.splitArray(new int[] {}));
	}

	@Test
	@DisplayName("splitArray Test: 2")
	void splitArrayTestTwo() {
		assertEquals(3, ArrOperation.splitArray(new int[] { 1, 1, 1, 2, 1 }));
	}

	@Test
	@DisplayName("splitArray Test: 3")
	void splitArrayTestThree() {
		assertEquals(-1, ArrOperation.splitArray(new int[] { 2, 1, 1, 2, 1 }));
	}

	@Test
	@DisplayName("splitArray Test: 4")
	void splitArrayTestFour() {
		assertEquals(1, ArrOperation.splitArray(new int[] { 10, 10 }));
	}

	@Test
	@DisplayName("splitArray Test: 5")
	void splitArrayTestFive() {
		assertEquals(-1, ArrOperation.splitArray(new int[] { 10 }));
	}
	
	/*  ------ Providing wrong expected result so that the test cases should fail  ------  */
	
	// maxMirror Negative Test Cases
	
	@Test
	@DisplayName("maxMirror Negative Test: 1")
	void maxMirrorNegativeTestOne() {
		assertEquals(5, ArrOperation.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 }));
	}

	@Test
	@DisplayName("maxMirror Negative Test: 2")
	void maxMirrorNegativeTestTwo() {
		assertEquals(1, ArrOperation.maxMirror(new int[] { 1, 2, 1, 3 }));
	}
	
	// countClumps Negative Test Cases
	
	@Test
	@DisplayName("countClumps Negative Test: 1")
	void countClumpsNegativeTestOne() {
		assertEquals(4, ArrOperation.countClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
	}

	@Test
	@DisplayName("countClumps Negative Test: 2")
	void countClumpsNegativeTestTwo() {
		assertEquals(5, ArrOperation.countClumps(new int[] { 1, 1, 1, 1 }));
	}
	
	// fixXY Negative Test Cases
	
	@Test
	@DisplayName("fixXY Test: 1")
	void fixXYTestNegativeOne() {
		assertArrayEquals(new int[] { 9, 4, 5, 5, 9 }, ArrOperation.fixXY(new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5));
	}

	@Test
	@DisplayName("fixXY Test: 2")
	void fixXYTestNegativeTwo() {
		assertArrayEquals(new int[] { 1, 4, 1 }, ArrOperation.fixXY(new int[] { 1, 4, 1, 5 }, 4, 5));
	}
	
	// splitArray Negative Test Cases
	
	@Test
	@DisplayName("splitArray Negative Test: 1")
	void splitArrayNegativeTestOne() {
		assertThrows(AssertionError.class, () -> ArrOperation.splitArray(new int[] {1,2,4,3}));
	}

	@Test
	@DisplayName("splitArray Negative Test: 2")
	void splitArrayTestNegativeTwo() {
		assertEquals(2, ArrOperation.splitArray(new int[] { 1, 1, 1, 2, 1 }));
	}
	
	
	
}
