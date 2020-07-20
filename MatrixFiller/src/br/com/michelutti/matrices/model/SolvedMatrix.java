package br.com.michelutti.matrices.model;

import java.util.ArrayList;
import java.util.Random;

public class SolvedMatrix {
	private int[][] matrix;
	int cont = 0;
	boolean notSolved = true;
	
	public SolvedMatrix(ArrayList<Piece> pieces, int[][] matrix, int rows, int columns) {
		this.matrix = matrix;

		for(Piece p: pieces) {
			recursiveFill(p, rows, columns);
		}
	}
	
	public boolean verify(Piece p, int rows, int columns, int randomRow, int randomColumn) {
		boolean verify = true;
        for(int i = randomRow; i < randomRow + p.getRows(); i++) {
            if(i >= rows) {
                verify = false;
            } else {
                for(int j = randomColumn; j < randomColumn + p.getColumns(); j++) {
                    if(j >= columns) {
                        verify = false;
                    }else if( matrix[i][j] != -1) {
                    	verify = false;
                    }
                }
            }
        }
        return verify;
    }
	
    public void fill(Piece p, int randomRow, int randomColumn) {
        for(int i = randomRow; i < randomRow + p.getRows(); i++) {
            for(int j = randomColumn; j < randomColumn + p.getColumns(); j++) {
                    matrix[i][j] = p.getId();
            }
        }
       
    }
    
    public void recursiveFill(Piece p, int rows, int columns) {
		Random indexRow = new Random();
		Random indexColumns = new Random();
		
		int randomRow = indexRow.nextInt(rows);
		int randomColumn = indexColumns.nextInt(columns);
		
		if(verify(p, rows, columns, randomRow, randomColumn)) {
			fill(p, randomRow, randomColumn);
		} else {
			recursiveFill(p, rows, columns);
		}
    }

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
}
