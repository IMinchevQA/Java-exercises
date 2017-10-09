package livedemo;

import java.util.Iterator;

public class Citizen implements Iterable {
    public static final int DEFAULT_ID = 0;
    private static final String DEFAULT_CITY = "Sliven";
    private String city;

    public Citizen() {
        this.city = DEFAULT_CITY;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
