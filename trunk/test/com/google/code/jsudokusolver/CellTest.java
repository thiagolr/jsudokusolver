package com.google.code.jsudokusolver;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {
    private Cell cell;
    private House row;
    private House column;
    private House box;
    private Set<Integer> candidates;

    @Before
    public void setUp() {
        row = new House(1, 0);
        column = new House(1, 0);
        box = new House(1, 0);
        candidates = new HashSet<Integer>();
        candidates.add(1);
        candidates.add(2);
        cell = new Cell(row, column, box, candidates);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCandidates method, of class Cell.
     */
    @Test
    public void testGetCandidates() {
        assertEquals(candidates, cell.getCandidates());
    }

    /**
     * Test of isSolved method, of class Cell.
     */
    @Test
    public void testIsSolved() {
        assertFalse(cell.isSolved());
    }

    /**
     * Test of hasCandidate method, of class Cell.
     */
    @Test
    public void testHasCandidate() {
        assertTrue(cell.contains(1));
    }

    /**
     * Test of removeCandidate method, of class Cell.
     */
    @Test
    public void testRemoveCandidate() {
        assertFalse(cell.remove(3));
        assertTrue(cell.remove(1));
    }

    /**
     * Test of removeCandidates method, of class Cell.
     */
    @Test
    public void testRemoveCandidates() {
        assertFalse(cell.removeAll(new HashSet<Integer>()));
        assertTrue(cell.removeAll(candidates));
    }

    /**
     * Test of getRow method, of class Cell.
     */
    @Test
    public void testGetRow() {
        assertEquals(row, cell.getRow());
    }

    /**
     * Test of getColumn method, of class Cell.
     */
    @Test
    public void testGetColumn() {
        assertEquals(column, cell.getColumn());
    }

    /**
     * Test of getBox method, of class Cell.
     */
    @Test
    public void testGetBox() {
        assertEquals(box, cell.getBox());
    }

    /**
     * Test of getDigit method, of class Cell.
     */
    @Test
    public void testGetDigit() {
        assertNull(cell.getDigit());
    }

    /**
     * Test of setDigit method, of class Cell.
     */
    @Test
    public void testSetDigit() {
        cell.setDigit(1);
        assertEquals(new Integer(1), cell.getDigit());
    }
}
