class Solution {
    HashMap<String,Integer>map=new HashMap<>();
    List<TreeNode>ans=new ArrayList<>();
    public String fun(TreeNode root){
        if(root==null) return "#";
        String l=fun(root.left);
        String r=fun(root.right);
        String s=root.val+","+l+","+r;
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2){
            ans.add(root);
        }
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        fun(root);
        return ans;
    }
}