package leetcode;

import javafx.util.Pair;
import leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @author yuanjie 2020/02/10 17:37
 */
public class MaximumDepthOfBinaryTree {
    private static int maxDepthNum = 1;

    private static int maxDepth(TreeNode root) {
        return maxDepthByBFS(root);
//        return maxDepthByDFS(root);
//        return maxDepthByDFSOptimization(root);
    }

    // 广度优先遍历, 存储所有节点的深度, 每向下遍历一层深度+1
    private static int maxDepthByBFS(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        int maxDepth = 1;
        Pair<TreeNode, Integer> pair = new Pair<>(treeNode, 1); // pair存储key-value
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(pair);
        while(!queue.isEmpty()) {
            pair = queue.poll();
            treeNode = pair.getKey();
            if(treeNode == null) {
                continue;
            }

            maxDepth = Math.max(maxDepth, pair.getValue());
            queue.offer(new Pair<>(treeNode.left, pair.getValue()+1));
            queue.offer(new Pair<>(treeNode.right, pair.getValue()+1));
        }
        return maxDepth;
    }

    // 利用递归进行深度遍历, 每次往下遍历时层级递增, 遍历到页节点时记录深度并回溯
    private static int maxDepthByDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        recursive(root, 1);
        return maxDepthNum;
    }

    private static void recursive(TreeNode t1, int curDepthNum) {
        if(t1 == null) {
            return;
        }

        if(t1.left == null && t1.right == null) {
            maxDepthNum = Math.max(curDepthNum, maxDepthNum);
            return;
        }

        recursive(t1.left, curDepthNum+1);
        recursive(t1.right, curDepthNum+1);
    }

    // H = max(H(left)+H(right)) + 1
    private static int maxDepthByDFSOptimization(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }

        int h1 = maxDepthByDFSOptimization(treeNode.left);
        int h2 = maxDepthByDFSOptimization(treeNode.right);
        return Math.max(h1, h2) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(maxDepth(root));
    }
}
