import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentTokens = reader.readLine().trim().split("\\s+");
        String studentFirstName = studentTokens[0];
        String studentLastName = studentTokens[1];
        String studentFacNum = studentTokens[2];

        String[] workerTokens = reader.readLine().trim().split("\\s+");
        String workerFirstName = workerTokens[0];
        String workerLastName = workerTokens[1];
        double workerSalary = Double.parseDouble(workerTokens[2]);
        double workinghours = Double.parseDouble(workerTokens[3]);

        try {
            Student student = new Student(studentFirstName, studentLastName, studentFacNum);
            Worker worker = new Worker(workerFirstName, workerLastName, workerSalary, workinghours);
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }
    }
}
