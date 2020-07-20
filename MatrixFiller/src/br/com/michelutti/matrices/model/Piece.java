package br.com.michelutti.matrices.model;

public class Piece {
	private int amountSlots = 0;
	private int id;
	private int rows;
	private int columns;
	public Piece(int rows, int columns, int id) {
		amountSlots = rows * columns;
		
		this.rows = rows;
		this.columns = columns;
		this.id = id;
	}
	
	public int getAmountSlots() {
		return amountSlots;
	}

	public int getId() {
		return id;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
