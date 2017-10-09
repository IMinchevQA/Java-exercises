package Ex10_Tuple;

import java.util.LinkedHashMap;
import java.util.Map;

public class Tuple<K, V> {
    private Map<K, V> map;

    public Tuple() {
        this.map = new LinkedHashMap<>();
    }

    public void put(K arg1, V arg2) {
        this.map.put(arg1, arg2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.map.entrySet().stream().forEach(e -> sb.append(String.format("%s -> %s%n", e.getKey(), e.getValue())));

        return sb.toString().trim();
    }
}
