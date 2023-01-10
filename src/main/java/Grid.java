import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Grid {

    private final int xRows;
    private int coveredElements;
    private ArrayList<Cell> grid=new ArrayList<>();

    /**
     * init puzzle
     */
    public Grid(int xLength) {
        this.xRows=xLength;
        coveredElements=xLength;
        initGrid();
        createPuzzle();
        createCanvas();
    }

    /**
     * define all Cells on Grid
     */
    private void initGrid(){
        for (int i=0;i<xRows;i++){
            for (int j=0;j<xRows;j++){
                Cell cell=new Cell(j, i, 0);
                grid.add(cell);
            }
        }
    }

    /**
     * create canvas
     */
    private void createCanvas (){

    }

    /**
     * create riddle to be solve w/ standard amount of marked cells
     */
    public void createPuzzle(){
        markSelected(generateRandomSet(this.coveredElements));
    }

    /**
     * create riddle to be solve w/ new amount of marked cells
     */
    public void createPuzzle(int markedElements){
        this.coveredElements=markedElements;
        createPuzzle();
    }

    /**
     * generate Cell numbers in randomly
     */
    private ArrayList<Integer> generateRandomSet(int elements){
        Random rand=new Random();
        ArrayList<Integer> sequenceList=new ArrayList<>();
        ArrayList<Integer> randSet= new ArrayList<>();
        int iter=elements;
        for (int i=0; i< grid.size(); i++){
            sequenceList.add(i);
        }

        while (iter>0){
            int selected =rand.nextInt(sequenceList.size()-1);
            randSet.add(sequenceList.get(selected));
            sequenceList.remove(selected);
            iter--;
        }
        return randSet;
    }

    /**
     * mark selected Cells in Grid
     */
    private void markSelected(ArrayList<Integer> randSet){
        for (Integer a:randSet){
            grid.get(a).select();
        }
    }

    /**
     * check which Elements are covered
     */
    public ArrayList<Integer> getCoveredCells(){
        ArrayList<Integer> coveredCells= new ArrayList<>();
        for (int i=0;i< grid.size();i++){
            if (grid.get(i).isSelected())
                coveredCells.add(i);
        }
        return coveredCells;
    }

    /**
     * remove selection from all elements.
     */
    public void deselectAllSelected(){
        for (Integer b:getCoveredCells()){
            grid.get(b).deselect();
        }
    }
    

}
