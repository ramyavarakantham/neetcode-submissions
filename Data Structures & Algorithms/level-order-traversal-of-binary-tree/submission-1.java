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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> levelNodes = new ArrayList<>();
            int numOfLevelNodes = q.size();
            for(int i = 0; i < numOfLevelNodes; i++){
                TreeNode currNode = q.poll();
                levelNodes.add(currNode.val);
                if(currNode.left != null){
                    q.addLast(currNode.left);
                }
                if(currNode.right != null){
                    q.addLast(currNode.right);
                }
            }
            res.add(levelNodes);
        }
        return res;
        
    }
}
