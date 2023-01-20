import java.awt.*;

public class Cell {
    private final int xDim;
    private final int yDim;
    private Color color;
    private boolean state, selected;


    public boolean isSelected() {
        return selected;
    }

    public Cell(int xDim, int yDim, Color color) {
        this.xDim=xDim;
        this.yDim=yDim;
        this.color=color;
        this.state=this.selected=false;
    }

    public void select(){
        this.selected=true;
    }
    public void deselect(){
        this.selected=false;
    }

    //enable object
    public void lightUp(){

        this.state= true;
    }
    //disable object
    public void fadeOut(){

        this.state= false;
    }

    public Color getColor() {
        return color;
    }
}
