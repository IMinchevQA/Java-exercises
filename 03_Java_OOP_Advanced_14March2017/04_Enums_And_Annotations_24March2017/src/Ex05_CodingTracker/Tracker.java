package Ex05_CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Tracker {

    @Author(name = "Pesho")
    public static void printMethodsByAuthor() {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Class<?> trackerClass = Tracker.class;
        Method[] trackerMethods = trackerClass.getDeclaredMethods();

        Stream.of(trackerMethods).filter(m -> m.getAnnotation(Author.class) != null)
                .forEach(a -> {
                    methodsByAuthor.putIfAbsent(a.getAnnotation(Author.class).name(), new ArrayList<>());
                    methodsByAuthor.get(a.getAnnotation(Author.class).name()).add(a.getName());
                });

        methodsByAuthor.keySet().stream().forEach(a -> {
            System.out.printf("%s: %s%n", a, String.join(", ", methodsByAuthor.get(a)));
        });
    }
}
