
public class Main {
    public static void main(String[] args) {
//        Animal animal = new Animal();
        Predator predator = new Predator();
        predator.feedAll (new Food[]{ new Food(), new Food() });
        predator.feed(new Food());
        System.out.println(predator.getHealth() );
    }
}
