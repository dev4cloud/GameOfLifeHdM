package com.ibm.gol;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeRuleTest {

	private Grid grid;

	@Before
	public void setUp() throws Exception {
		grid = new Grid(4,8);
	}
	
	@Test
	public void testCountNeighbours() throws Exception {
		grid.setAlive(0, 1);
		assertEquals(1,grid.countAliveNeighbours(0,0));
	}

	@Test
	public void testRule1() {
		grid.setAlive(0, 1);
		grid.nextGeneration();
		assertFalse(grid.isCellAlive(0, 1));
	}
	
	@Test
	public void testRule2() throws Exception {
		grid.setAlive(1, 0);
		grid.setAlive(1, 1);
		grid.setAlive(1, 2);
		grid.setAlive(0, 0);
		grid.setAlive(0, 1);

		grid.nextGeneration();
		assertTrue(grid.isCellAlive(0, 0));
		assertFalse(grid.isCellAlive(0, 1));
		assertFalse(grid.isCellAlive(1, 1));
	}
	
	@Test
	public void testRule3() throws Exception {
		grid.setAlive(1, 5);
		grid.setAlive(2, 4);
		grid.setAlive(2, 5);
		grid.nextGeneration();
		assertTrue(grid.isCellAlive(1, 5));
		assertTrue(grid.isCellAlive(2, 4));
		assertTrue(grid.isCellAlive(2, 5));
	}

	@Test
	public void testRule4() throws Exception {
		grid.setAlive(1, 5);
		grid.setAlive(2, 4);
		grid.setAlive(2, 5);
		grid.nextGeneration();
		assertTrue(grid.isCellAlive(1, 5));
		assertTrue(grid.isCellAlive(2, 4));
		assertTrue(grid.isCellAlive(2, 5));
		assertTrue(grid.isCellAlive(1, 4));
	}
}
