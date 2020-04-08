package advancedFeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * generics since JDK 5.0
 * 1.泛型提供了编译时的类型安全检测机制,泛型的本质是参数化类型
 * 2.声明泛型类或者泛型方法
 * @author yuanjie 2019/10/19 15:48
 */
public class GenericTest<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    // 泛型方法: 通用数组打印方法(适用所有继承Comparable的类)
    public static <E extends Comparable> void printArray(E[]...array) {
        System.out.println("----开始打印----");
        for(E[] element : array) {
            for(E e : element) {
                System.out.print(e + ",");
            }
            System.out.println("");
        }
        System.out.println("----结束打印----");
    }

    public static void getListValue(List<?> list) {
        System.out.println(list.get(0));
    }

    public static void arrayGenericFunc() {
        Integer i[] = new Integer[] {1, 2, 3, 4};
        String str[] = new String[] {"nice", "to", "meet", "you"};
        printArray(i);
        printArray(str);
        printArray(i, str);
    }

    public static void listGenericFunc() {
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        List<Map<Integer, String>> mapList = new ArrayList<>();
        intList.add(1);
        strList.add("hello world");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello world");
        mapList.add(map);
        getListValue(intList);
        getListValue(strList);
        getListValue(mapList);
    }

    public static void genericClassTest() {
        GenericTest<Integer> integerGenericTest = new GenericTest<>();
        GenericTest<String> strGenericTest = new GenericTest<>();
        integerGenericTest.setT(1);
        strGenericTest.setT("hello world");
        System.out.println(integerGenericTest.getT());
        System.out.println(strGenericTest.getT());
    }

    public static void fruitGenericFunc() {
//        List<? extends Fruit> list1= new ArrayList<>();
//        Fruit fruit = new Fruit();
//        Apple apple = new Apple();
//        SubApple subApple = new SubApple();
//        list1.add(fruit);
//        list1.add(new Apple());
//        list1.add(new SubApple());
//
//        List<? extends Apple> list2 = new ArrayList<SubApple>();
//        list2.add(new Fruit());
//        list2.add(new Apple());
//        list2.add(new SubApple());
//
//        List<Apple> list3 = new ArrayList<>();
//        list3.add(new Fruit());
//        list3.add(new Apple());
//        list3.add(new SubApple());
    }

    public static void main(String[] args) {
//        arrayGenericFunc();
//        listGenericFunc();
//        fruitGenericFunc();
        genericClassTest();
    }
}

class Fruit {

}

class Apple extends Fruit {

}

class SubApple extends Apple {

}