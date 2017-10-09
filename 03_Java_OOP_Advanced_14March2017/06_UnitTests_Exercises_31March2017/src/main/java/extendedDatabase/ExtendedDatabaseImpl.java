package extendedDatabase;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;


public class ExtendedDatabaseImpl<U, T extends Person> implements ExtendedDatabase<U, T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final int MINIMAL_CAPACITY = 1;
    private T[] elements;
    private Integer elementsCount;
    private int index;

    public ExtendedDatabaseImpl(T...elements) throws OperationNotSupportedException {
        this.elementsCount = elements.length;
        this.setElements(elements);
        this.index = elementsCount - 1;
    }

    @Override
    public void add(T  element) throws OperationNotSupportedException {
        if (element == null || !element.getClass().getSimpleName().equals("PersonImpl")) {
            throw new OperationNotSupportedException();
        }

        Person currentPerson = Person.class.cast(element);

//        T[] resultArray = (T[]) Stream.of(this.elements)
//                .filter(e -> e != null)
//                .filter(p -> p.getUsername().equals(currentPerson.getUsername()))
//                .toArray();
//        String debug = "";

        for (int i = 0; i <= this.index; i++) {
            if (this.elements[i].getUsername().equals(currentPerson.getUsername()) ||
                    this.elements[i].getId().equals(currentPerson.getId())) {
                throw new OperationNotSupportedException();
            }
        }

        this.elements[++index] = element;
        this.elementsCount = ++this.elementsCount;
    }


    @Override
    public void remove() throws OperationNotSupportedException {
        try {
            this.elements[index--] = null;
            this.elementsCount--;

        } catch (ArrayIndexOutOfBoundsException aiobex) {
            throw new OperationNotSupportedException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] getElements() {
        Field array = null;
        try {
            array = this.getClass().getDeclaredField("elements");
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        }

        Class integerClass = array.getType().getComponentType();//It returns the Integer class

        T[] buffer = (T[]) Array.newInstance(integerClass, this.elementsCount);
        int bufferIndex = 0;

        for (T element : this.elements) {
            if (element != null) {
                buffer[bufferIndex++] = element;
            }
        }
        return buffer;
    }

    private void setElements(T... elementsInput) throws OperationNotSupportedException {

        if (elementsInput.length > INITIAL_CAPACITY || elementsInput.length < MINIMAL_CAPACITY) {
            throw new OperationNotSupportedException();
        }

        Object values = Array.newInstance(elementsInput.getClass(), INITIAL_CAPACITY);

        //With elementsInput[0].getClass() in the next row we take the the class of an single inputElement
        //WHY? If we take elementsInput.getClass() in result this.elements becomes Integer[][]
        //More info in Java OOP Advanced video from 31 March 2017 with lecturer Ivan Ivanov.
        this.elements =  (T[]) Array.newInstance(elementsInput[0].getClass(), INITIAL_CAPACITY);
        int bufferIndex = 0;

        for (T element : elementsInput) {
            this.elements[bufferIndex++] = element;
        }

        this.index = elementsInput.length - 1;
    }

    public T getUser(U username) throws OperationNotSupportedException {
        if (username == null || (!username.getClass().equals(Integer.class) && !username.getClass().equals(String.class))) {
            throw new OperationNotSupportedException();
        }

        String className = username.getClass().getSimpleName();
        T searchedPerson = null;

        switch (className) {
            case "String":
                for (int i = 0; i <= this.index; i++) {
                    if (this.elements[i].getUsername().equals(username)){
                        searchedPerson = this.elements[i];
                        break;
                    }
                }
                break;
            case "Integer":
                for (int i = 0; i <= this.index; i++) {
                    if (this.elements[i].getId() == username){
                        searchedPerson = this.elements[i];
                        break;
                    }
                }
                break;
        }

        String debug = "";



        if (searchedPerson == null) {
            throw new OperationNotSupportedException();
        }
        return searchedPerson;
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        ExtendedDatabase db = new ExtendedDatabaseImpl<>(new PersonImpl("Pesho", 1)); // (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        db.add(new PersonImpl("Gosho", 2)); //OK
//        db.add(new PersonImpl("Pesho", 3)); //NOK
//        db.add(new PersonImpl("Sasho", 1)); //NOK
        db.add(new PersonImpl("Kiro", 3));
        System.out.println(db.getUser("Kiro").getUsername()); // OK
        System.out.println(db.getUser(1).getUsername()); // OK
        System.out.println(db.getUser("6060").getUsername()); // Exception


        String debug = "";
    }
}


