package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class RunnableDemo implements Runnable{
    private Thread thread;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() { // 线程调度器将就绪线程设置为运行线程, 此时线程处于运行状态, 将会调用run()方法
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
            thread.start(); // 线程进入就绪状态, 等待线程调度器
        }
    }
}

class MyThread extends Thread {
    private Thread thread;
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
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

class CallableThreadTest implements Callable<Integer> {
    private String threadName;

    @Override
    public Integer call() {
        String threadName = Thread.currentThread().getName();
        System.out.println("当前线程：" + threadName);
        if("Thread-1".equals(threadName)) {
            return 1;
        } else if("Thread-2".equals(threadName)) {
            return 2;
        } else if("Thread-0".equals(threadName)) {
            throw new RuntimeException("Illegal Thread Name");
        }
        return 0;
    }

    public CallableThreadTest(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

}

public class ThreadCreationTest {
    // 通过实现runnable接口创建线程
    public static void runnableThreadTest() {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();

        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }

    // 通过继承线程类创建线程
    public static void threadExtendTest() {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        t1.start();
        t2.start();
    }

    // 通过实现callable创建线程
    public static void callableThreadTest() throws ExecutionException, InterruptedException {
        CallableThreadTest c0 = new CallableThreadTest("Thread-0");
        CallableThreadTest c1 = new CallableThreadTest("Thread-1");
        CallableThreadTest c2 = new CallableThreadTest("Thread-2");
        FutureTask<Integer> f0 = new FutureTask<>(c0);
        Thread t0 = new Thread(f0);
        System.out.println(f0.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        runnableThreadTest();
//        threadExtendTest();
        callableThreadTest();
    }
}