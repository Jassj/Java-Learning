package virtual;

/**
 * description
 * 操作数栈测试
 * @author yuanjie 2020/03/31 22:34
 */
public class OperandStackTest {

    public void addOperationTest() {
        // byte/short/char/boolean都以int类型存放
        processMethod();
        byte a = 15;
        int b = 8;
        int k = a + b;
    }

    public String processMethod() {
        return "access process method";
    }

}
