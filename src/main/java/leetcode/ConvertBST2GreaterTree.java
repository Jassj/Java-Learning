package leetcode;

import leetcode.bean.TreeNode;
import leetcode.dataStructure.BinaryTree;

import java.util.Stack;

/**
 * description
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @author yuanjie 2020/03/03 15:41
 */
public class ConvertBST2GreaterTree {
    private static int val = 0;

    // 二叉搜索树的性质：左节点 < 根节点 < 右节点
    private static TreeNode convertBST(TreeNode root) {
//        return convertBSTByRecursive(root);
        return convertBSTByIteration(root);
    }

    // 利用栈迭代遍历二叉搜索树：遍历顺序 右节点-->根节点-->左节点, 按照节点值降序遍历
    private static TreeNode convertBSTByIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        int sum = 0;
        while(curNode != null || !stack.isEmpty()) {
            while(curNode != null) {
                stack.push(curNode);
                curNode = curNode.right;
            }

            TreeNode treeNode = stack.pop();
            sum += treeNode.val;
            treeNode.val = sum;
            curNode = treeNode.left;
        }
        return root;
    }

    // 递归转换成累加树时：遍历顺序 右节点-->根节点-->左节点, 按照节点值降序遍历
    private static TreeNode convertBSTByRecursive(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }

        convertBSTByRecursive(treeNode.right);
        treeNode.val += val;
        val = treeNode.val;
        convertBSTByRecursive(treeNode.left);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10, new TreeNode(8, new TreeNode(4), new TreeNode(9)),
                new TreeNode(12, new TreeNode(11), new TreeNode(13)));
        treeNode = convertBST(treeNode);
        BinaryTree.binaryTreeSearch(treeNode); // 深度优先遍历累加树
    }
}
