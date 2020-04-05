package basicConcepts;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExceptionTest {
    //类型转换异常：ClassCastException
    //未找到相应类异常：ClassNotFoundException
    //算术异常：ArithmeticException
    //数组下标越界异常：ArrayIndexOutOfBoundsException
    //操作数据库异常类：SQLException
    //空指针异常：NullPointerException
    //方法为找到抛出的异常：NoSuchMethodException
    //字符串转换为数字抛出的异常：NumberFormateException
    //输入输出异常；IOException
    //文件未找到异常：FileNotFoundException
    public static void E1() throws MyException, Exception{
        try {
            System.out.println("====beginning====");
            int i = 3 / 0;
            System.out.println("====ending====");
        } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			throw e; // throw抛出后，后面除finally方法中的语句都不执行
		} finally {
            System.out.println("====finally====");
        }
        System.out.println("====lucky====");
    }

    public static void main(String[] args) {
        try {
            E1();
            InputStream inputStream = new FileInputStream("");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

//可自定义异常类, 继承Exception对象, 可定义检查类型异常
class MyException extends Exception {
    public MyException(String errMsg) {
        super(errMsg);
    }
}

//自定义运行时异常类
class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String errMsg) {
        super("My Runtime Exception" + errMsg);
    }
}
