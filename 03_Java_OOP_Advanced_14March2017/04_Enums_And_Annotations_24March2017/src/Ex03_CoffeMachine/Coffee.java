package Ex03_CoffeMachine;

public class Coffee {

    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.size = CoffeeSize.valueOf(size.toUpperCase());
        this.type = CoffeeType.valueOf(type.toUpperCase());
    }

    public int getPrice() {
        return this.size.getPrice();
    }

    public String toString() {
        String printCoffeeSize = this.size.toString().charAt(0) + this.size.toString().substring(1).toLowerCase();
        String printCoffeeType = this.type.toString().charAt(0) + this.type.toString().substring(1).toLowerCase();
        return String.format("\"%s %s\" sold", printCoffeeSize, printCoffeeType);
    }


}
