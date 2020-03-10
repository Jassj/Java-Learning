package leetcode.demo;

import leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * description:
 * 二叉树：深度优先(先中后序遍历)与广度优先遍历
 *     1
 *    / \
 *   2   3
 *  / \ / \
 * 4  7 6  5
 * @author yuanjie 2020/02/10 20:23
 */
public class BinaryTree {

    public static void binaryTreeSearch(TreeNode root) {
//        binaryTreeDFSByPreOrder(root);
//        binaryTreeDFSByPreOrderRecursive(root);
//        binaryTreeDFSByInOrder(root);
//        binaryTreeDFSByInOrderRecursive(root);
        binaryTreeDFSByPostOrder(root);
//        binaryTreeDFSByPostOrderRecursive(root);
//        binaryTreeBFS(root);
    }

    // 先(根/序)遍历二叉树(非递归、使用栈存储)：初始压入根节点，后续每次弹出节点时，依次压入右节点和左节点
    private static void binaryTreeDFSByPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        System.out.print("start-->");
        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();
            if(treeNode == null) {
                continue;
            }
            System.out.print(treeNode.val+"-->");
            stack.push(treeNode.right);
            stack.push(treeNode.left);
        }
        System.out.print("end");
    }

    // 先(根/序)遍历二叉树(递归)
    private static void binaryTreeDFSByPreOrderRecursive(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.print(treeNode.val+"-->");
        binaryTreeDFSByPreOrderRecursive(treeNode.left);
        binaryTreeDFSByPreOrderRecursive(treeNode.right);
    }

    // 中(根/序)遍历二叉树(非递归)：依次将当前节点的左节点压入栈中，后取栈顶值输出，并将当前节点定位置右节点
    private static void binaryTreeDFSByInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()) {
            while(curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val+"-->");
            curNode = treeNode.right;
        }
    }

    // 中(根/序)遍历二叉树(递归)
    private static void binaryTreeDFSByInOrderRecursive(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        binaryTreeDFSByInOrderRecursive(treeNode.left);
        System.out.print(treeNode.val+"-->");
        binaryTreeDFSByInOrderRecursive(treeNode.right);
    }

    // 后(根/序)遍历二叉树(非递归) Todo 待补充完善
    private static void binaryTreeDFSByPostOrder(TreeNode root) {
    }

    // 后(根/序)遍历二叉树(递归)
    private static void binaryTreeDFSByPostOrderRecursive(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        binaryTreeDFSByPostOrderRecursive(treeNode.left);
        binaryTreeDFSByPostOrderRecursive(treeNode.right);
        System.out.print(treeNode.val+"-->");
    }

    // 广度优先遍历(使用队列进行存储)：按照从上向下、从左往右的顺序遍历
    private static void binaryTreeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("start-->");
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if(treeNode == null) {
                continue;
            }
            System.out.print(treeNode.val+"-->");
            queue.offer(treeNode.left);
            queue.offer(treeNode.right);
        }
        System.out.print("end");
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(7)),
                new TreeNode(3, new TreeNode(6), new TreeNode(5)));
        binaryTreeSearch(treeNode);
    }
}
