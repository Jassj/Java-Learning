package thread;

class RunnableDemo implements Runnable{
    private Thread thread;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for(int i = 0; i < 5; i++) {
                System.out.println("Thread: " + threadName + ", " + i);
                //Sleep
                Thread.sleep(50);
            }
        } catch (Exception e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting  " + threadName);

        if(thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();

        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }
}