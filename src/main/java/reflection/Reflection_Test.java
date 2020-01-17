package reflection;

import java.lang.reflect.*;

/**
 * @author yuanjie 2019/10/14 21:38
 * 优点
 * ①.反射可以在运行时操作类的属性和方法
 * ②.IOC功能非常依赖反射：如SpringMVC中beanFactory的装配
 * 缺点
 * ①.反射是在运行时使用的,会占用一定资源
 * ②.反射可以直接访问类,甚至可以访问private属性和方法,会破坏类的封装性而导致安全问题
 * <p>@Todo 反射的用途,如何在材料收转中发挥作用
 * @see Class
 * @since 1.0-SNAPSHOT
 */
public class Reflection_Test {
    public String name;
    public int age;
    private static final float PI = 3.14f;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Reflection_Test() {

    }

    public Reflection_Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static String getPerson(String name, int age) {
        System.out.println("name{"+name+"},age{"+age+"}");
        return "success";
    }

    /**
     * use reflection to create Array
     * Those method to get Class
     * ①.{@link Class#forName(String)}
     * ②.Object.getClass
     * ③.Class.class
     * Essential method
     * @see Array#newInstance(Class, int)
     */
    public static void createArray() {
//        Class<?> clazz = Class.forName("java.lang.String");
//        Object array = Array.newInstance(clazz, 20);
//        String str = "Test Reflection";
//        Object array = Array.newInstance(str.getClass(), 20);
        Object array = Array.newInstance(String.class, 20);
        Array.set(array, 0, "Hello");
        Array.set(array, 1, "World");
        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));
    }

    /**
     * usage of instance
     * ①.isInstance():反射的Class中方法判断是否为某个类的实例
     * ②.instance of:判断是否为某个类的实例
     * ③.new instance:
     * a.通过反射Class来创建实例,默认调用无参构造方法,如果获取不到无参构造方法,则抛出异常
     * @throws  InstantiationException
     *          实例化异常,找不到类的无参构造函数{@link Class#newInstance()}
     * b.通过反射Constructor来创建实例
     */
    public static void instanceTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> myClass = Reflection_Test.class;
        Object obj = myClass.newInstance();
        Constructor<?> constructor = myClass.getConstructor(String.class, int.class);
        Object obj2 = constructor.newInstance("Andy", 18);
        System.out.println(myClass.isInstance(obj));
        System.out.println(obj2 instanceof Reflection_Test);
    }

    /**
     * ①.getFields() 返回本类与继承的父类中所有的public成员变量
     * ②.getDeclaredFields() 返回本类中所有声明的成员变量
     */
    private static void fieldTest() {
        Class<Reflection_Test> myClass = Reflection_Test.class;
        Field[] fields = myClass.getFields();
        System.out.println("length:"+fields.length);
        for(Field field : fields) {
            System.out.println("name{"+field.getName()+"},class{"+field.getClass()+"}");
        }

        Field[] declaredFields = myClass.getDeclaredFields();
        System.out.println("declaredLength:"+declaredFields.length);
        for(Field field : declaredFields) {
            System.out.println("name{"+field.getName()+"},class{"+field.getClass()+"}");
        }
    }

    /**
     * ①.getMethods() 返回本类与继承的父类中所有的public方法
     * Identifies the set of all public members of a class or interface,
     * including inherited members.
     * ②.getDeclaredMethods() 返回本类中所有声明的方法
     * Identifies the set of declared members of a class or interface.
     * Inherited members are not included.
     * ③.getMethod() 返回指定的method对象  public member method
     */
    public static void methodTest() throws Exception{
        //Methods
        Class<Reflection_Test> myClass = Reflection_Test.class;
        Method[] methods = myClass.getMethods();
        System.out.println("length:"+methods.length);
        for(Method method : methods) {
            System.out.println("method{"+method+"},name{"+method.getName()+"},modifiers{"+ Modifier.toString(method.getModifiers())+"}");
        }

        //DeclaredMethods
        Method[] declareMethods = myClass.getDeclaredMethods();
        System.out.println("declaredLength:"+declareMethods.length);
        for(Method method : declareMethods) {
            System.out.println("declaredMethod{"+method+"},declaredName{"+method.getName()+"},declaredModifiers{"+ Modifier.toString(method.getModifiers())+"}");
        }

        //Method
        Method targetMethod = myClass.getMethod("getPerson", String.class, int.class);
        Object obj = myClass.newInstance();
        Object result = targetMethod.invoke(obj, "Jim", 23);
        System.out.println("result{"+result+"}");
    }

    public static void main(String[] args) {
        try {
//            fieldTest();
//            methodTest();
//            createArray();
            instanceTest();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
