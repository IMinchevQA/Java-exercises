package twitter;

import java.util.Random;

public class Message implements Tweet {
    private final Random random;

    public Message() {
        this.random = new Random();
    }

    //Mocking - retrieving of a random message!!!
    @Override
    public String retrieveMessage() {
        int length = random.nextInt(250);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int symbol = this.random.nextInt(122);
            if (symbol > 96 || (symbol > 64 && symbol < 91)) {
                sb.append(Character.toChars(symbol));
            } else {
                sb.append(' ');
            }
        }
        return sb.toString().replaceAll("\\s+", " ");
    }

//    public static void main(String[] args) {
//        Tweet tw = new Message();
//        System.out.println(tw.retrieveMessage());
//    }
}
