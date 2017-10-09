package Ex08_MilitaryElite_15March2017.implementation;

import Ex08_MilitaryElite_15March2017.interfaces.Engineer;
import Ex08_MilitaryElite_15March2017.interfaces.Private;
import Ex08_MilitaryElite_15March2017.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer, Private {
    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    private void setRepairs(Collection<Repair> repairs) {
        if (repairs != null) {
            this.repairs = new ArrayList<>(repairs);
            return;
        }

        this.repairs = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append("\n");
        sb.append("Repairs:\n");
        this.getRepairs().forEach(m -> sb.append("  ").append(m).append("\n"));
        return sb.toString();
    }
}
