package com.ibm.gol;

public class GameConfig {

	private int columns;
	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean[][] getGrid() {
		return grid;
	}

	public void setGrid(boolean[][] grid) {
		this.grid = grid;
	}

	private int rows;
	private boolean[][] grid;

	public void setGridDimensions(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.grid = new boolean[rows][columns];
	}

	public void setAliveCell(int row, int column) {
		grid[row][column] = true;
	}

}
