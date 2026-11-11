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
    public List<Integer> rightSideView(TreeNode root) {
        // Add only last node at each level
        List<Integer> rightSideNodes = new ArrayList<>();
        if(root == null){
            return rightSideNodes;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int numOfNodesAtCurrLevel = q.size();
            for(int i = 0; i < numOfNodesAtCurrLevel; i++){
                TreeNode node = q.poll();
                if(i == numOfNodesAtCurrLevel-1){
                    rightSideNodes.add(node.val);
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return rightSideNodes;
        
    }
}
