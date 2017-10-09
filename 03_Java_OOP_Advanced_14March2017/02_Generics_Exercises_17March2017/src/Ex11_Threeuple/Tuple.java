package Ex11_Threeuple;

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

    public V get(K element) {
        return this.map.get(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry: this.map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" -> ");
            sb.append(entry.getValue().toString());
        }

        return sb.toString().trim();
    }
}
