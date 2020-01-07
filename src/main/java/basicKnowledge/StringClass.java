package basicKnowledge;

/**
 * description String Object
 * @author yuanjie 2019/09/29 21:58
 */
public class StringClass {

    /**
     * 1.String对象的组成
     * ①.char[] value: 字符型code
     * ②.int hash：hashCode
     * 2.String charString = new String(new char[3]);
     * 使用char[]初始化对象时,String对象的构造函数将字符数组参数的值复制到value变量中
     * 官方描述：使用以下方法是为了防止字符数组改变对象的值导致String对象变化(this.value=value)
     * this.value = Arrays.copyOf(value, value.length);
     */
    private static void basicString() {
        String s;
        String hashString = "string";
        char c[] = new char[] {'a','b','c',};
        String charString = new String(c);
//        System.out.println("s:"+s); variable must be initialized before using
        System.out.println("hashString:"+hashString.hashCode());
        System.out.println("charString:"+charString);
    }

    public static void main(String[] args) {
        basicString();
    }
}
