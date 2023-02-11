import java.awt.*;

public class Cell {

    private Color[] color;
    private boolean state;
    private boolean selected;

    public Cell() {
        this.color = new Color[]{Color.white, Color.red};
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

    public Color getColor() {
        return (this.state ? this.color[1] : this.color[0]);
    }

    public boolean isState() {
        return state;
    }

}
