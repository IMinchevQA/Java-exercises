import java.io.IOException;

/**
 * Created by Ivan Minchev on 2/16/2017.
 */
public class Ex07_ThreadLock_16Feb2017 {
    public static void main(String[] args) throws InterruptedException, IOException {
        MyClass first = new MyClass();
        first.id = "First";

        MyClass second = new MyClass();
        second.id = "Second";

        Thread t1 = new Thread(() -> first.methodA(second));
        Thread t2 = new Thread(() -> second.methodA(first));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

class MyClass {

        String id;
    synchronized void methodA(MyClass other) {
        System.out.printf("%s called methodA on %s%n", this.id, other.id);
        other.methodB(this);
    }

    synchronized void methodB(MyClass other) {
        System.out.printf("%s called methodB on %s%n", this.id, other.id);
        other.methodC();
    }

    synchronized void methodC() {
        System.out.println("All done!");
    }
}
