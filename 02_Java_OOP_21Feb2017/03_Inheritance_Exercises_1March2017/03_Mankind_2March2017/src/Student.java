/**
 * Created by Ivan Minchev on 3/2/2017.
 */
public class Student extends Human {
    private String facultyNumber;

    public Student (String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }

    protected void setFacultyNumber(String facultyNumber) {
        if (facultyNumber == null) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        int facultyNumberLength = facultyNumber.trim().length();
        if (facultyNumberLength < 5 || facultyNumberLength > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        char[] charsFacNum = String.valueOf(facultyNumber).toCharArray();
        for (char ch : charsFacNum) {
            if (!Character.isLetterOrDigit(ch)) {
                throw new IllegalArgumentException("Invalid faculty number!");
            }
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Faculty number: %s%n", this.getFacultyNumber()));
        return sb.toString();
    }
}
