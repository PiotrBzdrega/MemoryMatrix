import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Grid {


    private final int xRows;
    private String  state;
    private int coveredElements;

    public ArrayList<Cell> getGrid() {
        return grid;
    }

    private ArrayList<Cell> grid=new ArrayList<>();


    // TODO
    //  verify if change state return true
    /**
     * init puzzle
     */
    public Grid(int xLength) {
        this.xRows=xLength;
        changeState("Covered");
        initGrid();
        //initializeCanvas();
    }

    //TODO
    // create here some error
    // if nextState==this.state
    private boolean changeState(String nextState){
        if(!nextState.equals(this.state))
            this.state=nextState;
        return nextState.equals(this.state) ;
    }

    /**
     * define all Cells on Grid
     */
    private void initGrid(){
        for (int i=0;i<xRows;i++){
            for (int j=0;j<xRows;j++){
                Cell cell=new Cell(j, i);
                grid.add(cell);

            }
        }
    }

    public int getxRows() {
        return xRows;
    }

    // TODO
    //  beforehand create setting window
    public void startGame(){

    }
    /**
     * create riddle to be solved w/ standard amount of marked cells
     */
    public void createPuzzle(){
            markSelected(generateRandomSet(this.coveredElements));
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

    public void changeCoveredElements(int elements){
        if (isCoveredElementQuantityValid(elements))
            this.coveredElements=elements;
        else
            error("wrong quantity of CoveredElements");
    }

    /**
     * verify if quantity of covered Elements is correct in regard to rows in puzzle
     */
    private boolean isCoveredElementQuantityValid(int elements){
        return (this.xRows * this.xRows) >= elements && elements >= 1;
    }


    /**
     * remove selection from all elements.
     */
    public void deselectAllSelected(){
        for (Integer b:getCoveredCells()){
            grid.get(b).deselect();
        }



    }

    public void reveal(){

    }


    /**
     * error template to print
     */
    private void error(String message){
        System.out.println("During execution of method: "+(new Throwable().getStackTrace()[0].getMethodName()) + ", error: \""+ message + "\" comes up.");
    }
    

}
