package features;

import java.lang.reflect.Field;
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
    public T t;

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

    public static <T> T getListValue(List<T> list) {
        return list.get(0);
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
//        integerGenericTest.setT("hello world"); 类型参数化, 编译期间检测, integerGenericTest只允许String类型
        strGenericTest.setT("hello world");
        System.out.println(integerGenericTest.getT());
        System.out.println(strGenericTest.getT());

        // 类型擦除
        Class clazz = integerGenericTest.getClass();
        System.out.println(clazz.getName());

        Field[] fields = clazz.getDeclaredFields();
        for ( Field field : fields) {
            System.out.println("Field name: " + field.getName() + ", type: " + field.getType().getName());
        }
    }

    public static void fruitGenericFunc() {
        List<? extends Fruit> list1 = new ArrayList<>();
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        SubApple subApple = new SubApple();
//        list1.add(fruit);           无法通过编译
//        list1.add(new Apple());
//        list1.add(new SubApple());
        fruit = list1.get(0); // 任意子类可隐式向上转换成父类

        List<? super Apple> list2 = new ArrayList<>();
//        list2.add(fruit);   无法通过编译
        list2.add(apple);
        list2.add(subApple);
//        fruit = list2.get(0); 无法确定apple的父类
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