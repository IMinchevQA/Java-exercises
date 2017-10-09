package extendedDatabase;


import database.Database;
import database.DatabaseImpl;
import extendedDatabase.ExtendedDatabase;
import extendedDatabase.ExtendedDatabaseImpl;
import extendedDatabase.Person;
import extendedDatabase.PersonImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseImplTest {
    private static final Integer[] INITIAL_VALUES_MORE_THAN_MAX_LENGTH = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static final Integer[] INITIAL_VALUES_CORRECT_LENGTH = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private static final Integer ADD_TEST_SINGLE_VALUE = 15;
    private static final Integer[] ADD_TEST_EXPECTED_VALUES_LENGTH = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static final int INITIAL_ONE_ELEMENT_TEST_REMOVE = 1;

    private static final Person INITIAL_VALUE_SINGLE_PERSON = new PersonImpl("Pesho", 1);
    private static final Person[] INITIAL_VALUES_CORRECT = {new PersonImpl("Pesho", 1), new PersonImpl("Gosho", 2), new PersonImpl("Kiro", 3) };
    private static final String FIND_PERSON_BY_USERNAME_TEST = "Gosho";
    private static final Integer FIND_PERSON_BY_ID_TEST = 1;
    public static final int FIND_NON_EXISTING_ID_TEST = 5;
    public static final String FIND_NON_EXISTING_USERNAME_TEST = "Stamat";


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void initializePersonsDatabase () throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(INITIAL_VALUE_SINGLE_PERSON);
        Assert.assertEquals("Database initialization failed!", 1, db_ex.getElements().length);
    }

    @Test(expected = NullPointerException.class)
    public void initializePersonsDatabaseWithNull() throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(null);

    }

    @Test
    public void addPersons() throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(INITIAL_VALUE_SINGLE_PERSON);
        db_ex.add(new PersonImpl("Gosho", 2));
        db_ex.add(new PersonImpl("Kiro", 3));
        Assert.assertEquals("Add method works incorrectly!", 3, db_ex.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void duplicateAddition() throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(INITIAL_VALUES_CORRECT);
        db_ex.add(new PersonImpl("Gosho", 2));
        db_ex.add(new PersonImpl("Gosho", 2));

    }

    @Test
    public void findPersonByUsername() throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(INITIAL_VALUES_CORRECT);
        Assert.assertEquals("Incorrectly working method - getUser(username)", FIND_PERSON_BY_USERNAME_TEST, db_ex.getUser(FIND_PERSON_BY_USERNAME_TEST).getUsername());
    }

    @Test
    public void findPersonById() throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(INITIAL_VALUES_CORRECT);
        Assert.assertEquals("Incorrectly working method - getUser(id)", FIND_PERSON_BY_ID_TEST, db_ex.getUser(FIND_PERSON_BY_ID_TEST).getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findNonExistingPersonById() throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(INITIAL_VALUES_CORRECT);
        db_ex.getUser(FIND_NON_EXISTING_ID_TEST);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findNonExistingPersonByUsername() throws OperationNotSupportedException {
        ExtendedDatabase db_ex = new ExtendedDatabaseImpl(INITIAL_VALUES_CORRECT);
        db_ex.getUser(FIND_NON_EXISTING_USERNAME_TEST);
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
