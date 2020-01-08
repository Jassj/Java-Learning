package leetcode;

/**
 * description
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * ①.考虑int类型反转溢出情况
 * ②.int转换为string使用库函数进行反转效率较低
 * @author yuanjie 2020/01/07 15:34
 */
public class IntegerReverse {
    private static int reverse(int x) {
//       return reverseByStr(x);
//        return reverseByStrBuilder(x);
//        return reverseByDecimal(x);
        return reverseByDecimal1(x);

    }

    private static int reverseByDecimal1(int x) {
        //循环拆解每一位数字
        long ans = 0;
        int ans_ = 0; //2^-31 ~ 2^31-1 (-2147483648~2147483647)
        while (x != 0) {
            ans = ans * 10 + x % 10; //使用long长整型可以避免运算溢出情况
            if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return 0;
            }
            ans_ = (int)ans;
            x = x / 10;
        }
        return ans_;
    }

    private static int reverseByDecimal(int x) {
        //循环拆解每一位数字
        int ans = 0; //2^-31 ~ 2^31-1 (-2147483648~2147483647)
        while (x != 0) {
            int prop = x % 10;
            if((ans  > Integer.MAX_VALUE / 10) || (ans == Integer.MIN_VALUE / 10 && prop > 7)) {
                return 0;
            }
            if((ans  < Integer.MIN_VALUE / 10) || (ans == Integer.MIN_VALUE / 10 && prop < -8)) {
                return 0;
            }
            ans = ans * 10 + prop; //Java编译器默认整数为int类型,进行运算后溢出的数会被强制转换为int类型,因此复制前需要进行溢出判断
            x = x / 10;
        }
        return ans;
    }

    //通过字符数组进行反转: 使用StringBuilder内置函数进行翻转,最后进行字符串转int
    //需要注意负数情况和字符串转int异常情况的捕获
    private static int reverseByStrBuilder(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(Math.abs(x)));
        stringBuilder.reverse();
        int ans;
        String s = (x < 0 ? "-" : "") + stringBuilder.toString();
        try {
            ans = Integer.parseInt(s);
        } catch (Exception e) {
            ans = 0;
        }
        return ans;
    }

    //通过字符数组进行反转: int转换成str后转成char数组,并进行翻转,最后进行字符串转int
    //需要注意负数情况和字符串转int异常情况的捕获
    private static int reverseByStr(int x) {
        String s = String.valueOf(Math.abs(x));
        //反转字符
        char c[] = s.toCharArray();
        for(int i = 0, len = c.length; i < len/2; i++) {
            char tempC = c[i];
            c[i] = c[len - i - 1];
            c[len - i - 1] = tempC;
        }
        String s1 = new String(c);
        s1 = (x < 0 ? "-" : "") + s1;
        int ans;
        try {
            ans = Integer.parseInt(s1);
        } catch (Exception e) {
            ans = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(reverse(2147483647));
    }

}
