package edai.tema1.ejercicio3;

import java.util.Arrays;

/**
 * Matrix class
 * @author Nicolás Calvache 2020
 *
 */
public class Matrix {
	private int[][] matrix;

	/**
	 * Constructor for the matrix class
	 * @param rc Matrix to add to the class
	 * @throws NullPointerException if the user tries to create a null matrix
	 */
	public Matrix(int[][] rc) throws NullPointerException {
		try {
			this.matrix = Arrays.stream(rc).map((int[] row) -> row.clone()).toArray((int length) -> new int[length][]);
		} catch(NullPointerException err) {
			throw new NullPointerException();
		}
	}

	/**
	 * Method to set a value in a specific position
	 * @param r row to set the value
	 * @param c column to set the value
	 * @param val value to set in matrix
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void setRC(int r, int c, int val) throws ArrayIndexOutOfBoundsException {
		int matrixLength = this.matrix.length;
		int matrixColsLength = this.matrix[0].length;

		if (r < matrixLength && matrixColsLength > c) {
			this.matrix[r][c] = val;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Method to get the value from a matrix in a specific position
	 * @param r row to get the value from
	 * @param c column to get the value from
	 * @return integer value in the position
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public int getRC(int r, int c) throws ArrayIndexOutOfBoundsException {
		try {
			return this.matrix[r][c];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw e;
		}
	}

	/**
	 * Method to sum two matrix
	 * @param right second matrix to sum
	 * @return Matrix with the added values
	 * @throws MatrixException
	 */
	public Matrix add(Matrix right) throws MatrixException {
		int mat1ColLength = this.matrix.length;
		int mat1RowLength = this.matrix[0].length;

		int mat2ColLength = right.matrix.length;
		int mat2RowLength = this.matrix[0].length;

		if (mat1ColLength == mat2ColLength && mat1RowLength == mat2RowLength) {
			int i, j;
			int[][] matrixAdd = new int[mat1ColLength][mat1RowLength];
			for (i = 0; i < mat1ColLength; i++) {
				for (j = 0; j < mat1RowLength; j++) {
					matrixAdd[i][j] = this.matrix[i][j] + right.matrix[i][j];
				}
			}
			return new Matrix(matrixAdd);
		} else {
			throw new MatrixException("Cannot add matrices of different order");
		}
	}

	/**
	 * Method to multiply two Matrix
	 * @param right Matrix to multiply
	 * @return Matrix multiplied
	 * @throws MatrixException
	 */
	public Matrix multiply(Matrix right) throws MatrixException {
		int mat1ColNum = this.matrix[0].length;
		int mat2RowNum = right.matrix.length;

		if (mat1ColNum == mat2RowNum) {
			int i, j, k, aux;
			int[][] multiplyMatrix = new int[mat2RowNum][mat1ColNum];

			for (i = 0; i < multiplyMatrix.length; i++) {
				for (j = 0; j < mat1ColNum; j++) {
					aux = 0;
					for (k = 0; k < mat1ColNum; k++) {
						aux = aux + (this.matrix[i][k] * right.matrix[k][j]);
					}
					multiplyMatrix[i][j] = aux;
				}
			}
			return new Matrix(multiplyMatrix);
		} else {
			throw new MatrixException(
					"Cannot multiply matrices if number of columns in left matrix is not equal to number of rows in right matrix");
		}
	}

	/**
	 * Method to check if two matrix are the same
	 * @param other second matrix to check the equality
	 * @return boolean specifying the equality
	 */
	public boolean equals(Matrix other) {
		return Arrays.deepEquals(this.matrix, other.matrix);
	}
}
