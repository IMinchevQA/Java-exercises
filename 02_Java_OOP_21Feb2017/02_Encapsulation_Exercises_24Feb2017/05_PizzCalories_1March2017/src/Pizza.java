import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Minchev on 3/1/2017.
 */
public class Pizza {
    private String pizzaName;
    private Dough dough;
    private List<Topping> toppingsList;
    private int numberOfTopping;
    private double totalCalories;



    public Pizza(String pizzaName, int numberOfTopping) {
        this.setPizzaName(pizzaName);
        this.setNumberOfTopping(numberOfTopping);
        this.toppingsList = new ArrayList<>();
    }

    public String getPizzaName() {
        return this.pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        if (pizzaName == null) {
            throw new CE ("Pizza name should be between 1 and 15 symbols.");
        }

        String currentPizzaName = pizzaName.toLowerCase().trim();
        if (currentPizzaName.length() == 0 || currentPizzaName.length() > 15) {
            throw new CE ("Pizza name should be between 1 and 15 symbols.");
        }
        this.pizzaName = pizzaName;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        toppingsList.add(topping);
    }

    public int getNumberOfTopping() {
        return this.numberOfTopping;
    }

    public void setNumberOfTopping(int numberOfTopping) {
        if (numberOfTopping < 0 || numberOfTopping > 10) {
            throw new CE("Number of toppings should be in range [0..10].");
        }
        this.numberOfTopping = numberOfTopping;
    }

    public double getTotalCalories() {
        for (Topping topping : toppingsList) {
            this.setTotalCalories(this.totalCalories + topping.CalculateToppingCalories());
        }
        this.setTotalCalories(this.totalCalories + this.dough.CalculateDoughCalories());

        return this.totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getPizzaName(), this.getTotalCalories());
    }

}
