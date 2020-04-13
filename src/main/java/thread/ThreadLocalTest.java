package thread;

/**
 * description
 * ThreadLocal类允许我们创建只能被同一个线程读写的变量。因此，如果一段代码含有一个ThreadLocal变量的引用，即使两个线程同时执行这段代码，
 * 它们也无法访问到对方的ThreadLocal变量。
 * @author yuanjie 2020/04/13 16:09
 */
public class ThreadLocalTest implements Runnable{

    private ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        //可以通过下面方法读取保存在ThreadLocal变量中的值
        System.out.println("-------threadLocal value-------"+threadLocal.get());
    }

    public static void main(String[] args) {
        ThreadLocalTest sharedRunnableInstance = new ThreadLocalTest();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }
}
