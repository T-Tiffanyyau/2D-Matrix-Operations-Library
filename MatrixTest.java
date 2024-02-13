package twoDmatrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author CS 2420 staff and Tiffany Yau
 * @version August 18, 2021
 *
 */
class MatrixTest {

	Matrix matrix = new Matrix(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 }
	});

	Matrix negativeAndPositive = new Matrix(new int[][] {
			{ 2, 1, 0 },
			{ -1, -2, -3 },
			{ -4, -5, -6 }
	});

	Matrix allSame = new Matrix(new int[][] {
			{ 2, 2, 2 },
			{ 2, 2, 2 }
	});

	Matrix single = new Matrix(new int[][] {
			{ 0 }
	});

	/* ******equals tests****** */
	@Test
	void testModerateMatricesEqual() {

		Matrix m2 = new Matrix(new int[][] {
				{ 1, 2, 3 },
				{ 4, 5, 6 }
		});

		assertTrue(matrix.equals(m2));
	}

	@Test
	void testNegativeAndPositiveEqual() {

		Matrix m2 = new Matrix(new int[][] {
				{ 2, 1, 0 },
				{ -1, -2, -3 },
				{ -4, -5, -6 }
		});

		assertTrue(negativeAndPositive.equals(m2));
	}

	@Test
	void testAllSameEqual() {

		Matrix m2 = new Matrix(new int[][] {
				{ 2, 2, 2 },
				{ 2, 2, 2 }
		});

		assertTrue(allSame.equals(m2));
	}

	@Test
	void testSingleMEqual() {

		Matrix m2 = new Matrix(new int[][] {
				{ 0 }
		});

		assertTrue(single.equals(m2));
	}

	@Test
	void testObjectMatricesEqual() {

		char o = 'a';
		assertFalse(matrix.equals(o));
	}

	/* ******end equals tests****** */

	/* ******toString tests****** */
	@Test
	void testModerateToString() {
		Matrix m = new Matrix(new int[][] {
				{ 1, 2 },
				{ 3, 4 }
		});

		assertEquals("1 2\n3 4\n", m.toString());
	}

	@Test
	void testNegativeAndPositiveModerateToString() {

		assertEquals("2 1 0\n-1 -2 -3\n-4 -5 -6\n", negativeAndPositive.toString());
	}

	@Test
	void testAllSameModerateToString() {

		assertEquals("2 2 2\n2 2 2\n", allSame.toString());
	}

	@Test
	void testSingleModerateToString() {

		assertEquals("0\n", single.toString());
	}

	/* ******end toString tests****** */

	/* ******times tests****** */
	@Test
	void testCompatibleTimes() {

		Matrix m1 = new Matrix(new int[][] {
				{ 1, 2, 3 },
				{ 2, 5, 6 },
		});

		Matrix m2 = new Matrix(new int[][] {
				{ 4, 5 },
				{ 3, 2 },
				{ 1, 1 }
		});

		// the known correct result of multiplying m1 by m2
		int[][] expected = new int[][] {
				{ 13, 12 },
				{ 29, 26 }
		};

		// the result produced by the times method
		Matrix mulResult = m1.times(m2);
		int[][] resultArray = mulResult.getData();

		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}

	@Test
	void testNegativeAndPositiveTimes() {

		// the known correct result of multiplying matrix by negativeAndPositive
		int[][] expected = new int[][] {
				{ -12, -18, -24 },
				{ -21, -36, -51 }
		};

		// the result produced by the times method
		Matrix mulResult = matrix.times(negativeAndPositive);
		int[][] resultArray = mulResult.getData();

		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}

	@Test
	void testSingleTimes() {

		Matrix m1 = new Matrix(new int[][] { { 1 } });

		// the known correct result of multiplying single by 1
		int[][] expected = new int[][] {
				{ 0 }
		};

		// the result produced by the times method
		Matrix mulResult = single.times(m1);
		int[][] resultArray = mulResult.getData();

		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}

	@Test
	public void testIncompatibleTimes() {
		Matrix m1 = new Matrix(new int[][] {
				{ 1, 1, 1 },
				{ 1, 1, 1 }
		});

		Matrix m2 = new Matrix(new int[][] {
				{ 2, 2 },
				{ 2, 2 }
		});

		assertThrows(IllegalArgumentException.class, () -> {
			m1.times(m2);
		});
	}

	/* ******end times tests****** */

	/* ******plus tests****** */
	@Test
	void testNegativeAndPositivePlus() {

		Matrix m1 = new Matrix(new int[][] {
				{ 1, -1, 1 },
				{ -1, 1, -1 },
				{ 1, -1, 1 }
		});

		// the known correct result of adding negativeAndPositive by m1
		int[][] expected = new int[][] {
				{ 3, 0, 1 },
				{ -2, -1, -4 },
				{ -3, -6, -5 }
		};

		// the result produced by the plus method
		Matrix mulResult = negativeAndPositive.plus(m1);
		int[][] resultArray = mulResult.getData();

		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);

	}

	@Test
	void testSinglePlus() {

		Matrix m1 = new Matrix(new int[][] {
				{ 1 }
		});

		// the known correct result of adding single by m1
		int[][] expected = new int[][] {
				{ 1 }
		};

		// the result produced by the plus method
		Matrix mulResult = single.plus(m1);
		int[][] resultArray = mulResult.getData();

		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);

	}

	@Test
	public void testIncompatiblePlus() {
		Matrix m1 = new Matrix(new int[][] {
				{ 1, 1, 1 },
				{ 1, 1, 1 }
		});

		Matrix m2 = new Matrix(new int[][] {
				{ 2, 2 },
				{ 2, 2 }
		});

		// This is an example of how to test that an exception is thrown when needed.
		// The odd syntax below is an example of a lambda expression.
		// See Lab 1 for more info.
		assertThrows(IllegalArgumentException.class, () -> {
			m1.plus(m2);
		});
	}

	/* ******end plus tests****** */

	/* ******transpose tests****** */
	@Test
	public void testSmallTranspose() {
		Matrix m1 = new Matrix(new int[][] {
				{ 1, 1, 1 },
				{ 1, 1, 1 }
		});

		int expected[][] = {
				{ 1, 1 },
				{ 1, 1 },
				{ 1, 1 }
		};

		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();

		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}

	@Test
	public void testNegativeAndPositiveTranspose() {

		// Expected matrix when transposing negativeAndPositive
		int expected[][] = {
				{ 2, -1, -4 },
				{ 1, -2, -5 },
				{ 0, -3, -6 }
		};

		Matrix t = negativeAndPositive.transpose();
		int resultArray[][] = t.getData();

		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}

	@Test
	public void testSingleTranspose() {

		// Expected matrix when transposing single
		int expected[][] = {
				{ 0 }
		};

		Matrix t = single.transpose();
		int resultArray[][] = t.getData();

		assertEquals(expected.length, resultArray.length);
		for (int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}

	/* ******end transpose tests****** */
}
