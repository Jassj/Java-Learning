package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description
 * synchronized 关键字
 * @author yuanjie 2020/03/24 16:23
 */
public class SynchronizedDemo {
    private final static Logger logger = LoggerFactory.getLogger(SynchronizedDemo.class);

    // 对象锁: 形式1(方法锁), 声明同步方法
    public synchronized void accessVal1() {
        logger.info("我是对象锁也是方法锁");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 对象锁: 形式2, 声明同步代码块
    public void accessVal2() {
        logger.info(Thread.currentThread().getName() + ": 我不是同步代码块, 快来访问我");
        synchronized (this) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("我是对象锁");
        }
    }

    // 对象锁: 形式2, 声明同步代码块
    public void accessVal2_copy() {
        synchronized (this) {
            logger.info("我是另一个同步代码块");
        }
    }

    // 类锁: 形式1, 声明静态同步方法
    public static synchronized void accessVal3() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("我是类锁一号, 等锁释放哦");
    }

    // 类锁: 形式2, 声明静态同步代码块
    public void accessVal4() {
        logger.info(Thread.currentThread().getName() + ": 我不是同步代码块, 快来访问我");
        synchronized (SynchronizedDemo.class) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("我是类锁二号, 等锁释放哦");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        Runnable r = () -> {
            logger.info(Thread.currentThread().getName() + "开始");
            try {
                synchronizedDemo.accessVal2();
            } catch (Exception e) {
                logger.error("", e);
            }
            logger.info(Thread.currentThread().getName() + "结束");
        };

        Runnable r1 = () -> {
            logger.info(Thread.currentThread().getName() + "开始");
            try {
                synchronizedDemo.accessVal2();
                synchronizedDemo.accessVal2_copy();
            } catch (Exception e) {
                logger.error("", e);
            }
            logger.info(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r1, "线程2");

        t2.start();
        Thread.sleep(1000);
        t1.start();
    }

}
