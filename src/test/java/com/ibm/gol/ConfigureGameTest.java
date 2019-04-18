package com.ibm.gol;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConfigureGameTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetupGame() {
		GameConfig gameConfig = new GameConfig();
		gameConfig.setGridDimensions(4,8);
		gameConfig.setAliveCell(1,5);
		gameConfig.setAliveCell(2,5);
		gameConfig.setAliveCell(2,4);
		
		GameController controller = new GameController(gameConfig);
		Generation gen1 = controller.getFirstGeneration();
		assertEquals(1, gen1.getGenerationNumber());
		assertEquals(4, gen1.getRows());
		assertEquals(8, gen1.getColumns());
		assertEquals(getGeneration1(), gen1.getGrid());
		Generation gen2 = controller.nextGeneration();
		assertEquals(2, gen2.getGenerationNumber());
		assertEquals(getGeneration2(), gen2.getGrid());
	}

	private boolean[][] getGeneration2() {
		boolean[][] generation1 = getGeneration1();
		generation1[1][4] = true;
		return generation1;
	}

	private boolean[][] getGeneration1() {
		boolean[][] grid = new boolean[4][8];
		grid[1][5] = true;
		grid[2][5] = true;
		grid[2][4] = true;
		
		return grid ;
	}

}
