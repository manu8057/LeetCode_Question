/*
// Definition for a Node.
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
    HashMap<Integer,Node>map=new HashMap<>();
    public void fun(Node node){
        if(map.containsKey(node.val)){
            return;
        }
        Node n=new Node(node.val);
        map.put(node.val,n);
        for(Node el:node.neighbors){
            if(!map.containsKey(el.val)){
                fun(el);
            }
        }
        for(Node el:node.neighbors){
            n.neighbors.add(map.get(el.val));
        }
    }
    public Node cloneGraph(Node node){
        if(node==null) return null;
        fun(node);
        return map.get(node.val);
    }
}