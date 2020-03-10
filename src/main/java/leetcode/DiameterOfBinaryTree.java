package leetcode;

import leetcode.bean.TreeNode;

/**
 * description:
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \                              (4,3)
 *         2   3                    2(3,2)           (1,0)
 *        / \
 *       4   5                  4(1,0)  5(1,0)
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @author yuanjie 2020/03/05 14:58
 */
public class DiameterOfBinaryTree {
    private static int diameter;

    private static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        diameterOfBinaryTreeByRecursive(root);
        return diameter;
    }

    // 分治法：递归进行深度遍历，每个节点的直径=左节点深度+右节点深度，取最大直径即可
    private static int diameterOfBinaryTreeByRecursive(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        int left = diameterOfBinaryTreeByRecursive(treeNode.left);
        int right = diameterOfBinaryTreeByRecursive(treeNode.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(treeNode));
    }
}
