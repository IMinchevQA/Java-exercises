package database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;


public class DatabaseImpl<T extends Integer> implements Database<T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final int MINIMAL_CAPACITY = 1;
    private T[] elements;
    private Integer elementsCount;
    private int index;

    public DatabaseImpl(T...elements) throws OperationNotSupportedException {
        this.elementsCount = elements.length;
        this.setElements(elements);
        this.index = elementsCount - 1;
    }

    @Override
    public void add(T  element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
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

//    public static void main(String[] args) throws OperationNotSupportedException {
//        Database db = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
//
//        db.add(17);
//        db.add(18);
//        String debug = "";
//    }
}


