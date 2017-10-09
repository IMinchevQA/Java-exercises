package Ex10_InfernoInfinity.interfaces;

public interface Weapon extends Comparable<Weapon> {
    void addGem(Gem gem, int index);
    void removeGem(int index);
    String getName();
    double calculateLevel();
}
