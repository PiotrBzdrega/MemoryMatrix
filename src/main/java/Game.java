public class Game {
    private int maxFaults=3;
    private int faults;
    private StopWatch gameTime;

    public Game(Object observer) {
        gameTime=new StopWatch(observer);
    }

    public Game(int maxFaults) {
        this.maxFaults = maxFaults;
    }

    public void fault(){
        faults+=1;

    }
    public String getTime(){
       return gameTime.toString();
    }

    public int getErrors(){
        return faults;
    }

    public void start(){
        gameTime.start();

    }

    public void stop(){

    }

}
