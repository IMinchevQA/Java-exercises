import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat (String animalName, double animalWeight, String animalLivingRegion, String breed) {
        super(animalName, animalWeight, animalLivingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getFoodQuantity());
    }

    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(), super.getAnimalName(), this.breed, format.format(super.getAnimalWeight()), super.getAnimalLivingRegion(), super.getFoodEaten());
    }
}
