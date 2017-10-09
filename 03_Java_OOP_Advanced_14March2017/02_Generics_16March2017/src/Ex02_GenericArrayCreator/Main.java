package Ex02_GenericArrayCreator;

public class Main {

    public static void main(String[] args) {
        Object[] integers = ArrayCreator.create(5, 1);
        Integer[] integers1 = ArrayCreator.create(Integer.class, 6, 1);
        System.out.println(integers.length);
        System.out.println(integers1.length);
    }
}
