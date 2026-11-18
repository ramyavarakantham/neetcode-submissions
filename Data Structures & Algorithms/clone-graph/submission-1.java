/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node, Node> hm= new HashMap<>();
        hm.put(node, new Node(node.val));
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node currNode = q.pollFirst();
            for(Node n:currNode.neighbors){
                if(!hm.containsKey(n)){
                    hm.put(n, new Node(n.val));
                    q.offer(n);
                }
                hm.get(currNode).neighbors.add(hm.get(n));
            }
        }
        return hm.get(node);
        
    }
}