package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description
 * Lock锁
 * @author yuanjie 2020/04/13 17:02
 */
public class LockTest {
    public static int i = 0;
    private static Lock lock = new ReentrantLock(); // 定义可重入锁

    public static void lockAdd() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            for (int i = 1; i <= 10000; i++) {
                LockTest.i++;
            }
            System.out.println(Thread.currentThread().getName() + "释放了锁");
        } catch (Exception e) {
            lock.unlock();
        }
    }

    public static void tryLockAdd() {
        if(lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                for (int i = 1; i <= 10000; i++) {
                    LockTest.i++;
                }
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            } catch (Exception e) {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "获取锁失败");
        }
    }

    public static void multiThreadLockTest() {
        Thread thread1 = new MyOwnThread();
        Thread thread2 = new MyOwnThread();
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        multiThreadLockTest();
    }
}

class MyOwnThread extends Thread {
    @Override
    public void run() {
        LockTest.tryLockAdd();
    }
}


