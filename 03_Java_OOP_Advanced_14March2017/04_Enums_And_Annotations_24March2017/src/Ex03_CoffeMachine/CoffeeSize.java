package Ex03_CoffeMachine;

public enum CoffeeSize {
    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int ml;
    private int c;

    CoffeeSize(int ml, int c) {
        this.ml = ml;
        this.c = c;
    }

    public int getMl() {
        return this.ml;
    }

    public int getPrice() {
        return this.c;
    }
}
