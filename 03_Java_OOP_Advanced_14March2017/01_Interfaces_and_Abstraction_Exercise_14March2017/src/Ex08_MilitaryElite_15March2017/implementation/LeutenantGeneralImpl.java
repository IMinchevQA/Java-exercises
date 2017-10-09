package Ex08_MilitaryElite_15March2017.implementation;

import Ex08_MilitaryElite_15March2017.interfaces.LeutenantGeneral;
import Ex08_MilitaryElite_15March2017.interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Collection<Private> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.setPrivates(privates);
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    private void setPrivates(Collection<Private> privates) {
        if (privates != null) {
            this.privates = new ArrayList<>(privates);
            return;
        }

        this.privates = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append("\n");
        sb.append("Privates:\n");
        this.getPrivates().forEach(m -> sb.append("  ").append(m).append("\n"));
        return sb.toString();
    }
}
