package leetcode;

/**
 * description：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 不使用整数转字符串进行处理
 * ①.负数不可能为回文数
 * ②.以0结尾的数字不可能为回文数
 * ③.int整数反转会出现运算溢出: 使用long型存储反转数或者仅反转一半数字后比较
 * @author yuanjie 2020/01/08 11:15
 */
public class PalindromeNumber {

    private static boolean isPalindrome(int x) {
//        return checkPalindromeByReserve(x);
        return checkPalindromeByHalfReserve(x);
    }

    //反转一半数字后比较前后两半部分
    private static boolean checkPalindromeByHalfReserve(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int ans = 0;
        while(x > ans) { //反转一半数字后停止
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        //停止后根据数字长度奇偶分别判断
        return (ans == x || ans / 10 == x);
    }

    //①.反转数字后与原数比较：考虑溢出情况
    private static boolean checkPalindromeByReserve(int x) {
        if(x < 0) {
            return false;
        }
        long ans = x, ansPalindrome = 0;
        while(x != 0) {
            ansPalindrome = ansPalindrome * 10 + x % 10;
            x = x / 10;
        }
        return ans == ansPalindrome;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
    }
}
