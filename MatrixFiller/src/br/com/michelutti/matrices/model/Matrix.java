package br.com.michelutti.matrices.model;

public class Matrix {
	private int matrix [][];
	private int maxMatrixSlots;
	private int currentMatrixSlots;
	
	public Matrix(int rows, int columns) {
		matrix = new int[rows][columns];
		maxMatrixSlots = rows * columns;
		currentMatrixSlots = maxMatrixSlots;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {	
				matrix[i][j] = -1;
			}
		}
	}
	

	public int getCurrentMatrixSlots() {
		return currentMatrixSlots;
	}


	public void setCurrentMatrixSlots(int currentMatrixSlots) {
		this.currentMatrixSlots = currentMatrixSlots;
	}


	public int getMaxMatrixSlots() {
		return maxMatrixSlots;
	}


	public int[][] getMatrix() {
		return matrix;
	}
}
