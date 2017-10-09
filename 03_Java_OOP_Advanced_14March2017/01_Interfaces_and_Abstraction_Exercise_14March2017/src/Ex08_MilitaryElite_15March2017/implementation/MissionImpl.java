package Ex08_MilitaryElite_15March2017.implementation;

import Ex08_MilitaryElite_15March2017.interfaces.Mission;

public class MissionImpl implements Mission {
    public static final String MISSION_FINISHED_STATUS = "Finished";
    public static final String MISSION_IN_PROGRESS_STATUS = "inProgress";
    private String codeName;
    private String state;

    public MissionImpl (String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    private void setState(String state) {
        if (MISSION_IN_PROGRESS_STATUS.equals(state) || MISSION_FINISHED_STATUS.equals(state)) {
            this.state = state;
        }
    }

    @Override
    public void completeMission() {
        this.setState(MISSION_FINISHED_STATUS);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}