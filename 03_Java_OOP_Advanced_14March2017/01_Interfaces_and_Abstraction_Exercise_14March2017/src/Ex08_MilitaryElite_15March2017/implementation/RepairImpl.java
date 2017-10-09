package Ex08_MilitaryElite_15March2017.implementation;

import Ex08_MilitaryElite_15March2017.interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hours;

    public RepairImpl(String partName, int hours) {
        this.setPartName(partName);
        this.setHours(hours);
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public int getHours() {
        return this.hours;
    }

    private void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d" ,this.getPartName(),this.getHours());
    }


}
