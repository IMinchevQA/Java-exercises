/**
 * Created by Ivan Minchev on 3/5/2017.
 */
public class Square extends Rectangle {


    public Square(double a) {
        super(a);
    }

    //Overload
    public double perimeter() {
        return 4 * this.getA();
    }

    @Override
    public double area() {
        return this.getA() * this.getA();
    }
}
