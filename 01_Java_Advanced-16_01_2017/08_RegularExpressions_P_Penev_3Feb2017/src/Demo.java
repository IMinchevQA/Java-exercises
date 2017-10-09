import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("a");
        Matcher matcher = pattern.matcher("aaab");
        Matcher matcher1 = pattern.matcher("aaab");
        Matcher matcher2 = pattern.matcher("bbbc");
        System.out.println(matcher1.find()); // true
        System.out.println(matcher2.find()); // false

        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }

    }
}
