package Ex06_StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());

        if (result != 0) {
            return result;
        }

        char person1FirstLetterInName = Character.toLowerCase(o1.getName().charAt(0));
        char person2FirstLetterInName = Character.toLowerCase(o2.getName().charAt(0));

//        System.out.println(Character.compare(person1FirstLetterInName, person2FirstLetterInName));
        return Character.compare(person1FirstLetterInName, person2FirstLetterInName);
    }


}
