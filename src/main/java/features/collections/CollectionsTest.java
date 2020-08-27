package features.collections;

import java.util.*;

/**
 * description
 * Collection Functions
 * @author yuanjie 2020/03/30 9:36
 */
public class CollectionsTest {

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

class UpdateStu implements Comparable<Object> {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateStu(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public int compareTo(Object o) {
        UpdateStu upstu = (UpdateStu) o;
        int result = id > upstu.id ? 1 : (id == upstu.id ? 0 : -1);//比较方法
        return result;
    }

    // TreeSet集合
    public static void TreeSet(){
        UpdateStu stu1 = new UpdateStu("李同学", 01011);
        UpdateStu stu2 = new UpdateStu("陈同学", 01021);
        UpdateStu stu3 = new UpdateStu("王同学", 01051);
        UpdateStu stu4 = new UpdateStu("马同学", 01012);
        // TreeSet集合集成Set接口, 元素具有唯一性, 且按照比较器顺序排序
        TreeSet<UpdateStu> treeSet = new TreeSet<UpdateStu>();
        treeSet.add(stu1);
        treeSet.add(stu2);
        treeSet.add(stu3);
        treeSet.add(stu4);
        Iterator it = treeSet.iterator();
        while (it.hasNext())  {
            UpdateStu tempStu = (UpdateStu)it.next();
            System.out.println("集合对象的UpdateStu的id:"+tempStu.getId()+",name:"+tempStu.getName());
        }
        it = treeSet.headSet(stu2).iterator();
        while (it.hasNext())  {
            UpdateStu tempStu = (UpdateStu)it.next();
            System.out.println("集合对象的UpdateStu的id:"+tempStu.getId()+",name:"+tempStu.getName());
        }
        it = treeSet.subSet(stu2, stu3).iterator();
        while (it.hasNext())  {
            UpdateStu tempStu = (UpdateStu)it.next();
            System.out.println("集合对象的UpdateStu的id:"+tempStu.getId()+",name:"+tempStu.getName());
        }
    }

    // List集合允许重复值，Set集合不允许重复值
    public static void List() {
        UpdateStu stu1 = new UpdateStu("李同学", 01011);
        UpdateStu stu2 = new UpdateStu("陈同学", 01021);
        UpdateStu stu3 = new UpdateStu("王同学", 01051);
        UpdateStu stu4 = new UpdateStu("马同学", 01012);
        List<UpdateStu> list = new ArrayList<UpdateStu>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu1);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            UpdateStu tempStu = (UpdateStu)iterator.next();
            System.out.println("集合对象的UpdateStu的id:"+tempStu.getId()+",name:"+tempStu.getName());
        }
        Set<UpdateStu> set = new HashSet<UpdateStu>();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        set.add(stu4);
        set.add(stu1);
        iterator = set.iterator();
        while(iterator.hasNext()) {
            UpdateStu tempStu = (UpdateStu)iterator.next();
            System.out.println("集合对象的UpdateStu的id:"+tempStu.getId()+",name:"+tempStu.getName());
        }
    }

    public static void main(String[] args) {
//		TreeSet();
        List();
    }

}
