package virtualMachine;

import java.util.Arrays;

/*
 * GC  Garbage Collection  垃圾回收器
 * 根据以下方法进行垃圾回收
 * 1.方法的局部变量表
 * 2.运行时常量池
 * 3.方法区的类信息
 * 4.本地方法栈
 *
 * 变量的失效与回收时机
 * 1.实例变量-----所在对象不再被引用
 * 2.局部变量-----方法或语句块执行结束时
 * 3.方法参数-----方法执行结束时
 * 4.构造参数-----构造器执行结束时
 * 5.数组元素/容器元素-----元素所在的数组或容器不再被引用时
 * */
public class GCAndMemoryLeak {

    /*
     * 内存泄漏---通过jdk1.8.0_92/bin 中的jconsole.exe 和  jvisualvm.exe 观察
     * JAVA中存在内存泄漏----当JVM向操作系统申请的内存满足不了使用内存时出现ERROR
     * 当JAVA程序向JVM申请了一定的内存创建对象，但是没有及时释放对象时，内存一直被占用，导致堆中可用内存减少，无法创建新对象，内存发生泄漏
     * */
    public static void m1() {
        byte[]  b = null;
        for(int i = 0;i < 200;i++) { // 200MB
            for(int j = 0;j< 1024;j++) { // 1MB
                b = new byte[1024]; // 一个byte类型变量占一个字节，1024个byte类型：1024*1b = 1 KB
            }
        }
    }

    public static void main(String...args) {
        int [] x = new int []{1,2};
        x[0] = 99;
        x[1] = 88;
        System.out.println(Arrays.toString(x));
        x[2] = 333;//数组下标越界造成的内存泄漏
    }

}
