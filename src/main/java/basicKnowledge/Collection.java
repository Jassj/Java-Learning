package basicKnowledge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Collection {
    List<String> list = new ArrayList<String>(10);
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
