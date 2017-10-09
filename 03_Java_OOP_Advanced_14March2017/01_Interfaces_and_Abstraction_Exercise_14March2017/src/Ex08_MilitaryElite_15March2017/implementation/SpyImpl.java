package Ex08_MilitaryElite_15March2017.implementation;

import Ex08_MilitaryElite_15March2017.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private int codeNumber;

    public SpyImpl(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    private void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
                .append(System.lineSeparator())
                .append("Code Number: ")
                .append(this.getCodeNumber());
        return sb.toString();
    }
}
