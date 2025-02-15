abstract class Animal {
    private final int id;
    private final double height;
    private Supervisor sup;
    private static int amount = 0;


    public Animal(double height) {
        this.id = NewAnId();
        this.height = height;
    }

    public void setSup(Supervisor supervisor) {
        this.sup = supervisor;
    }

    public int getAnId() {
        return id;
    }

    public double getH() {
        return height;
    }

    public Supervisor getSup() {
        return sup;
    }

    public abstract String getType();

    private int NewAnId() {
        return ++amount;
    }

    public abstract boolean CanMakeSound();
}