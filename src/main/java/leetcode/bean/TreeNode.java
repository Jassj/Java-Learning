package leetcode.bean;

/**
 * description
 * 公用实体类：二叉树
 * @author yuanjie 2020/02/03 21:17
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
