package twitter;

public class Main {
    public static void main(String[] args) {
        Tweet tw = new Message();
        System.out.println(tw.retrieveMessage());

        Client cl = new MicrowaveOven(new ServerImpl());
        cl.receive(tw);
    }
}
