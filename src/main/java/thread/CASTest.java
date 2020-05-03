package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 * 原子整型, 支持多线程并发场景{@link java.util.concurrent.atomic.AtomicInteger}
 * @author yuanjie 2020/05/03 14:41
 */
public class CASTest {

    private static AtomicInteger atomicI = new AtomicInteger(0); // 符合原子性规范的整型: 适用于并发场景
    private static int i = 0; // 普通整型: 适用于单例场景

    public static int getAtomicI() {
        return atomicI.get();
    }

    public static int getI() {
        return i;
    }

    public static void increaseAtomicValue() {
        atomicI.incrementAndGet();
    }

    public static void increaseValue() {
        i++;
    }

    public static void multiThreadIncreaseI() {
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++) {
                increaseValue();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++) {
                increaseValue();
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("after increasing, the result of i is: " + i);
    }

    public static void multiThreadIncreaseAtomicI() {
        Runnable r1 = () -> {
            for(int i = 1; i <= 10000; i++) {
                increaseAtomicValue();
            }
        };

        Runnable r2 = () -> {
            for(int i = 1; i <= 10000; i++) {
                increaseAtomicValue();
            }
        };

        r1.run();
        r2.run();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("after increasing, the result of i is: " + getAtomicI());
    }

    public static void main(String[] args) {
//        multiThreadIncreaseI();
        multiThreadIncreaseAtomicI();
    }
}
