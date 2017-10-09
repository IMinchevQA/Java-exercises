package Ex10_InfernoInfinity.implementations;

import Ex10_InfernoInfinity.interfaces.Gem;
import Ex10_InfernoInfinity.interfaces.Weapon;

public abstract class WeaponImpl implements Weapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int strength;
    private int agility;
    private int vitality;
    private Gem[] gemsSockets;

    public WeaponImpl(String name, int minDamage, int maxDamage, int socketsCount) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.setGemsSockets(socketsCount);
    }

    @Override
    public void addGem(Gem gem, int socketIndex) {
        if (isIndexValidCheck(socketIndex)) {
            this.removeStats(socketIndex);
            this.gemsSockets[socketIndex] = gem;
            this.addStats(gem);
        }
    }

    @Override
    public void removeGem(int index) {
        if (isIndexValidCheck(index)) {
            this.removeStats(index);
            this.gemsSockets[index] = null;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double calculateLevel() {
        return (this.minDamage + this.maxDamage) / 2.0 + this.strength + this.agility + this.vitality;
    }

    @Override
    public int compareTo(Weapon other) {
        return Double.compare(this.calculateLevel(), other.calculateLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)",
                this.name,
                this.minDamage,
                this.maxDamage,
                this.strength,
                this.agility,
                this.vitality,
                this.calculateLevel());
    }

    private void addStats(Gem gem) {
        this.strength += gem.getBonusStrength();
        this.minDamage += 2 * gem.getBonusStrength();
        this.maxDamage += 3 * gem.getBonusStrength();

        this.agility += gem.getBonusAgility();
        this.minDamage += gem.getBonusAgility();
        this.maxDamage += 4 * gem.getBonusAgility();

        this.vitality += gem.getBonusVitality();
    }

    private void removeStats(int index) {
        if (this.gemsSockets[index] == null) {
            return;
        }

        Gem gem = this.gemsSockets[index];
        this.strength -= gem.getBonusStrength();
        this.minDamage -= 2 * gem.getBonusStrength();
        this.maxDamage -= 3 * gem.getBonusStrength();

        this.agility -= gem.getBonusAgility();
        this.minDamage -= gem.getBonusAgility();
        this.maxDamage -= 4 * gem.getBonusAgility();

        this.vitality -= gem.getBonusVitality();
    }

    private void setGemsSockets(int socketsCount) {
        this.gemsSockets = new Gem[socketsCount];
    }

    private boolean isIndexValidCheck(int socketIndex) {
        return socketIndex >= 0 && socketIndex < this.gemsSockets.length;
    }
}
