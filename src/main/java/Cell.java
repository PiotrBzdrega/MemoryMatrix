import java.awt.*;

public class Cell {

    private final int xDim;
    private final int yDim;
    private Color[] color;
    private boolean state;



    private boolean selected;

    public Cell(int xDim, int yDim) {
        this.xDim = xDim;
        this.yDim = yDim;
        this.color = new Color[2];
        this.color[0] = Color.white;
        this.color[1] = Color.red;
        this.state = false;
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }


    public void select() {
        this.selected = true;
    }

    public void deselect() {
        this.selected = false;
    }

    /**
     * enable cell
     */
    public void lightUp() {
        this.state = true;
    }

    /**
     * disable cell
     */
    public void fadeOut() {
        this.state = false;
    }

    public Color getColor(){
        return (this.state ? this.color[1] : this.color[0]);
    }

    public boolean isState() {
        return state;
    }

}
