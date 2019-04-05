package com.ibm.gol;

public class Grid {

	private boolean[][] grid;

	public Grid(int rows, int columns) {
		grid = new boolean[rows][columns];
	}

	public int getColumns() {
		return grid[0].length;
	}

	public int getRows() {
		return grid.length;
	}

	public boolean isCellAlive(int row, int column) {
		return grid[row][column];
	}

	public void setAlive(int row, int column) {
		this.grid[row][column] = true;
	}

	public void killCell(int row, int column) {
		this.grid[row][column] = false;
	}

	public int countAliveNeighbours(int row, int column) {
		int aliveCount = 0;
		for (int row_grid = row-1; row_grid <= row+1; row_grid++) {
			for (int column_grid = column-1; column_grid <= column+1; column_grid++) {
				if(row_grid == row && column_grid == column) continue;
				try {
					if(grid[row_grid][column_grid]) aliveCount++;
				} catch (ArrayIndexOutOfBoundsException e) {}
			}
		}
		return aliveCount;
	}

	public void nextGeneration() {
		boolean[][] nextGeneration = new boolean[getRows()][getColumns()];
		for (int row = 0; row < getRows(); row++) {
			for (int column = 0; column < getColumns(); column++) {
				int aliveNeighbours = countAliveNeighbours(row, column);
				if(aliveNeighbours < 2)  nextGeneration[row][column] = false;
				else if(aliveNeighbours > 3) nextGeneration[row][column] = false;
				else if((aliveNeighbours == 2 || aliveNeighbours == 3) && isCellAlive(row, column) ) nextGeneration[row][column] = true;
				else if(aliveNeighbours == 3) nextGeneration[row][column] = true;
				else nextGeneration[row][column] = grid[row][column];
			}
		}
		this.grid = nextGeneration;
	}

}
