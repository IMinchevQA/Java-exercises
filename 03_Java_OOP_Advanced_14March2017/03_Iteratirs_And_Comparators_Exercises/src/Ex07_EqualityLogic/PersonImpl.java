package Ex07_EqualityLogic;


public class PersonImpl implements Comparable, Person {
    private String name;
    private int age;

    public PersonImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object otherPerson) {
//        if (this == otherPerson) {
//            return true;
//        }
//
//        if (otherPerson == null || this.getClass() != otherPerson.getClass()) {
//            return false;
//        }
//
//        if (this.getAge() != ((PersonImpl)otherPerson).getAge()) {
//            return false;
//        }
//
//        if(this.name != null) {
//            return this.name.equals(((PersonImpl) otherPerson).getName());
//        }

//        return ((PersonImpl) otherPerson).getName() == null;
        return true;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
//        System.out.printf("Result w. hashed-name only: %s%n", result);
        result = (31 * result) + this.age;
//        System.out.printf("Result * 31 + age: %s%n", result);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.hashCode(), o.hashCode());
    }
}
