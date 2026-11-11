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
        HashMap<Node, Node> hm = new HashMap<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(node);
        hm.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node currNode = q.poll();
            for(Node neighbor: currNode.neighbors){
                if(!hm.containsKey(neighbor)){
                    q.offer(neighbor);
                    hm.put(neighbor, new Node(neighbor.val));
                }
                hm.get(currNode).neighbors.add(hm.get(neighbor));
            }
        }
        return hm.get(node);
    }
}