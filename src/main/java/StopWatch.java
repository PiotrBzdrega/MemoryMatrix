import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StopWatch {

    private Unit seconds;
    private Unit minutes;

    private WatchObserver observer;

    ScheduledExecutorService executor;

    public StopWatch(Object observer) {
        this.minutes = new Unit("m",Integer.MAX_VALUE,null);
        this.seconds = new Unit("s",60,minutes);
        executor = Executors.newScheduledThreadPool(1);
        addListener(observer);
    }

    public void start(){executor.scheduleAtFixedRate(interval, 0, 1, TimeUnit.SECONDS); }

    private void addListener(Object observer){
        if (observer instanceof WatchObserver)
            this.observer= (WatchObserver) observer;
    }
    public void stop(){
        executor.shutdown();
        reset();
    }


    public void reset(){
        seconds.reset();
        minutes.reset();
    }

    @Override
    public String toString() {
        return minutes.toString()+":"+seconds.toString();
    }

    Runnable interval = ()-> {
            seconds.toIncrease();
            observer.updateTime(this.toString());
            //System.out.println(toString());
    };




}
