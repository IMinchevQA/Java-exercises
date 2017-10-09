package Ex10_InfernoInfinity.implementations;

import Ex10_InfernoInfinity.interfaces.Gem;

public abstract class GemImpl implements Gem {
    private int bonusStrength;
    private int bonusAgility;
    private int bonusVitality;

    public GemImpl(int bonusStrength, int bonusAgility, int bonusVitality) {
        this.bonusStrength = bonusStrength;
        this.bonusAgility = bonusAgility;
        this.bonusVitality = bonusVitality;
    }

    @Override
    public int getBonusStrength() {
        return this.bonusStrength;
    }

    @Override
    public int getBonusAgility() {
        return this.bonusAgility;
    }

    @Override
    public int getBonusVitality() {
        return this.bonusVitality;
    }
}
