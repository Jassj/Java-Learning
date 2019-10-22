package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanjie 2019/10/19 15:48
 * generics since JDK 5.0
 * ①.泛型提供了编译时的类型安全检测机制,泛型的本质是参数化类型
 * ②.
 * <p>@Todo 材料收转实现文件的泛型,可以操作JPG,PDF,TIF,WORD,MEDIA
 * @see List
 * @since 1.0-SNAPSHOT
 *
 */
//class File<T> {
//    public <T> File() {
//
//    }
//
//    public <T> getFile(File<T> file) {
//        <T> t = file.getClass();
//        return t;
//    }
//}

public class Generic_Test {

    //打印通用数组
    public static <E extends Comparable> E[] printArray(E[]...array) {
        for(E[] element : array) {
            for(E e : element) {
                System.out.print(e + " ");
            }
            return element;
        }
        return array[0];
    }

    public static void getListValue(List<?> list) {
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        Integer i[] = new Integer[] {1, 2, 3, 4};
        String str[] = new String[] {"nice", "to", "meet", "you"};
//        printArray(i);
//        printArray(str);
        printArray(i, str);
//        List<String> strList = new ArrayList<String>();
//        List<Integer> intList = new ArrayList<Integer>();
//        strList.add("hello");
//        intList.add(5);
//
//        getListValue(strList);
//        getListValue(intList);

        List list = new ArrayList();
    }

    public static void demo1() {
//        List<? extends Fruit> list1 = new ArrayList<>();
////        list1.add(new Fruit());
//        list1.add(new Apple());
////        list1.add(new SubApple());
//
//        List<? extends Apple> list2 = new ArrayList<SubApple>();
//        list1.add(new Fruit());
//        list1.add(new Apple());
//        list1.add(new SubApple());
//
//        List<Apple> list23 = new ArrayList<>();
//        list1.add(new Fruit());
//        list1.add(new Apple());
//        list1.add(new SubApple());
    }
}

class Fruit {

}

class Apple extends Fruit {

}

class SubApple extends Apple {

}

