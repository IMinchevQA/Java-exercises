
public class Book {
    private String author;
    private String title;
    private double price;

    public Book (String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public double getPrice() {
        return this.price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String getAuthor() {
        return this.author;
    }

    protected void setAuthor(String author) {
        if (author == null || author.length() == 0) {
            throw new IllegalArgumentException("Author not valid!");
        }

        String[] authorNames = author.trim().split("\\s+");
        if (authorNames.length > 1 && Character.isDigit(authorNames[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author.trim();
    }

    public String getTitle() {
        if (title == null || title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        return this.title;
    }

    protected void setTitle(String title) {
        if(title == null || title.trim().length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(String.format("%.1f", this.getPrice()))
                .append(System.lineSeparator());
        return sb.toString();

    }
}
