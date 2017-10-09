package Ex08_MilitaryElite_15March2017.implementation;

import Ex08_MilitaryElite_15March2017.interfaces.Commando;
import Ex08_MilitaryElite_15March2017.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps,
                        Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions(missions);
    }



    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    private void setMissions(Collection<Mission> missions) {
        if (missions != null) {
            this.missions = new ArrayList<>(missions);
            return;
        }
        this.missions = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append("\n");
        sb.append("Missions:\n");
        this.getMissions().forEach(m -> sb.append("  ").append(m).append("\n"));
        return sb.toString();
    }
}
