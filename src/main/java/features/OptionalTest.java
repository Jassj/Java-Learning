package features;

import java.util.Optional;

public class OptionalTest {

    // 函数式接口
    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);
    }

    // 静态内部类
    static class GreetingChildService implements GreetingService {
        @Override
        public void sayMessage(String message) {
            System.out.println("我是内部类, 我要说: " + message);
        }
    }

    public static String getValue(Integer i) {
        if (i == 0) {
            return null;
        }
        if (i % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static String defaultValue() {
        return "default value";
    }

    public static void basic() {
        Optional<String> optional1 = Optional.of(getValue(121));
        Optional<String> optional2 = Optional.ofNullable(getValue(232));

        // 重写equal方法 比较两个optional容器类中的内容是否相同
        System.out.println(optional1.equals(optional2));

        // 重写hashcode方法
        System.out.println(optional1.hashCode());

        // 重写toString方法
        System.out.println(optional2.toString());
    }

    public static void functionalInterface() {
        // 1. 静态内部类
        GreetingChildService service = new GreetingChildService();
        service.sayMessage("oh my god!");

        // 2. 匿名内部类
        GreetingService service1 = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println("我是匿名内部类, 我要说: " + message);
            }
        };
        service1.sayMessage("hello");

        // lambda表达式
        GreetingService service2 = message -> System.out.println("我是lamdba表达式, 我要说: " + message);
        service2.sayMessage("world");
    }

    public static void optionalMethod() {
        // 判断型函数: 有参返回boolean, 检验操作
        Optional<String> optional1 = Optional.of(getValue(121));
        Optional<String> filterResult = optional1.filter(s -> s.contains("dd")); // ac
        System.out.println(filterResult.get());

        // 消费型函数: 有参无返回, 输出打印操作
        Optional<String> optional2 = Optional.of(getValue(234));
        optional2.ifPresent(s -> System.out.println("我是消费型函数, 我接受到的值是: " + s));

        // 供应型函数: 无参有返回, 默认值操作
        Optional<String> optional3 = Optional.ofNullable(getValue(0));
        String supplierResult = optional3.orElseGet(() -> defaultValue()); // "default value"
        System.out.println(supplierResult);

        // 转换型函数: 有参有返回, 映射转换操作
        Optional<String> mapResult = optional2.map(s -> s.replaceAll("e", "p"));
        System.out.println(mapResult.get());
    }

    public static void main(String[] args) {
//        basic();
//        functionalInterface();
        optionalMethod();
    }

}