package leetcode;

import leetcode.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * description
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * @author yuanjie 2020/02/14 10:37
 */
public class LinkedListCycle {

    /**
     * 当单向链表中有环时：半闭合环(非head节点为起止的环)、全闭合环(以head节点起止的环)
     * ①.任一节点的next不为空
     * */
    private static boolean hasCycle(ListNode head) {
//        return hasCycleByHashSet(head);
        return hasCycleBySlowFastPointer(head);
    }

    // 使用快慢指针法：慢指针每次向下移动一，快指针每次向下移动二，当快慢指针相遇时，证明链表时环形的
    private static boolean hasCycleBySlowFastPointer(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 使用map存储相关节点, 当存在回路时, 同一节点会遍历到两次
    private static boolean hasCycleByHashSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 =  new ListNode(1);
        ListNode l2 =  new ListNode(2);
        l1.next = l2;
        l2.next = l1;
        System.out.println(hasCycle(l1));
    }
}
