package jvm;

import java.net.URL;

/**
 * description
 * 类加载器子系统
 * @author yuanjie 2020/03/27 10:35
 */
public class ClassLoaderTest {
    private static float f = 1.0f;
    private static boolean b = true;
    private static String s = "测试";
    private int i = 100; // 非静态成员变量, 不在类构造器<clinit>中赋值
    private final static char c = 's'; // final关键字修饰的为常量, 编译时赋值
    static {
        num = 20;
//        System.out.println(num); 无效的前向引用
    }

    private static int num = 2;

    public ClassLoaderTest() {
        int a = 101;
    }

    public static void differentClassLoader() {
        // 对于用户自定义类, 默认使用系统类加载器进行加载
        ClassLoader appClassLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(appClassLoader1); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 系统类加载器
        ClassLoader appClassLoader2 = ClassLoader.getSystemClassLoader();
        System.out.println(appClassLoader2); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取系统类加载器的上层: 扩展类加载器
        ClassLoader extClassLoader = appClassLoader2.getParent();
        System.out.println(extClassLoader); // sun.misc.Launcher$ExtClassLoader@7f31245a

        // 获取扩展类加载器的上层: 引导类加载器, 获取不到
        System.out.println(extClassLoader.getParent()); // null

        // String, System类都是用引导类加载器加载的, 因此获取不到
        ClassLoader bootClassLoader = String.class.getClassLoader();
        System.out.println(bootClassLoader); // null

        // 引导类加载器加载文件的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls) {
            System.out.println(url);
        }

    }

    public static void main(String[] args) {
        differentClassLoader();
    }

}
