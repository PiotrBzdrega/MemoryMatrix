public class Kachel {
    private final int xDim;
    private final int yDim;
    private int color;
    private boolean state;

    public Kachel(int xDim, int yDim, int color) {
        this.xDim=xDim;
        this.yDim=yDim;
        this.color=color;
        this.state=false;
    }
    //enable object
    public void lightUp(){

        this.state= true;
    }
    //disable object
    public void fadeOut(){

        this.state= false;
    }
}
