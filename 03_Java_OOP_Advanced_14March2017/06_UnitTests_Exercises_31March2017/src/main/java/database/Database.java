package database;

import javax.naming.OperationNotSupportedException;

public interface Database<T extends Integer> {
    void add(T element) throws OperationNotSupportedException;

    void remove() throws OperationNotSupportedException;

    T[] getElements();
}
