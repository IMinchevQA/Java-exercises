import java.text.DecimalFormat;

public class Zebra extends Mammal {
    public Zebra(String animalName, Double animalWeight, String animalLivingRegion) {
        super.setAnimalName(animalName);
        super.setAnimalWeight(animalWeight);
        super.setAnimalLivingRegion(animalLivingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if(food.getClass().getSimpleName().toLowerCase().equals("meat")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getFoodQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.#######");
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(), super.getAnimalName(), format.format(super.getAnimalWeight()), super.getAnimalLivingRegion(), super.getFoodEaten());
    }
}
