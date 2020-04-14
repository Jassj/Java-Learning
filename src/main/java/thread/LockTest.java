package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description
 * Lock & ReentrantLock
 * @author yuanjie 2020/04/13 17:02
 */
public class LockTest {
    public static int i = 0;
    private static Lock lock = new ReentrantLock(); // 定义可重入锁
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // 定义可读写重入锁

    public static void lockAdd() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            for (int i = 1; i <= 10000; i++) {
                LockTest.i++;
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
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
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "获取锁失败");
        }
    }

    public static void waitForTryLockAdd() {
        try {
            if(lock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + "获取了锁");
                    for (int i = 1; i <= 10000; i++) {
                        LockTest.i++;
                    }
                    Thread.sleep(2000);
                }  finally {
                    System.out.println(Thread.currentThread().getName() + "释放了锁");
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "获取锁失败");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "等待状态被中断");
        }
    }

    public static void interruptLockAdd() {
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                for (int i = 1; i <= 10000; i++) {
                    LockTest.i++;
                }
                Thread.sleep(1000);
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "等待状态被中断");
        }
    }

    public static synchronized void readOperationBySynchronized() {
        try {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            for (int i = 1; i <= 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "正在执行读操作");
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
        }
    }

    public static void readOperationByLock() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            for (int i = 1; i <= 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "正在执行读操作");
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            readWriteLock.readLock().unlock();
        }
    }

    public static void multiThreadLockTest() {
//        Thread thread1 = new Thread(LockTest::waitForTryLockAdd); // lambda表达式
//        Thread thread2 = new Thread(LockTest::waitForTryLockAdd);
//        thread1.start();
//        thread2.start();

//        Thread thread3 = new Thread(LockTest::interruptLockAdd);
//        Thread thread4 = new Thread(LockTest::interruptLockAdd);
//        thread3.start();
//        thread4.start();
//        thread4.interrupt();

        Thread thread5 = new Thread(LockTest::readOperationByLock);
        Thread thread6 = new Thread(LockTest::readOperationByLock);
        thread5.start();
        thread6.start();
    }

    public static void main(String[] args) {
        multiThreadLockTest();
    }

}


