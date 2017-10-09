package Ex03_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(5 ,6);
        Scale<String> scale1 = new Scale<> ("a", "b");
        System.out.println(scale.getHeavier());
        System.out.println(scale1.getHeavier());
    }
}
