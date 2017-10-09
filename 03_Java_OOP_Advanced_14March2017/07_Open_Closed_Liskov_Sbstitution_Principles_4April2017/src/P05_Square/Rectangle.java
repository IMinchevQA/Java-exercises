package P05_Square;

class Rectangle {
    private int width;
    private int height;

    public Rectangle() {

    }

    public Rectangle(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
}
