package com.ibm.gol;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridTest {

	private Grid grid;

	@Before
	public void setUp() throws Exception {
		grid = new Grid(4, 8);
	}
	
	@Test
	public void testCreateGrid() throws Exception {
		assertEquals(8, grid.getColumns());
		assertEquals(4, grid.getRows());
	}
	
	@Test
	public void testDeadCells() throws Exception {
		assertFalse(grid.isCellAlive(1,1));
	}
	
	@Test
	public void testAliveCells() throws Exception {
		grid.setAlive(1,1);
		assertTrue(grid.isCellAlive(1,1));
	}
	
	@Test
	public void testKillCell() throws Exception {
		grid.setAlive(1, 1);
		assertTrue(grid.isCellAlive(1,1));
		grid.killCell(1,1);
		assertFalse(grid.isCellAlive(1,1));
	}
	
	@Test
	public void testNewDimensions() throws Exception {
		Grid grid2 = new Grid(1,1);
		assertEquals(1, grid2.getRows());
		assertEquals(1, grid2.getColumns());
	}

}
