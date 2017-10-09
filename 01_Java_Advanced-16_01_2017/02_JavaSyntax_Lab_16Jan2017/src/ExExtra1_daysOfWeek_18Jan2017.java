import java.util.Locale;

public class ExExtra1_daysOfWeek_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        String[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        for(String day : daysOfWeek){
            System.out.println(day);
        }

    }
}
