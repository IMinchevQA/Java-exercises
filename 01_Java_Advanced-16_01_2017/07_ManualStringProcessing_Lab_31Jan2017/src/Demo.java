import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

//        String line = "carrot:orange,apple:red";
//        String[] vegetables = line. split("[,:]");
//        for (String vegetable : vegetables) {
//            System.out.println(vegetable);
//        }
//        Scanner scanner = new Scanner(System.in);

        int cnt = 1;
        StringBuilder s = new StringBuilder();
        while (cnt <= 6) {
            s.append(cnt);
            cnt++;
        }
        s.insert(3, "pass");
        System.out.println(s.toString());
        s.delete(3, 7);
        System.out.println(s.toString());
        s.reverse();
        System.out.println(s.toString());

    }
}

