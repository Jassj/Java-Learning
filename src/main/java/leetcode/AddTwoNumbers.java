package leetcode;

/**
 * @author yuanjie
 * @description:Completed
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * My Test Case
 * Input: (2 -> 4) + (5 -> 6 -> 9 -> 9)
 * Output: 7 -> 0 -> 0 -> 0 -> 1
 * Explanation: 42 + 9965 = 10007.
 * <p>考虑用例2的情况：最后一位相加为0需要进位
 * @date 2019/10/28 17:47
 */
public class AddTwoNumbers {

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0); //初始化结果链表
        ListNode resultListCopy = resultList;//指向堆中同一个对象,resultListCopy依次往下构造结果链
        int carryDigit = 0;
        while (l1 != null | l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carryDigit;
            if(sum >= 10) {
                sum -= 10;
                carryDigit = 1;
            } else {
                carryDigit = 0;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            resultListCopy.val = sum;
            if(!(l1 == null && l2 == null)) { //终止时不进位
                resultListCopy.next = new ListNode(0);
                resultListCopy = resultListCopy.next;
            }
        }
        if (carryDigit == 1) {
            resultListCopy.next = new ListNode(1);
        }
        return resultList;
    }

    public static void main(String[] args) {
//        用例1
//        ListNode l1 =  new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 =  new ListNode(5, new ListNode(6, new ListNode(4)));
//        用例2
        ListNode l1 =  new ListNode(2, new ListNode(4));
        ListNode l2 =  new ListNode(5, new ListNode(6, new ListNode(9 , new ListNode(9))));
        addTwoNumbers(l1, l2);
    }
}
