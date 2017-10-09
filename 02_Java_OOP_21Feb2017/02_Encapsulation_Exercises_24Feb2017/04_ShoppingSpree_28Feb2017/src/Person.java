//import java.util.ArrayList;
//import java.util.List;
//
//public class Person {
//    private String name;
//    private double money;
//    private List<Product> products;
//
//    public Person(String name, double money) {
//        this.setName(name);
//        this.setMoney(money);
//        this.products = new ArrayList<>();
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    private void setName(String name) {
//        if (name == null || name.equals("")) {
//            throw new IllegalArgumentException("Name cannot be empty");
//        }
//        this.name = name;
//    }
//
//    public Iterable<Product> getProducts() {
//        return this.products;
//    }
//
//    private void setMoney(double money) {
//        if (money < 0) {
//            throw new IllegalArgumentException("Money cannot be negative");
//        }
//        this.money = money;
//    }
//
//    public void boughtProduct(Product product) {
//        if (this.money - product.getPrice() < 0) {
//            throw new IllegalArgumentException(String.format("%1s can't afford %2s", this.getName(), product.getName()));
//        }
//
//        this.money -= product.getPrice();
//        this.products.add(product);
//        this.printSuccessfullyBought(product);
//    }
//
//    public void printSuccessfullyBought(Product product) {
//        System.out.println(this.name + " bought " + product.getName());
//    }
//}
