package Ex02_WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String loggerLevel = reader.readLine();
        Logger logger = new Logger(Importance.valueOf(loggerLevel));
        String command;

        while (!"END".equals(command = reader.readLine())) {
            int colonIndex = command.indexOf(":");
               String message = command.substring(0, colonIndex);
               String content = command.substring(colonIndex + 2);

               logger.record(new Message(Importance.valueOf(message), content));
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}

/*
Input 1:
HIGH
NORMAL: All systems running
HIGH: Leakage in core room
LOW: Food delivery
END

Expected output 1:
HIGH: Leakage in core room



Input 2:
LOW
NORMAL: All systems running
HIGH: Leakage in core room
LOW: Food delivery
END

Expected output 2:
NORMAL: All systems running
HIGH: Leakage in core room
LOW: Food delivery


 */
