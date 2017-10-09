package Ex10_MooD;

public class Archangel<P> extends Character<P> {
    private static final String CHARACTER_TYPE = "Archangel";

    public Archangel(String username, int level, Integer mana) {
        super(username, CHARACTER_TYPE, level, mana);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
                .append(this.getSpecialPoint().intValue() * this.getLevel());

        return sb.toString();
    }
}
