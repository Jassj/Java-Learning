package leetcode;

import leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author yuanjie 2019/10/25 17:41
 */
public class SymmetricTree {

    private static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricByIteration(root);
//        return isSymmetricByRecursive(root.left, root.right);
    }

    // 递归法判断是否为对称二叉树
    private static boolean isSymmetricByRecursive(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }

        if(t1 == null || t2 ==null) {
            return false;
        }

        if(t1.val != t2.val) {
            return false;
        }

        return isSymmetricByRecursive(t1.left, t2.right) && isSymmetricByRecursive(t1.right, t2.left);
    }

    // 使用队列存储断、迭代法进行广度优先遍历：判断每一级的树节点是否不对称的，如果存在不对称的情况则终止，否则继续
    private static boolean isSymmetricByIteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root.left == null && root.right == null) {
            return true;
        }
        if(root.left == null || root.right == null) {
            return false;
        }
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) { // 每次取队列中连续的两个节点比较且放入队列时按照左右对称顺序
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) {
                continue;
            }
            if(t1 == null || t2 == null) {
                return false;
            }
            if(t1.val != t2.val) {
                return false;
            }
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(""+isSymmetric(root));
    }
}
