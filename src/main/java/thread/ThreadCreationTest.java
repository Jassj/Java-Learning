package thread;

import java.util.concurrent.*;

class MyThread extends Thread {
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

}

class RunnableDemo implements Runnable {
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
                Thread.sleep(50);
            }
        } catch (Exception e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
}

class CallableThreadTest implements Callable<Integer> {

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

}

public class ThreadCreationTest {
    // 通过继承线程类创建线程
    public static void threadExtendTest() {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        t1.start();
        t2.start();
    }

    // 通过实现runnable接口创建线程
    public static void runnableThreadTest() {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        new Thread(r1).start();

        RunnableDemo r2 = new RunnableDemo("Thread-2");
        new Thread(r2).start();
    }

    // 通过 Callable & Future 创建线程
    public static void callableThreadTest() throws ExecutionException, InterruptedException {
        CallableThreadTest c = new CallableThreadTest();
        FutureTask<Integer> f1 = new FutureTask<>(c);
        FutureTask<Integer> f2 = new FutureTask<>(c);
        Thread t1 = new Thread(f1, "Thread-1");
        t1.start();
        System.out.println(f1.get());
        Thread t2 = new Thread(f2, "Thread-2");
        t2.start();
        System.out.println(f2.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        threadExtendTest();
//        runnableThreadTest();
        callableThreadTest();
    }

}