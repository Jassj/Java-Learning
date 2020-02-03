package leetcode.demo;

/**
 * description：
 * 欧几里得算法(辗转相除法)--求最大公约数:
 * 两个正整数的最大公约数等于其中最小数和两数相除余数的最大公约数, 当余数为0时停止
 * gdc(a, b) = gcd(b, a mod b)
 * @author yuanjie 2020/02/03 11:15
 */
public class Gcd {

    private static int getGcd(int a, int b) {
        int mod = a % b;
        while(mod != 0) {
            a = b;
            b = mod;
            mod = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(getGcd(5, 12));
    }
}
