package leetcode.bean;

/**
 * description:
 * 公用实体类：链表
 * @author yuanjie 2020/02/01 12:06
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
