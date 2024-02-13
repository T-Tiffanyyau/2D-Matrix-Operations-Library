package twoDmatrix;

/**
 * This class represents a 2D matrix and simple operations on them.
 * 
 * @author Daniel Kopta and Tiffany Yau
 * @version August 08, 2021
 *
 */

public class Matrix {

	// the dimensions of the matrix
	private int numRows;
	private int numColumns;

	// the internal storage for the matrix elements
	private int data[][];

	/**
	 * DO NOT MODIFY THIS METHOD. Constructor for a new Matrix. Automatically
	 * determines dimensions. This is implemented for you.
	 * 
	 * @param d - the raw 2D array containing the initial values for the Matrix.
	 */
	public Matrix(int d[][]) {
		// d.length is the number of 1D arrays in the 2D array
		numRows = d.length;
		if (numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array

		// create a new matrix to hold the data
		data = new int[numRows][numColumns];

		// copy the data over
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}

	/**
	 * Determines whether this Matrix is equal to another object.
	 * 
	 * @param o - the other object to compare to, which may not be a Matrix
	 */
	@Override // instruct the compiler that we intend for this method to override the
				// superclass' (Object) version
	public boolean equals(Object o) {
		// make sure the Object we're comparing to is a Matrix
		if (!(o instanceof Matrix))
			return false;

		// if the above was not true, we know it's safe to treat 'o' as a Matrix
		Matrix m = (Matrix) o;

		for (int i = 0; i < this.toString().length(); i++) {
			if (m.toString().indexOf(i) != this.toString().indexOf(i)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns a String representation of this Matrix.
	 */
	@Override // instruct the compiler that we intend for this method to override the
				// superclass' (Object) version
	public String toString() {
		String array = "";
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				array = array + data[i][j];
				if (j == numColumns - 1) {
					array += "\n";
				} else {
					array += " ";
				}
			}
		}
		return array;
	}

	/**
	 * Returns a new Matrix that is the result of multiplying this Matrix as the
	 * left hand side by the input matrix as the right hand side.
	 * 
	 * @param m - the Matrix on the right hand side of the multiplication
	 * @return - the result of the multiplication
	 * @throws IllegalArgumentException - if the input Matrix does not have
	 *                                  compatible dimensions for multiplication
	 */
	public Matrix times(Matrix m) throws IllegalArgumentException {
		if (numColumns != m.numRows) {
			throw new IllegalArgumentException();
		}

		int arr[][] = new int[numRows][m.numColumns];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < m.numColumns; j++) {
				arr[i][j] = 0;
				for (int k = 0; k < numColumns; k++) {
					arr[i][j] += data[i][k] * m.data[k][j];
				}
			}
		}

		return new Matrix(arr);
	}

	/**
	 * Returns a new Matrix that is the result of adding this Matrix as the left
	 * hand side by the input matrix as the right hand side.
	 * 
	 * @param m - the Matrix on the right hand side of the addition
	 * @return - the result of the addition
	 * @throws IllegalArgumentException - if the input Matrix does not have
	 *                                  compatible dimensions for addition
	 */
	public Matrix plus(Matrix m) throws IllegalArgumentException {
		int arr[][] = new int[numRows][numColumns];
		if (m.numColumns == this.numColumns && m.numRows == this.numRows) {
			for (int i = 0; i < numRows; i++)
				for (int j = 0; j < numColumns; j++)
					arr[i][j] += (data[i][j] + m.data[i][j]);
		} else {
			throw new IllegalArgumentException();
		}

		return new Matrix(arr);
	}

	/**
	 * Produces the transpose of this matrix.
	 * 
	 * @return - the transpose
	 */
	public Matrix transpose() {
		int transpose[][] = new int[numColumns][numRows];
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++)
				transpose[j][i] = data[i][j];
		Matrix trans = new Matrix(transpose);

		return trans;
	}

	/**
	 * DO NOT MODIFY THIS METHOD. Produces a copy of the internal 2D array
	 * representing this matrix. This method is for grading and testing purposes.
	 * 
	 * @return - the copy of the data
	 */
	public int[][] getData() {
		int[][] retVal = new int[data.length][];
		for (int i = 0; i < data.length; i++)
			retVal[i] = data[i].clone();
		return retVal;
	}
}
