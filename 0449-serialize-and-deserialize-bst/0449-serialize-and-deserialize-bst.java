/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "#";
        String l=serialize(root.left);
        String r=serialize(root.right);
        return root.val+","+l+","+r;
    }

    // Decodes your encoded data to tree.
    int i=0;
    public TreeNode fun(String arr[]){
        if(arr[i].equals("#")){
            i++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left=fun(arr);
        root.right=fun(arr);
        return root;
    }
    public TreeNode deserialize(String data) {
        String arr[]=data.split(",");
        return fun(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;