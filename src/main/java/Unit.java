public class Unit {
    private String unit;
    final private int range;
    private int amount;

    private boolean manager;
    private Unit supervisor;

    public Unit(String unit, int range) {
        this.unit = unit;
        this.range = range;
        reset();
    }

    public Unit(String unit, int range, Unit supervisor) {
        this(unit, range);
        this.supervisor=supervisor;
        this.manager=this.supervisor==null;
    }

    public void toIncrease(){
        amount+=1;
        if (overflow()) {
            supervisor.toIncrease();
            reset();
        }

    }
    public int getAmount() { return amount;}

    private boolean overflow() {return getAmount()>=this.range;}
    public void reset(){amount=0;}

    @Override
    public String toString() {
        String prefix= !manager && getAmount()<10 ? "0"+amount: String.valueOf(amount);

        return prefix;//+" "+unit;
    }
}
