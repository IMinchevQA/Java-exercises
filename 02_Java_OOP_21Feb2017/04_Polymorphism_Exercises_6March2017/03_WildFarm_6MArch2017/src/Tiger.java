import java.text.DecimalFormat;

public class Tiger extends Felime {

    public Tiger(String animalName, Double animalWeight, String animalLivingRegion) {
        super(animalName, animalWeight, animalLivingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().toLowerCase().equals("vegetable")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getFoodQuantity());
    }

    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(), super.getAnimalName(), format.format(super.getAnimalWeight()), super.getAnimalLivingRegion(), super.getFoodEaten());
    }
}
