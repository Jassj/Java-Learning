package leetcode;

/**
 * description：
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * <p>
 * 利用迭代算法解决问题，需要做好以下三个方面的工作：
 * 一、确定迭代变量
 *  在可以用迭代算法解决的问题中，至少存在一个可直接或间接地不断由旧值递推出新值的变量，这个变量就是迭代变量。
 * 二、建立迭代关系式
 *  所谓迭代关系式，指如何从变量的前一个值推出其下一个值的公式（或关系）。迭代关系式的建立是解决迭代问题的关键，通常可以使用递推或倒推的方法来完成。
 * 三、对迭代过程进行控制
 *  在什么时候结束迭代过程？这是编写迭代程序必须考虑的问题。不能让迭代过程无休止地执行下去。迭代过程的控制通常可分为两种情况：一种是所需的迭代次数是个确定的值，可以计算出来；另一种是所需的迭代次数无法确定。对于前一种情况，可以构建一个固定次数的循环来实现对迭代过程的控制；对于后一种情况，需要进一步分析得出可用来结束迭代过程的条件。
 * </p>
 * @author yuanjie 2020/01/14 16:13
 */
public class SquareRoot {

    private static int mySqrt(int x) {
        return sqrtByNewtonIteration(x);
//        return sqrtByMidNumber(x);
//        return sqrtByMathFunction(x);
    }

    //  ④.相关迭代法的算法测试： 最大公约数(欧几里得算法)、斐波那契数列


    //  ③.牛顿迭代法：(a + x / a) / 2 = b
    //  首先取x作为参照系, 每次计算的结果b作为下一次的参照系, 当参照系与结果b的误差小于指定值时, 可得近似平方根
    private static int sqrtByNewtonIteration(int x) {
        double e = 1e-6; //误差值
        double a = x;
        double b = (a + x / a) / 2;
        while(Math.abs(a - b) > e) {
            a = b;
            b = (a + x / a) / 2;
        }
        return (int)Math.floor(a);
    }

    // ②.中位数的二分法：在整数范围内寻找x的平方根
    // 任意一个数的平方根都在两个整数之间(a^2 < x < b^2),因此要寻找x的近似平方根(题目要求向下取整),只要迭代使用二分法使得左右区间趋近闭合即可得出结果
    private static int sqrtByMidNumber(int x) {
        long left = 0;
        long right = Integer.MAX_VALUE; // 2^15 - 1
        while(left < right) {
            long mid = (right + left + 1) >> 1; //考虑到左边界最小为0，因此+1取中位数，右移一位 <==> x / 2
            long square = mid * mid;
            if(square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    /**
        ①.依靠{@link java.lang.Math}工具类完成
     */
    private static int sqrtByMathFunction(int x) {
        return (int)Math.floor(Math.sqrt(x));
    }

    public static void main(String[] args) { //2147395599
        System.out.println(mySqrt(2147395599));
    }
}

