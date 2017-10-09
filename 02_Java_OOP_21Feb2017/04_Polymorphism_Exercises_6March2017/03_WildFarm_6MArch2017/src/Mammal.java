/**
 * Created by Ivan Minchev on 3/6/2017.
 */
public abstract class Mammal extends Animal {
    String livingRegion;

    @Override
    protected abstract void makeSound();

    @Override
    protected abstract void eat(Food food);
}
