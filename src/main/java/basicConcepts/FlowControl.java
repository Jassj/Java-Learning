package basicConcepts;

/**
 * description: flow control
 * @author yuanjie 2019/09/26 22:23
 */
public class FlowControl {
    //复合语句由{开括号开始,}闭括号结束,也称作块语句
    public void compoundStatement() {
        int x = 5;
        System.out.println("x:"+x);
        {
            int y = 6; //复合语句中的局部变量不能在复合语句外使用
            System.out.println("y:"+y);
        }
    }

    /**
     * switch分支语句
     * ①.switch后表达式值只能为整型、字符型、字符串型,1.7版本及以上支持字符串
     * ②.case后变量值只能为整型、字符型、字符串型,1.7版本及以上支持字符串
     * ③.从满足x的条件开始执行,直到break或者结束,无匹配时直接default,无default不执行
     */
     public static void conditionStatement(int x) {
        switch(x) {
            case 1 :
                System.out.println("1");
            case 2 :
                System.out.println("2");
                break;
            case 3 :
                System.out.println("3");
            default :
                System.out.println("0");
        }
    }

    /**
     * 循环控制语句
     * ①.break语句跳出循环,只能跳出包含break语句的最内层循环,可以使用标签名跳出指定循环,如：Loop
     * ②.continue语句跳过本次循环,执行后续循环,也可以使用标签名跳出指定循环,如：Loop2
     */
    public static void loopControl() {
        Loop : for(int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                if (j == 5) {
                    break Loop;
                }
                System.out.println("i:" + i + ",j:" + j);
            }
        }
        System.out.println("====================");
        Loop2 : for(int i = 0; i <= 5; i++) {
            for(int j = 0; j <= 5; j++) {
                if(j == 3) {
                    continue Loop2;
                }
                System.out.println("i:"+i+",j:"+j);
            }
        }
    }

    //practice1: print diamond
    private static void printDiamond(int axisLength) {
        if(axisLength % 2 == 0 || axisLength == 1) {
            System.out.println("axisLength must over one and be odd");
            return;
        }

        char blank = ' ';
        char point = '.';
        //先打印上半部分
        for(int i = 1; i < axisLength; i += 2) {
            for(int j = 1; j <= (axisLength - i) / 2; j++) {
                System.out.print(blank);
            }
            for(int k = 1; k <= i; k++) {
                System.out.print(point);
            }
            System.out.print("\n");
        }
        //打印中间和下半部分
        for(int i = axisLength; i >= 1; i -= 2) {
            for(int j = 1; j <= (axisLength - i) / 2; j++) {
                System.out.print(blank);
            }
            for(int k = 1; k <= i; k++) {
                System.out.print(point);
            }
            System.out.print("\n");
        }
    }

    //practice2: 1+1/2！+1/3!+...1/20! 可简化实现方法
    public static void calculate(int len) {
        float result = 0;
        int i = 1;
        while(i <= len) {
            long multiple = 1;
            for(int j = 1; j <= i ; j++) {
                multiple = multiple * j;
            }
            result += 1.0/multiple;
            i++;
        }
        System.out.println("result:"+result);
    }

    public static void main(String[] args) {
//        loopControl();
//        printDiamond(11);
//        calculate(20);
    }
}
