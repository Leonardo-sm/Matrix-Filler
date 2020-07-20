package br.com.michelutti.matrices.control;

public class MatrixController {
	
	public int[] spliter(String size) {
		String strSize[] = new String[2];
		strSize = size.split("x", 2);
		int numSize[] = new int[2];
		numSize[0] = Integer.parseInt(strSize[0]);
		numSize[1] = Integer.parseInt(strSize[1]);
		return numSize;
	}
	
	public String printMatrix(int[][] matrix, String[] affirmations) {
		String m = "";
		
		for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
	         for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
	        	 m += matrix[i][j] + " ";
	         }
	         m += "\n";
	      }
		m += "\n";
		m += affirmations[0];
		m += "\n";
		m += affirmations[1];
		m += "\n";
		m += affirmations[2];
		return m;
		
	}
	

	
}
