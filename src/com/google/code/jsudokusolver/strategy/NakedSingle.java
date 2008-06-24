package com.google.code.jsudokusolver.strategy;

import com.google.code.jsudokusolver.Cell;
import com.google.code.jsudokusolver.Grid;
import com.google.code.jsudokusolver.House;
import com.google.code.jsudokusolver.SolvingStrategy;
import java.util.List;
import java.util.logging.Logger;

public class NakedSingle implements SolvingStrategy {
    private static final String NAME = "Naked Single";
    private static final Logger LOGGER = Logger.getLogger(HiddenPair.class.getCanonicalName());
    private Grid grid;
    
    public String getName() {
        return NAME;
    }
    
    public boolean solve()
    {
        if (solveHouses(grid.getRows())) {
            return true;
        }
        if (solveHouses(grid.getColumns())) {
            return true;
        }
        if (solveHouses(grid.getBoxes())) {
            return true;
        }
        return false;
    }
    
    private boolean solveHouses(List<House> houses)
    {
        for (House house : houses) {
            for (Cell cell : house.getCells()) {
                if (cell.isSolved()) {
                    continue;
                }
                if (cell.getCandidates().size() == 1) {
                    Integer candidate = (Integer) cell.getCandidates().toArray()[0];
                    cell.setDigit(candidate);
                    LOGGER.info(NAME + ": " + cell.getPosition() + " contains a naked single: " + candidate);
                    return true;
                }
            }
        }
        return false;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
