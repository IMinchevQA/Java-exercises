package database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseImplTest {
    private static final Integer[] INITIAL_VALUES_MORE_THAN_MAX_LENGTH = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static final Integer[] INITIAL_VALUES_CORRECT_LENGTH = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    private static final Integer ADD_TEST_SINGLE_VALUE = 15;
    private static final Integer[] ADD_TEST_EXPECTED_VALUES_LENGTH = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static final int INITIAL_ONE_ELEMENT_TEST_REMOVE = 1;


    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeDatabaseWithZeroLength() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeDatabaseWithMoreThanMaxLength() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES_MORE_THAN_MAX_LENGTH);
    }

    @Test
    public void initializeDatabaseWithCorrectLength() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES_CORRECT_LENGTH);
    }

    @Test
    public void getElementsWithCorrectValuesLength() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES_CORRECT_LENGTH);
        Assert.assertArrayEquals("Incorrect get elements method. ", INITIAL_VALUES_CORRECT_LENGTH, db.getElements());
    }

    @Test
    public void testAddWithCorrectInput() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES_CORRECT_LENGTH);
        db.add(ADD_TEST_SINGLE_VALUE);
        Assert.assertArrayEquals("Incorrect add method!", ADD_TEST_EXPECTED_VALUES_LENGTH, db.getElements());
    }

    @Test
    public void removeElement() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_ONE_ELEMENT_TEST_REMOVE);
        db.add(ADD_TEST_SINGLE_VALUE);
        db.remove();
        Assert.assertEquals("Remove does not work correctly!", 1, db.getElements().length);
    }

    @Test
    public void removeElementWithNoElements() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_ONE_ELEMENT_TEST_REMOVE);
        db.remove();
        Assert.assertEquals("Remove does not work correctly!", 0, db.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void emptyCollectionRemoveInvoike() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_ONE_ELEMENT_TEST_REMOVE);
        db.remove();
        db.remove();
    }

}
