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
    int c=0;
    public int sum(TreeNode root){
        if(root==null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    public int len(TreeNode root){
        if(root==null) return 0;
        int l=len(root.left);
        int h=len(root.right);
        return 1+l+h;
    }
    public void count(TreeNode root){
        if(root==null) return;
        int add=sum(root);
        int n=len(root);
        if(root.val==add/n){
            c++;
        }
        count(root.left);
        count(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        count(root);
        return c;
    }
}