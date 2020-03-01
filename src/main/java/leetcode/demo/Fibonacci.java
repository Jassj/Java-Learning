package leetcode.demo;

/**
 * description:
 * 斐波那契数列: f(n) = f(n-1) + f(n-2)  n > 2
 *             f(n) = 1                n > 0 && n <=2
 *             f(n) = 0                n <= 0
 * @author yuanjie 2020/02/03 11:15
 */
public class Fibonacci {
    // 递归和迭代的方式分别计算斐波那契数列
    private static int fibonacci(int n) {
        if(n <= 0) { // 负数直接返回
            return 0;
        }
//        return fibonacciByIteration(n);
        return fibonacciByRecursive(n);
    }

    // 使用递归法进行斐波那契数列的计算
    private static int fibonacciByRecursive(int n) {
        if(n <= 0) {
            return 0;
        }

        if(n == 1 || n == 2) {
            return 1;
        }

        return fibonacciByRecursive(n - 1) + fibonacciByRecursive(n - 2);
    }

    // 使用迭代法进行斐波那契数列的计算
    private static int fibonacciByIteration(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }

        int f1 = 1, f2 = 1;
        for(int i = 3; i <= n; i++) {
            int temp = f2;
            f2 = f1 + f2;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        for(int i = 1 ; i <= 10;i++) {
            System.out.print(fibonacci(i)+" ");
        }
    }
}
