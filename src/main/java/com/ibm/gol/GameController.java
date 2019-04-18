package com.ibm.gol;

import com.ibm.gol.logic.Grid;

public class GameController {

	private GameConfig gameConfig;
	private Grid grid;

	public GameController(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
		grid = new Grid(gameConfig.getRows(), gameConfig.getColumns());
		boolean[][] grid2 = gameConfig.getGrid();
		for (int row = 0; row < grid2.length; row++) {
			boolean[] bs = grid2[row];
			for (int column = 0; column < bs.length; column++) {
				boolean b = bs[column];
				if(b) {
					grid.setAlive(row,column);
				}
			}
		}
	}

	public Generation nextGeneration() {
		grid.nextGeneration();
		return extractGenerationFromGrid(2);
	}

	public Generation getFirstGeneration() {
		return extractGenerationFromGrid(1);
	}

	private Generation extractGenerationFromGrid(int generationNumber) {
		Generation generation = new Generation();
		boolean[][] generationGrid = new boolean[grid.getRows()][grid.getColumns()];
		for (int row = 0; row < grid.getRows(); row++) {
			for (int column = 0; column < grid.getColumns(); column++) {
				generationGrid[row][column] = grid.isCellAlive(row,column);
			}
		}
		generation.setGrid(generationGrid);
		generation.setGenerationNumber(generationNumber);
		return generation;
	}

}
