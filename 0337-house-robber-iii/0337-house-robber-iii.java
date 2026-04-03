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
    HashMap<String,Integer>map=new HashMap<>();
    public int fun(TreeNode root,int turn){
        if(root==null){
            return 0;
        }
        int a=0;
        int b=0;
        String s=root+","+turn;
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(turn==1){
            int a1=root.val+fun(root.left,0)+fun(root.right,0);
            int b1=fun(root.left,1)+fun(root.right,1);
            a=Math.max(a1,b1);
        }
        else{
            int a1=fun(root.left,1)+fun(root.right,1);
            int b1=fun(root.left,0)+fun(root.right,0);
            b=Math.max(a1,b1);
        }
        int ans=Math.max(a,b);
        map.put(s,ans);
        return ans;
    }
    public int rob(TreeNode root) {
        int a=fun(root,1);
        map.clear();
        int b=fun(root,0);
        return Math.max(a,b);
    }
}