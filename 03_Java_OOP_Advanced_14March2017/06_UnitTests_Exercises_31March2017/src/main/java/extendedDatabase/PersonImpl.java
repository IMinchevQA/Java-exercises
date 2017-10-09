package extendedDatabase;

public class PersonImpl implements Person {

    private String userName;
    private Integer id;

    public PersonImpl(String userName, Integer id) {
        this.userName = userName;
        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
