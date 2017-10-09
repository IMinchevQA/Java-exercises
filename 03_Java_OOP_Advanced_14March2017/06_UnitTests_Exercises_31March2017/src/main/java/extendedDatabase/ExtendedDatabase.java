package extendedDatabase;

import javax.naming.OperationNotSupportedException;

public interface ExtendedDatabase<U, T extends Person> {



    void add(T element) throws OperationNotSupportedException;

    void remove() throws OperationNotSupportedException;

    T[] getElements();

    T getUser(U username) throws OperationNotSupportedException;


}
