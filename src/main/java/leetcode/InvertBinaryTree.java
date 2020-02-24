package leetcode;

import leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author yuanjie 2020/02/23 17:21
 */
public class InvertBinaryTree {

    private static TreeNode invertTree(TreeNode root) {
        return invertTreeByIteration(root);
//        return invertTreeRecursive(root);
    }

    // 迭代法：使用队列进行迭代，每次出一个节点，交换其左右节点，后将其左右节点放入队列
    private static TreeNode invertTreeByIteration(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode tempNode = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tempNode;
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        return root;
    }

    // 递归：递归每个节点对应的左右节点，回溯时从叶节点开始向上至根节点，每层左右依次翻转，因此除根节点以外的所有节点都会翻
    private static TreeNode invertTreeRecursive(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }
        TreeNode left = invertTreeRecursive(treeNode.left);
        TreeNode right = invertTreeRecursive(treeNode.right);
        treeNode.left = right;
        treeNode.right = left;
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(root.left.val + "---" + root.right.val);
        TreeNode reversedRoot = invertTree(root);
        System.out.println(reversedRoot.left.val + "---" + reversedRoot.right.val);
    }
}
