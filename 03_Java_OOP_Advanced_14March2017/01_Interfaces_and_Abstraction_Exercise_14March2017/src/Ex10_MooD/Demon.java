package Ex10_MooD;


public class Demon<P> extends Character<P> {
    private static final String CHARACTER_TYPE = "Demon";

    public Demon(String username, int level, Double energy) {
        super(username, CHARACTER_TYPE, level, energy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
                .append(this.getSpecialPoint().doubleValue() * this.getLevel());

        return sb.toString();
    }
}
