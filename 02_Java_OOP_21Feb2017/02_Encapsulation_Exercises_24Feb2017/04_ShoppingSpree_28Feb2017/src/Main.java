import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        String[] peopleInput = reader.readLine().split(";");
        for (String man : peopleInput) {
            String[] tokens = man.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);
            try {
                Person person = new Person(name, money);
                persons.putIfAbsent(person.getName(), person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        String[] productsInput = reader.readLine().split(";");
        for (String productItem : productsInput) {
            String[] tokens = productItem.split("=");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            try {
                Product product = new Product(name, price);
                products.putIfAbsent(product.getName(), product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        String command = "";

        while (!"END".equals(command = reader.readLine())) {

            String[] commands = command.split("\\s+");
            try {
                    persons.get(commands[0]).boughtProduct(products.get(commands[1]));
            } catch (IllegalArgumentException iaex) {
                System.out.println(iaex.getMessage());
            }

        }

        if (persons.size() != 0 && products.size() != 0) {
            persons.entrySet().stream().forEach(p -> {
                List<String> productsName = new ArrayList<>();
                if (p.getValue().getProducts().iterator().hasNext()) {
                    p.getValue().getProducts().forEach(pr -> productsName.add(pr.getName()));
                } else {
                    System.out.printf("%s - Nothing bought\n", p.getValue().getName());
                    return;
                }
                System.out.println(p.getKey() + " - " + String.join(", ", productsName));
            });
        }
    }
}

class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public Iterable<Product> getProducts() {
        return this.products;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void boughtProduct(Product product) {
        if (this.money - product.getPrice() < 0) {
            throw new IllegalArgumentException(String.format("%1s can't afford %2s", this.getName(), product.getName()));
        }

        this.money -= product.getPrice();
        this.products.add(product);
        this.printSuccessfullyBought(product);
    }

    public void printSuccessfullyBought(Product product) {
        System.out.println(this.name + " bought " + product.getName());
    }
}

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.price = price;
    }
}


/*
Input 1:
Pesho=11;Gosho=4
Bread=10;Milk=2;
Pesho Bread
Gosho Milk
Gosho Milk
Pesho Milk
END


Expected output 1:
Pesho bought Bread
Gosho bought Milk
Gosho bought Milk
Pesho can't afford Milk
Pesho - Bread
Gosho - Milk, Milk


input 2:
Mimi=0
Kafence=2
Mimi Kafence
END


Expected output 2:
Mimi can't afford Kafence
Mimi – Nothing bought

Input 3:
Jeko=-3
Chushki=1;
Jeko Chushki
END

Expected output 3:
Money cannot be negative



 */
