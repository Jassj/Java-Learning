package jvm;

/**
 * description
 * 动态链接测试
 * @author yuanjie 2020/03/31 23:06
 */
public class DynamicLinkingTest {

    public void methodA() {

    }

    public void methodB() {
        System.out.println("methodB()....");

        methodA();
    }
}
