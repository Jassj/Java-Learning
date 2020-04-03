package virtualMachine;

/**
 * description
 * 局部变量表相关测试
 * @author yuanjie 2020/03/31 9:47
 */
public class LocalVariableTest {

    public LocalVariableTest() {
        int a = 1;
        int b = 2;
    }

    public static int getNumber() {
        int a = 1;
        int b = 2;
        float f = 1.1f;
        long l = 100000000000L;
        String s = "getNumber";
        return a + b;
    }

    // 变量槽slot的重复利用
    public void slotTest() {
        int a = 1;
        {
            int b = 0;
            b = a + 1;
        }
        // 变量c使用已经销毁的变量b的slot
        int c = a + 1;
    }

}
