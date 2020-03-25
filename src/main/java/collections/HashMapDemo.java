package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * description
 * HashMap Demo
 * @author yuanjie 2020/03/25 10:16
 */
public class HashMapDemo {

    public static void iteratorFunc() {
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

    public static void main(String[] args) {
        iteratorFunc();
    }
}
