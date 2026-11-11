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

class Solution {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    boolean isValidBST(TreeNode node, int minVal, int maxVal){
        if(node == null){
            return true;
        }

        return (node.val > minVal && node.val < maxVal) && isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
    }
}
