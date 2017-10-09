import java.io.IOException;


public class Ex01_SingleThread {
    public static void main(String[] args) throws IOException{
        Runnable task = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.print(i + " ");
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);


    }
}
