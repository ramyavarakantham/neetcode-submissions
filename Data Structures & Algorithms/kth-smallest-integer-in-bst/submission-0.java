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
    public int kthSmallest(TreeNode root, int k) {
        // Inorder traversal
        // count k - to return kth smallest non-sealed
        int[] arr = new int[2]; // pass by value - a copy of primitive is sent
        arr[0] = k;
        inorder(root, arr);
        return arr[1];
    }

    void inorder(TreeNode node, int[] arr){ // changes made to the primitve are local
        if(node == null) {
            return;
        }

        inorder(node.left, arr);
        arr[0] -= 1; // processing the current node- reduce count
        if(arr[0] == 0){
            arr[1] = node.val;
            return;
        }
        inorder(node.right, arr);
    }
}
