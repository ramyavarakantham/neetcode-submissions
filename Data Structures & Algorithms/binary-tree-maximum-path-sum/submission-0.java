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
    public int maxPathSum(TreeNode root) {
        int[] maxPathSumSoFar = new int[1];
        maxPathSumSoFar[0] = Integer.MIN_VALUE;
        dfs(root, maxPathSumSoFar);

        return maxPathSumSoFar[0];
    }

    int dfs(TreeNode node, int[] maxPathSumSoFar){
        if(node == null){
            return 0;
        }

        int leftGain = Math.max(0, dfs(node.left, maxPathSumSoFar));
        int rightGain = Math.max(0, dfs(node.right, maxPathSumSoFar));

        maxPathSumSoFar[0] = Math.max(maxPathSumSoFar[0], node.val + leftGain + rightGain);

        return node.val + Math.max(leftGain, rightGain);


    }
}
