
public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }




    private double getLength() {
        return this.length;
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double getSurfaceArea() {
        return (2 * this.getLength() * this.getHeight()) + (2 * this.getWidth() * this.getHeight()) + (2 * this.getLength() * this.getWidth());
    }

    public double getLateralSurfaceArea() {
        return (2 * this.getLength() * this.getHeight()) + (2 * this.getWidth() * this.getHeight());
    }

    public double getVolume() {
        return this.getLength() * this.getWidth() * this.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %1.2f\nLateral Surface Area - %2.2f\nVolume - %3.2f", this.getSurfaceArea(), this.getLateralSurfaceArea(), this.getVolume());
    }


}
