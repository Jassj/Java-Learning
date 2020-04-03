package virtualMachine;

/**
 * description
 * 多线程调用加载静态块
 * @author yuanjie 2020/03/24 10:50
 */
public class DeadThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");

        t1.start();
        t2.start();
    }

    static class DeadThread {
        static {
            if(true) {
                System.out.println(Thread.currentThread().getName() + "初始化当前类");
                while(true) { // 制造死循环

                }
            }
        }
    }
}
