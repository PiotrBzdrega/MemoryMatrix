import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Grid {
    static final int DEFAULTROW = 5;

    private final int xRows;
    private String state;
    private int coveredElements;

    private ArrayList<Cell> cells;

    // TODO
    //  verify if change state return true

    /**
     * init puzzle
     */
    public Grid(int xLength) {
        this.xRows = IsRowsValid(xLength);
        changeCoveredElements(this.xRows);
        createGrid();
    }

    public Grid() {
        //default constructor
        this(DEFAULTROW);
    }

    private int IsRowsValid(int xLength) {
        return xLength > 1 ? xLength : DEFAULTROW;
    }

    /**
     * define all Cells on Grid
     */
    private void createGrid() {
        this.cells = new ArrayList<>();
        for (int i = 0; i < xRows * xRows; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
    }

    public int getxRows() {
        return xRows;
    }

    public Color getCellColor(int idx) {
        return cells.get(idx).getColor();
    }

    public boolean cellState(int idx) {
        return cells.get(idx).isState();
    }

    public boolean cellSelected(int idx) {
        return cells.get(idx).isSelected();
    }

    public void lightUpCell(int idx) {
        cells.get(idx).lightUp();
    }

    public void fadeOutCell(int idx) {
        cells.get(idx).fadeOut();
    }


    public void changeCoveredElements(int elements) {
        if (isCoveredElementQuantityValid(elements))
            this.coveredElements = elements;
        else {
            error("wrong quantity of CoveredElements, default value has been returned");
            changeCoveredElements(xRows);
        }
    }

    /**
     * verify if quantity of covered Elements is correct in regard to rows in puzzle
     */
    private boolean isCoveredElementQuantityValid(int elements) {
        return (this.xRows * this.xRows) >= elements && elements >= 1;
    }


    // TODO
    //  beforehand create setting window
    public void startGame() {

    }

    /**
     * create riddle to be solved w/ standard amount of marked cells
     */
    public void createPuzzle() {
        markSelected(generateRandomSet(this.coveredElements));
        changeState(true);
    }

    /**
     * generate Cell numbers in randomly
     */
    private ArrayList<Integer> generateRandomSet(int elements) {
        Random rand = new Random();
        ArrayList<Integer> sequenceList = new ArrayList<>();
        ArrayList<Integer> randSet = new ArrayList<>();
        int iter = elements;
        for (int i = 0; i < cells.size(); i++) {
            sequenceList.add(i);
        }

        while (iter > 0) {
            int selected = rand.nextInt(sequenceList.size() - 1);
            randSet.add(sequenceList.get(selected));
            sequenceList.remove(selected);
            iter--;
        }
        return randSet;
    }

    /**
     * mark selected Cells in Grid
     */
    private void markSelected(ArrayList<Integer> randSet) {
        for (Integer a : randSet) {
            cells.get(a).select();
        }
    }

    /**
     * check which Elements are covered
     */
    public ArrayList<Integer> getCoveredCells() {
        ArrayList<Integer> coveredCells = new ArrayList<>();
        for (int i = 0; i < cells.size(); i++) {
            if (cellSelected(i))
                coveredCells.add(i);
        }
        return coveredCells;
    }


    /**
     * remove selection from all elements.
     */
    public void deselectAllSelected() {
        for (Integer b : getCoveredCells()) {
            cells.get(b).deselect();
        }


    }

    public void reveal() {

    }

    //TODO
    // use command pattern
    // to use function as parametr lightUp/fadeOut
    public void changeState(boolean lightUp) {
        for (int i = 0; i < cells.size(); i++) {
            if (cellSelected(i)) {
                if (lightUp && !cellState(i))
                    lightUpCell(i);
                else if (!lightUp && cellState(i))
                    fadeOutCell(i);
            }
        }
    }

    /**
     * error template to print
     */
    private void error(String message) {
        System.out.println("During execution of method: " + (new Throwable().getStackTrace()[0].getMethodName()) + ", error: \"" + message + "\" comes up.");
    }


}
