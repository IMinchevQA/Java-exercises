import com.sun.javafx.font.directwrite.RECT;

public class Rectangle {

    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(double a) {
        this.a = a;
    }

    public double perimeter() {
        return 2* this.a + 2 * this.b;
    }

    protected double getA() {
        return this.a;
    }

    public double area() {
        return this.a * this.b;
    }

}
