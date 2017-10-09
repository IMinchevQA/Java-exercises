package Ex09_TrafficLights;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputTokens = reader.readLine().split("\\s+");

        TrafficLight[] trafficLights = new TrafficLight[inputTokens.length];

        for (int i = 0; i < trafficLights.length; i++) {
            trafficLights[i] = new TrafficLight(Signals.valueOf(inputTokens[i]));
        }

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight + " ");
            }
            System.out.println();
        }

    }
}

/*
Input 1:
GREEN RED YELLOW
4

Expected output 1:
YELLOW GREEN RED
RED YELLOW GREEN
GREEN RED YELLOW
YELLOW GREEN RED


 */
