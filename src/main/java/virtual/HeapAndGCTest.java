package virtual;

import leetcode.bean.ListNode;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 * 堆空间和垃圾回收
 * @author yuanjie 2020/04/01 13:53
 */
public class HeapAndGCTest {

    private static List<Object> list = new ArrayList<>();

    public static void referenceTest() {
        SoftReference<Object> softReference = new SoftReference<>(new Object());
        System.out.println("before gc  " + softReference.get());
        System.gc();
        System.out.println("after  gc  " + softReference.get());

        WeakReference<Object> weakReference = new WeakReference<>(new Object());
        System.out.println("before gc  " + weakReference.get());
        System.gc();
        System.out.println("after  gc  " + weakReference.get());
    }


    public static void heapSizeTest1() {
        int[] i = new int[2 * 1024 * 1024];
    }

    public static void heapSizeTest2() {
        for(int i = 0;;i++) {
            ListNode listNode = new ListNode(i);
            list.add(listNode);
        }
    }

    public static void main(String[] args) {
//        referenceTest();
//        heapSizeTest1();
//        heapSizeTest2();
    }
}


