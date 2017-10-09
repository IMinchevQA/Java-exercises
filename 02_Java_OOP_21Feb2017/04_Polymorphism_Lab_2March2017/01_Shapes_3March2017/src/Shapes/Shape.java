//package Shapes;


public abstract class Shape {
    private double perimeter;
    private double area;

    protected Shape() {
    }

    public final double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public final double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();
}
