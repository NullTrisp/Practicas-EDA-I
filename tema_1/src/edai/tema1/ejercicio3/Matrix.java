package edai.tema1.ejercicio3;

/**
 * 
 * @author Nicolás Calvache 2020
 *
 */
public class Matrix {
	private int[][] matrix;

	/**
	 * 
	 * @param rc
	 * @throws NullPointerException
	 */
	public Matrix(int[][] rc) throws NullPointerException {
		if (rc == null) {
			throw new NullPointerException();
		}
		{
			this.matrix = rc;
		}
	}

	/**
	 * 
	 * @param r
	 * @param c
	 * @param val
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void setRC(int r, int c, int val) throws ArrayIndexOutOfBoundsException {
		int matrixLength = this.matrix.length;
		int matrixColsLength = this.matrix[0].length;
		int i, j;

		if (r < matrixLength && matrixColsLength > c) {
			for (i = 0; i < matrixLength; i++) {
				for (j = 0; j < this.matrix[i].length; j++) {
					if (r == i) {
						if (c == j) {
							this.matrix[i][j] = val;
						}
					}
				}
			}
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * 
	 * @param r
	 * @param c
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public int getRC(int r, int c) throws ArrayIndexOutOfBoundsException {
		try {
			return this.matrix[r][c];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw e;
		}
	}

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
	 * 
	 * @param right
	 * @return
	 * @throws MatrixException
	 */
	public Matrix multiply(Matrix right) throws MatrixException {
		int mat1ColLength = this.matrix.length;
		int mat1RowLength = this.matrix[0].length;

		int mat2ColLength = right.matrix.length;
		int mat2RowLength = this.matrix[0].length;

		if (mat1ColLength == mat2ColLength && mat1RowLength == mat2RowLength) {
			int i, j, k, aux;
			int[][] multiplyMatrix = new int[mat1ColLength][mat1RowLength];

			for (i = 0; i < mat1ColLength; i++) {
				for (j = 0; j < mat1RowLength; j++) {
					aux = 0;
					for (k = 0; k < mat1RowLength; k++) {
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
	 * 
	 * @param other
	 * @return
	 */
	public boolean equals(Matrix other) {
		int mat1ColLength = this.matrix.length;
		int i, j;

		boolean sameMatrix = true;

		for (i = 0; i < mat1ColLength; i++) {
			for (j = 0; j < mat1ColLength; j++) {
				if (this.matrix[i][j] != other.matrix[i][j]) {
					sameMatrix = false;
					break;
				}
			}
		}
		return sameMatrix;
	}
}
