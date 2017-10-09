package Ex10_MooD;


public interface GameObject<P> {
    String getUsername();
    String getCharacterType();
    Number getSpecialPoint();
    int getLevel();

    P getHashedPassword();

    void setHashedPassword(P hashedPassword);

}
