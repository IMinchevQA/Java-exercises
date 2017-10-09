package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (IllegalArgumentException iaex) {
            return iaex.getMessage();
        }
        return unitType + " retired!";
    }
}
