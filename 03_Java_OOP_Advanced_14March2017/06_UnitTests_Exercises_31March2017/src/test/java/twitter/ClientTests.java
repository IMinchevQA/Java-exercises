package twitter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

public class ClientTests {

    private static final int MESSAGE_LENGTH_EMPTY_SIZE = 0;
    private static final String THIS_IS_A_TEST = "This is a test!";
    //Mocking
    private Tweet tweet;

    @Before
    public void init() {
        this.tweet = Mockito.mock(Tweet.class);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void microwaveShouldImplementsClientInterface() {
        Class<? extends Client> microwave = MicrowaveOven.class;
        Class<?>[] interfaces = microwave.getInterfaces();
        Class<Client> clientClass = null;
        for (Class currentInterface : interfaces) {
            if (currentInterface.getSimpleName().equals("Client")) {
                clientClass = currentInterface;
                break;
            }
        }
        Assert.assertSame("Client Interface is implemented incorrectly!", Client.class, clientClass);
    }

    @Test
    public void retrieveMessagesShouldPrintRandomMessage() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(stream));
//        System.out.println("pesho"); // Test
        Tweet tweet = new Message();
        Client client = new MicrowaveOven(new ServerImpl());
        client.receive(tweet);
        int size = stream.size();
//        int size1 = stream.toString().length();
        Assert.assertNotEquals("Retrieve message works incorrectly!", MESSAGE_LENGTH_EMPTY_SIZE, size);
    }

    @Test
    public void retrieveMessagesShouldPrintExactMessage() {
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(THIS_IS_A_TEST);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        Client client = new MicrowaveOven(new ServerImpl());
        client.receive(this.tweet);
        Assert.assertEquals("Retrieve message works incorrectly!", THIS_IS_A_TEST, stream.toString().trim());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void storeMessageOntTheServer() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(THIS_IS_A_TEST);
        Server server = new ServerImpl();
        Client client = new MicrowaveOven(server);
        client.receive(this.tweet);
        Field messageField = server.getClass().getDeclaredField("messages");
        messageField.setAccessible(true);
        List<String> values = List.class.cast(messageField.get(server));
        Assert.assertEquals("Retrieve message works incorrectly!", THIS_IS_A_TEST, values.get(0));
    }

    @Test
    public void testAbstract() throws IllegalAccessException, InstantiationException {
        Class<?> a = WrapSingle.class.asSubclass(SomeSingle.class);
        Object o = a.newInstance();

        String debug = "";
    }
}
