package leetcode;

/**
 * 求正整数的线段值的最大乘积
 * @author yuanjie 2021/02/08 15:53
 */
public class MaxProductOfSegmentValue {

    public static Integer getResult(int num) {
        System.out.println(num);
        if(num == 1) {
            return 1;
        }
        if(num == 2) {
            return 2;
        }
        if(num == 3) {
            return 3;
        }
        int max = Math.max(getResult(num - 2) * 2, getResult(num - 3) * 3);
        System.out.println("num: " + num + ", max: " + max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getResult(25));
    }

}
