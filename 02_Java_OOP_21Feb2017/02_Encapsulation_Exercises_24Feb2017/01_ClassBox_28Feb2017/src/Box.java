
public class Box {
    private double surfaceArea;
    private double lateralSurfaceArea;
    private double volume;

    public Box(double length, double width, double height) {
        this.setSurfaceArea(length, width, height);
        this.setLateralSurfaceArea(length, width, height);
        this.setVolume(length, width, height);
    }


    public double getSurfaceArea() {
        return this.surfaceArea;
    }

    public void setSurfaceArea(double length, double width, double height) {
        this.surfaceArea = (2 * length * height) + (2 * width * height) + (2 * length * width);
    }

    public double getLateralSurfaceArea() {
        return this.lateralSurfaceArea;
    }

    public void setLateralSurfaceArea(double length, double width, double height) {
        this.lateralSurfaceArea = (2 * length * height) + (2 * width * height);
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double length, double width, double height) {
        this.volume = length * width * height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %1.2f\nLateral Surface Area - %2.2f\nVolume - %3.2f", this.getSurfaceArea(), this.getLateralSurfaceArea(), this.getVolume());
    }


}
