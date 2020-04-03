package advancedFeatures.collections;

import java.util.*;

/**
 * description
 * Map Demo: HashMap & LinkedHashMap & TreeMap
 * @author yuanjie 2020/03/25 10:16
 */
public class MapDemo {


    public static void hashMapIterator() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            int value = (int) entry.getValue();
//            hashMap.remove(key); // 使用迭代器的过程中对HashMap进行了结构化修改, 此时通过modCount捕获到此行为, 抛出ConcurrentModificationException异常
//            iterator.remove(); // 迭代器本身的remove方法移出元素没有对HashMap造成结构化修改, 因此不会抛出ConcurrentModificationException异常
        }
    }

    // TreeMap相关函数
    public static void treeMapFunc() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "b");
        treeMap.put(1, "a");
        treeMap.put(3, "c");
        System.out.println(treeMap.headMap(3)); // 根据小于当前key的元素构造一个新的有序Map
        for(Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    // LinkedMap相关函数
    public static void linkedMapFunc() {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "a");
        linkedHashMap.put(2, "b");
        linkedHashMap.put(3, "c");
        linkedHashMap.put(11, "c");
        Iterator<Map.Entry<Integer, String>> iterator = linkedHashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int key = (Integer) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        // 第三个参数用于指定accessOrder值
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put(1, "a");
        linkedHashMap.put(2, "b");
        linkedHashMap.put(3, "c");
        linkedHashMap.put(11, "c");

        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get(1);
        iterator = linkedHashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int key = (Integer) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }

    public static void main(String[] args) {
//        hashMapIterator();
//        treeMapFunc();
        linkedMapFunc();
    }

}
