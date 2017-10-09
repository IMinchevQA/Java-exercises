
public abstract class Animal {
    private String animalName;
    private double animalWeight;
    private String animalLivingRegion;
    private int foodEaten;

    public String getAnimalName() {
        return this.animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public double getAnimalWeight() {
        return this.animalWeight;
    }

    protected void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public String getAnimalLivingRegion() {
        return this.animalLivingRegion;
    }

    protected void setAnimalLivingRegion(String animalLivingRegion) {
        this.animalLivingRegion = animalLivingRegion;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected abstract void makeSound();

    protected abstract void eat(Food food);
}
