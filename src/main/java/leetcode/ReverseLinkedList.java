package leetcode;

import leetcode.bean.ListNode;

import java.util.Stack;

/**
 * description
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author yuanjie 2020/02/20 17:10
 */
public class ReverseLinkedList {

    // ①.反转链表时注意不要产生环
    // ②.注意空链表的情况
    private static ListNode reverseList(ListNode head) {
        return reverseListByRecursive(head);
//        return reverseListByIteration(head);
//        return reverseListByOptimizationIteration(head);
    }

    // 遍历时直接组成新链表，不借助栈，减少额外的空间消耗
    private static ListNode reverseListByOptimizationIteration(ListNode head) {
        ListNode preNode = null; // 前序指针节点
        ListNode curNode = head; // 当前指针节点

        while(curNode != null) { // 每次向下遍历节点
            ListNode nextTemp = curNode.next; // 存储后续节点
            curNode.next = preNode; // 当前节点的后续节点指向前，相当于进行反转
            preNode = curNode; // 前序指针后移
            curNode = nextTemp; // 当前节点后移
        }

        return preNode;
    }

    // 迭代法：遍历链表压入栈中，然后依次从栈中取出元素组成新链表
    private static ListNode reverseListByIteration(ListNode head) {
        if(head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        while(head.next != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode newListNode = new ListNode(head.val);
        ListNode newHead = newListNode;
        while(!stack.isEmpty()) {
            newListNode.next = new ListNode(stack.pop().val);
            newListNode = newListNode.next;
        }
        return newHead;
    }

    /**
     * 递归法：5-->6-->9-->7-->null
     * 递归回溯时，记录最后一个节点并返回给调用方法，此为反转链表的头结点
     * 回溯时处理情况：
     * ①.7.next = nulls 时回溯，此时listNode为9， 需要将7指向9：因此 9.next.next <==> 7.next = 9
     * ②.切断9指向7的连接，否则会产生环，因此9.next = null
     */
    private static ListNode reverseListByRecursive(ListNode listNode) {
        if(listNode == null || listNode.next == null) {
            return listNode;
        }

        ListNode newListNode = reverseListByRecursive(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return newListNode;
    }

    public static void main(String[] args) {
        ListNode list =  new ListNode(5, new ListNode(6, new ListNode(9 , new ListNode(7))));
        ListNode newList = reverseList(list);
    }
}
