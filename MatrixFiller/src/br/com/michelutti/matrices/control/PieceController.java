package br.com.michelutti.matrices.control;

import java.util.ArrayList;

import br.com.michelutti.matrices.model.Piece;

public class PieceController {
	private int id = 1;
	

	public int idGenerator(ArrayList<Piece> pieces, int row, int column) {
		try {
			for(Piece p: pieces) {
				if(p.getRows() == row && p.getColumns() == column) {
					return p.getId();
				}
			}
			return id++;
		} catch(Exception e) {
			id++;
			return id;
		}
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
