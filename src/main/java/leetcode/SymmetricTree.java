package leetcode;

/**
 * @author yuanjie
 * @description
 * @date 2019/10/25 17:41
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

//    public static void main(String[] args) {
//        TreeNode root = ;
//        root.val = 1;
//    }
}

class TreeNode { //可能为叶节点(存在左右节点),根节点(无左右节点)
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
