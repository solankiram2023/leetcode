

// import com.sun.tools.javac.tree.TreeInfo;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

final class TreeInfo{
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced){
        this.height=height;
        this.balanced=balanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
        
    }

    private TreeInfo isBalancedTreeHelper(TreeNode root){
        if(root==null){
            return new TreeInfo(-1, true);
        }
        TreeInfo left = isBalancedTreeHelper(root.left);
        if(!left.balanced){
            return new TreeInfo(-1,false);
        }

        TreeInfo right = isBalancedTreeHelper(root.right);
        if(!right.balanced){
            return new TreeInfo(-1, false);
        }

        if(Math.abs(left.height-right.height)<2){
            int currentHeight = Math.max(left.height, right.height)+1;
            return new TreeInfo(currentHeight, true);
        }
        return new TreeInfo(-1,false);
    }

}
