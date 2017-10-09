package P05_Square;

public class Square extends Rectangle {

    public Square(int width, int height) {
        this.validate(width, height);
        super.setWidth(width);
        super.setHeight(height);
    }

    public Square(int side) {
        this(side, side);
    }


    private void validate(int width, int height) {
        if (width != height) {
            throw new IllegalArgumentException("Square cannot be with different sides.");
        }
    }
}
