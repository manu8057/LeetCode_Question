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
    public TreeNode recoverFromPreorder(String s) {
        Stack<TreeNode>st=new Stack();
        TreeNode root=new TreeNode(-1);
        int n=s.length();
        int i=0;
        while(i<n){
            int c=0;
            while(i<n && s.charAt(i)=='-'){
                c++;
                i++;
            }
            int val=0;
            while(i<n && s.charAt(i)!='-'){
                val=val*10+(s.charAt(i)-'0');
                i++;
            }
            while(st.size()>c){
                st.pop();
            }
            if(st.isEmpty()){
                root=new TreeNode(val);
                st.push(root);
            }
            else{
                TreeNode pr=st.peek();
                TreeNode node=new TreeNode(val);
                if(pr.left==null){
                    pr.left=node;
                }
                else{
                    pr.right=node;
                }
                st.push(node);
            }
        }
        return root;
    }
}