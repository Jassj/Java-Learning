package collections;

import java.util.*;

/**
 * description
 * Collection Functions
 * @author yuanjie 2020/03/30 9:36
 */
public class CollectionFunctionsTest {

    private final static HashMap<String, Integer> HASH_MAP = new HashMap<>();
    private final static HashMap<String, String> HASH_MAP_STR = new HashMap<>();
    static {
        HASH_MAP.put("jessica", 3);
        HASH_MAP.put("lucy", 1);
        HASH_MAP.put("amanda", 2);

        HASH_MAP_STR.put("jessica", "third");
        HASH_MAP_STR.put("lucy", "second");
        HASH_MAP_STR.put("amanda", "first");
    }

    // list排序方法
    public static void listSort() {
        // 原始list
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        printList(list);

        // Sorts the specified list into ascending order, according to the {@linkplain Comparable natural ordering} of its elements.
        // 按照"自然排序"的升序排序方式
        Collections.sort(list);
        printList(list);

        // Reverses the order of the elements in the specified list.
        // 反转list
        Collections.reverse(list);
        printList(list);

        // Adds all of the specified elements to the specified collection.
        // 批量添加元素
        Collections.addAll(list,9, 20, 26);
        printList(list);

        // Randomly permutes the specified list using a default source of randomness.
        // 洗牌随机打乱list
        Collections.shuffle(list);
        printList(list);
    }

    // 打印list信息
    public static <T extends Object> void printList(List<T> list) {
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+"-->");
        }
        System.out.println();
    }

    // 借助比较器完成排序
    private static void listSortByComparator() {
        List<String> list = new ArrayList<>();
        list.add("jessica");
        list.add("lucy");
        list.add("amanda");
        printList(list);

        // 按照字符串长度排序
        list.sort(Comparator.comparingInt(String::length));
        printList(list);

        // 按照字符串在HASH_MAP中的映射值排序
        list.sort(Comparator.comparingInt(HASH_MAP::get));
        printList(list);

        // lambda表达式: 按照字符串在HASH_MAP_STR中的映射值排序
        list.sort((o1, o2) -> {
            String s1 = HASH_MAP_STR.get(o1);
            String s2 = HASH_MAP_STR.get(o2);
            return s1.compareTo(s2);
        });
        printList(list);
    }

    // 同步方法
    public static void setSynchronizedFunc() {
        // 创建线程安全的HashMap
        Map<Object, Object> hashMap = Collections.synchronizedMap(new HashMap<>());
        // 创建线程安全的ArrayList
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    }

    public static void main(String[] args) {
//        listSort();
//        listSortByComparator();
        setSynchronizedFunc();
    }

}
