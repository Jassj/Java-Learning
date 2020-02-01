package leetcode;

import leetcode.bean.ListNode;

/**
 * description：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author yuanjie 2020/02/01 12:04
 */
public class MergeSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoListsByRecursive(l1, l2);
//        return mergeTwoListsByIteration(l1, l2);
    }

    //递归法：根据l1和l2的链表头确定起点，然后依次递归将两个链表连接起来，构成新的有序链表
    private static ListNode mergeTwoListsByRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoListsByRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursive(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代法：依次遍历两个链表，按数值升序将合并入新的链表中，直接两个链表都遍历结束
     * ①.当一个链表遍历结束后，可直接将剩余列表合并入新列表中
     */
    private static ListNode mergeTwoListsByIteration(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        ListNode l3 = new ListNode(-1);
        ListNode flag = l3; //链表追踪对象
        while(l1 != null && l2 != null) {

            if(l1.val < l2.val)  {
                flag.next = l1;
                l1 = l1.next;
            } else {
                flag.next = l2;
                l2 = l2.next;
            }

            flag = flag.next;
        }
        flag.next = l1 == null ? l2 : l1; //剩余链表直接合并
        return l3.next;
    }

    public static void main(String[] args) {
//        ListNode l1 =  new ListNode(1, new ListNode(3));
//        ListNode l2 =  new ListNode(2, new ListNode(3, new ListNode(4 , new ListNode(5))));
//        mergeTwoLists(l1, l2);
    }
}
