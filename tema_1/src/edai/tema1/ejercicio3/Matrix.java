package edai.tema1.ejercicio3;

import java.util.Arrays;

/**
 * Matrix class
 * 
 * @author Nicol�s Calvache 2020
 *
 */
public class Matrix {
	private int[][] matrix;

	/**
	 * Constructor for the matrix class
	 * 
	 * @param rc Matrix to add to the class
	 * @throws NullPointerException if the user tries to create a null matrix
	 */
	public Matrix(int[][] rc) throws NullPointerException {
		try {
			this.matrix = copyMatrix(rc);
		} catch (NullPointerException err) {
			throw new NullPointerException();
		}
	}

	/**
	 * Method to copy the matrix received
	 * 
	 * @param arr array to be copied
	 * @return a exact copy of the array
	 */
	public int[][] copyMatrix(int[][] arr) {
		int i, j;
		int[][] array = new int[arr.length][arr[0].length];

		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				array[i][j] = arr[i][j];
			}
		}
		return array;
	}

	/**
	 * Method to set a value in a specific position
	 * 
	 * @param r   row to set the value
	 * @param c   column to set the value
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
	 * 
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
	 * 
	 * @param right second matrix to sum
	 * @return Matrix with the added values
	 * @throws MatrixException
	 */
	public Matrix add(Matrix right) throws MatrixException {
		int mat1Length = this.matrix.length, mat1RowLength = this.matrix[0].length, i, j;

		if (mat1Length == right.matrix.length && right.matrix[0].length == mat1RowLength) {
			int[][] matrixAdd = new int[mat1Length][mat1RowLength];
			for (i = 0; i < mat1Length; i++) {
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
	 * 
	 * @param right Matrix to multiply
	 * @return Matrix multiplied
	 * @throws MatrixException
	 */
	public Matrix multiply(Matrix right) throws MatrixException {
		int mat1ColNum = this.matrix[0].length, mat2RowNum = right.matrix.length;

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
	 * 
	 * @param other second matrix to check the equality
	 * @return boolean specifying the equality
	 */
	public boolean equals(Matrix other) {
		return Arrays.deepEquals(this.matrix, other.matrix);
	}
}
