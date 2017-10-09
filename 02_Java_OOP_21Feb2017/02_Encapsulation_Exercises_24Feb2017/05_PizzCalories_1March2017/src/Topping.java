
public class Topping {
    private String toppingType;
    private double toppingWeight;

    public Topping(String toppingName, double toppingWeight) {
        this.setToppingType(toppingName);
        this.setToppingWeight(toppingWeight);
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        String currentToppingName = toppingType.toLowerCase().trim();
        if(!currentToppingName.equals("meat") && !currentToppingName.equals("veggies") &&
           !currentToppingName.equals("cheese") && !currentToppingName.equals("sauce")) {
            throw new CE(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private double getToppingWeight() {
        return this.toppingWeight;
    }

    private void setToppingWeight(double toppingWeight) {
        if (toppingWeight < 1 || toppingWeight > 50) {
            throw new CE(String.format("%s weight should be in the range [1..50].", this.getToppingType()));
        }
        this.toppingWeight = toppingWeight;
    }

    public double CalculateToppingCalories() {
        double toppingTypeModifier =  getToppingModifier();
        return (2 * this.getToppingWeight()) * toppingTypeModifier;
    }

    private double getToppingModifier(){
        switch (this.getToppingType().toLowerCase().trim()) {
            case "meat":
                return 1.2;
            case "veggies":
                return 0.8;
            case "cheese":
                return 1.1;
            default:
                return 0.9;
        }
    }
}
