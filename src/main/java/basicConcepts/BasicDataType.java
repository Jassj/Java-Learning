package basicConcepts;

/**
 * description: Basic Data Type
 * @author yuanjie 2019/09/22 21:07
 * 1.主类结构
 *  1.1.类是程序的基本单元,类由属性和方法组成
 *  1.2.属性也称作变量,分为(全局变量/成员变量/类变量)和(局部变量/实例变量)
 *  1.3.public(权限修饰符) static(静态修饰符) void(返回值修饰符)
 * 2.基本数据类型：整数默认为int,小数默认为double
 *  2.1.整型(byte 1字节,short 2字节,int 4字节,long 8字节)
 *  2.2.浮点型(float 4字节,double 8字节)
 *  2.3.字符型(char 2字节)
 *  2.4.布尔型(boolean)
 * 3.变量和常量
 *  3.1.标识符用于标识类名、方法名、变量名等,
 *  3.2.标识符由字母、下划线、数字、美元符顺序构成,不能以数字开头且区分大小写
 *  3.3.关键字不可用作标识符
 *  3.4.定义变量就是要告诉编译器这个变量是什么数据类型的,这样编译器才知道要分配多少内存空间给它,以及它能存放什么样的数据类型
 * 4.注释：单行注释,多行注释,文档注释
 * 5.原码、反码、补码与位运算
 */
public class BasicDataType {

    int example_variable = 0;//全局变量的作用范围为整个类

    /**
     *  计算机运算机制：有符号数使用补码形式存储,以补码进行运算,结果为原码
     *  原码--数的二进制表现形式,最高位为符号位0(正数),1(负数)
     *  反码--正数为原码
     *        负数：符号位不变,其余位按位取反
     *  补码--正数位原码
     *        负数：反码+1
     *  int强制类型转换为byte的运算机制：
     *  ①.200(int类型)二进制表现形式：00000000 00000000 00000000 11001000
     *  ②.转换为byte: 11001000--结果原码,需要转换为补码计算十进制数
     *               10110111
     *             +        1
     *               10111000 = -(32+16+8) = -56
     */
    public static void integerType() {
        byte b = (byte) 200;
        long l = 22000000000L; //整数默认为int,超过int范围时需增加(l/L)后缀修饰为长整型
    }

    public static void floatType() {
        float f = 1.00f; //小数默认为double类型,赋值给float类型需增加(f/F)后缀修饰
    }

    //转义字符:  \b  \t  \n  \f  \r  \''  \' \\
    public static void escapeCharacter() {
        char c = '\''; //采用unicode--无符号编码,存储0x0000-0xffff(0-65535)
        System.out.println("c:{"+c+"}");
    }

    // 定义在类方法中的变量称为局部变量,JVM在局部变量被声明时为其分配空间,当方法调用结束时,会释放局部变量占用的内存空间,局部变量被销毁
    public static void variableAndConstant() {
//        int 1a_$; 错误的标识符命名
        int $a_1; //正确但不合理的标识符命名
        int age; //正确且合理的标识符命名
    }

    /**
     * 运算符
     * @since Java-Learning 1.0
     * 位运算符(增加运算速度) {@link java.lang.reflect.Modifier#toString(int)}
     * ①.与运算符(&)：让参与两数的二进制各位相与，只有当两个二进制位都为1时，结果为1，否则为0
     *    作用：将二进制中指定位置置0
     * ②.或运算符(|)：让参与两数的二进制各位相或，当两个二进制位都为0时，结果为0，否则为1
     *    作用：将二进制中指定位置1
     * ③.异或运算符(^)：让参与两数的二进制各位相异或，不同为1，相同为0
     *    作用：将二进制中指定位保持原数或翻转，与0异或保持原数，已1异或翻转
     * ④.按位取反运算符(~)：单目运算符，将参与运算数的二进制各位取反
     *    快捷法：取反运算 == 十进制数+1取相反数
     * ⑤.移位运算符
     *    无符号左移(<<)：将参与运算的二进制数向左移位，低位使用补0 == * 2^n
     *    无符号右移(>>)：将参与运算的二进制数向右移位，高位根据符号位补0或1 == / 2^n，会造成精度丢失
     *    有符号右移(>>>)：将参与运算的二进制数向右移位，高位补0 == / 2^n
     */
    public static void operators() {
        int age = 23; //赋值运算符会先取得右方表达式处理的结果,然后把其赋值给左方的操作数(执行顺序从最右侧的=开始处理)
        int a = 1, b;
        //自增,自减运算符为单目运算符
        b = a++; //先把a的值赋值给b,后对a进行+1操作
        System.out.println("b:"+b);
        b = --a; //先对a进行-1操作,后把a的值赋值给b
        System.out.println("b:"+b);
        //逻辑运算符：与或非
//        boolean b1 = true && false; //具有短路特性,第一个表达式为false时不进行后续运算
//        boolean b2 = false & true; //非短路运算符,需结合运算符左右两边值得出结果
//        int triple = a > 1 ? 1 : -1; //三目运算符,等价于if else;
    }

    /**
     *  1.低级类型(低精度)向高级类型(高精度)进行转换时为隐式类型转换,系统自动进行操作
     *    byte < short < int < long < float < double
     *  2.JVM为long型开辟8个字节的内存空间,为float开辟4个字节的内存空间,但是由于long型取值范围远小于float型
     *    所以可以进行隐式类型转换
     *  3.当进行整数赋值时,不可超过声明变量类型的取值范围,否则需要进行强制类型转换
    */
    private static void typeConvert() {
        long l = 2200000000000000L;
        System.out.println("l:"+l);

        float f = 2200000000000000L;
        System.out.println("f:"+f);

        byte b = (byte)200;//强制类型转换
        System.out.println("b:"+b);

        int i = (int)44.5f; //会造成精度丢失
        System.out.println("i:"+i);
    }

    public static void main(String...args) {
//        integerType();
//        floatType();
//        escapeCharacter();
//        variableAndConstant();
//        operators();
//        typeConvert();
    }
}
