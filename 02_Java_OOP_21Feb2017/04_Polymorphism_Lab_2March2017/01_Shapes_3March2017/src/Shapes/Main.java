//package Shapes;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.5);
        Shape rectangle = new Rectangle(5.0, 6.0);

        List<Shape> list = new ArrayList<>();
        list.add(circle);
        list.add(rectangle);

        list.stream().forEach(s -> System.out.println(String.format("%.2f", s.getArea())));

    }
}
