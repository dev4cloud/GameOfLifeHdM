package com.ibm.gol;

public class Generation {

	private boolean[][] grid;
	private int generationNumber;
	private int columns;
	private int rows;

	public int getGenerationNumber() {
		return generationNumber;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public boolean[][] getGrid() {
		return grid;
	}

	public void setGrid(boolean[][] generationGrid) {
		this.grid = generationGrid;
		this.rows = generationGrid.length;
		this.columns = generationGrid[0].length;
	}

	public void setGenerationNumber(int generation) {
		this.generationNumber = generation;
		
	}

}
