import java.util.ArrayList;

public class Kasten {

    private final int xLength;
    private final int yHeight;
    private ArrayList<Kachel> kasten=new ArrayList<>();

    public Kasten(int xLength, int yHeight) {
        this.xLength=xLength;
        this.yHeight=yHeight;
        createCanvas();
        initKasten();


    }

    private void initKasten (){
        for (int i=0;i<yHeight;i++){
            for (int j=0;j<xLength;j++){
                Kachel kachel=new Kachel(j, i, 0);
                kasten.add(kachel);
            }
        }
    }

    private void createCanvas (){

    }

}
