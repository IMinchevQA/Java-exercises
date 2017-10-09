package Ex10_MooD;

public class Character<P> implements GameObject<P> {
    private String username;
    private String characterType;
    private int level;
    private Number specialPoints;
    private P hashedPassword;

    protected Character(String username, String characterType, int level, Number specialPoints) {
        this.setUsername(username);
        this.setCharacterType(characterType);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    private void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    @Override
    public Number getSpecialPoint() {
        return this.specialPoints;
    }

    private void setSpecialPoints(Number specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public P getHashedPassword() {
        return hashedPassword;
    }

    @Override
    public void setHashedPassword(P hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%s\" -> %s", this.getUsername(), this.getHashedPassword(), this.getCharacterType()));
        sb.append(System.lineSeparator());

        return sb.toString();
    }




}
