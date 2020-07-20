package br.com.michelutti.matrices.control;

import java.util.Random;

public class AffirmationsController {
	int[] pieces;
	int[] directions;
	String[] initWord;
	String[] endWord;
	String[] affirmations;
	String direct = "";
	int[][] matrix;
	int cont = 0;
	
	public AffirmationsController(int[][] matrix, int rows, int columns) {
		this.matrix = matrix;
		directions = new int[4];
		initWord = new String[2];
		endWord = new String[2];
		affirmations = new String[3];
		pieces = new int[2];
		
		directions[0] = 0; //top
		directions[1] = 1; // left
		directions[2] = 2; // down
		directions[3] = 3; // right
		
		initWord[0] = "A pe�a";
		initWord[1] = "Uma pe�a";
		
		endWord[0] = "da pe�a";
		endWord[1] = "de uma pe�a";
		
		
		recursiveFill(rows, columns);
	}
		
	public void builder(int[] pieces) {
		Random indexBuilder = new Random();
		
		int randomInitWord = indexBuilder.nextInt(2);
		int randomEndWord = indexBuilder.nextInt(2);
		
		this.affirmations[cont] = initWord[randomInitWord] + " de ID " + pieces[1] + " est� " + direct + " " + endWord[randomEndWord] + " de ID " + pieces[0];
		cont++;
	}
	
	public void recursiveFill(int rows, int columns) {
		Random indexRow = new Random();
		Random indexColumns = new Random();
		Random indexDirection = new Random();
		
		int randomRow = indexRow.nextInt(rows);
		int randomColumn = indexColumns.nextInt(columns);
		int randomDirection = indexDirection.nextInt(4); 
		
		int id = matrix[randomRow][randomColumn];
		pieces[0] = id;
		
		try {
			
			switch(randomDirection) {
			case 0:
				//top
				randomRow--;
				if(id != matrix[randomRow][randomColumn]) {
					pieces[1] = matrix[randomRow][randomColumn];
					direct = "acima";
					builder(pieces);
				} else {
					recursiveFill(rows, columns);
				}
				break;
				
			case 1:
				//left
				randomColumn--;
				if(id != matrix[randomRow][randomColumn]) {
					pieces[1] = matrix[randomRow][randomColumn];
					direct = "� esquerda";
					builder(pieces);
				} else {
					recursiveFill(rows, columns);
				}
				break;
				
			case 2:
				//down
				randomRow++;
				if(id != matrix[randomRow][randomColumn]) {
					pieces[1] = matrix[randomRow][randomColumn];
					direct = "abaixo";
					builder(pieces);
				} else {
					recursiveFill(rows, columns);
				}
				break;
				
			case 3:
				//right
				randomColumn++;
				if(id != matrix[randomRow][randomColumn]) {
					pieces[1] = matrix[randomRow][randomColumn];
					direct = "� direita";
					builder(pieces);
				}
				break;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			recursiveFill(rows, columns);
		}
	
		if(cont < 3) {
			recursiveFill(rows, columns);
		}
	}
		
	public String[] getAffirmations() {
		return affirmations;
	}
}
