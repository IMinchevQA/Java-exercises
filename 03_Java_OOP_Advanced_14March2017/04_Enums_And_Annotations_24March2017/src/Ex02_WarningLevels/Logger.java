package Ex02_WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private Importance treshold;

    List<Message> messages;

    public Logger(Importance treshold) {
        this.treshold = treshold;
        this.messages = new ArrayList<>();
    }

    public void record(Message message) {
        if (message.getLevel().compareTo(this.treshold) >= 0) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return messages;
    }

//    public static void main(String[] args) {
//        Logger logger = new Logger(Importance.HIGH);
//        logger.record(new Message(Importance.LOW, "low level"));
//        logger.record(new Message(Importance.MEDIUM, "medium level"));
//        logger.record(new Message(Importance.HIGH, "high level"));
//
//        for (Message message : logger.getMessages()) {
//            System.out.println(message);
//        }
//    }
}
