class Solution {
    public Boolean fun(int node,int tr,ArrayList<ArrayList<Integer>>adj,boolean vis[]){
        vis[node]=true;
        if(node==tr){
            return true;
        }
        for(int x:adj.get(node)){
            if(!vis[x]){
                if(fun(x,tr,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] arr, int[][] queries) {
        int len=arr.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int ar[]:arr){
            adj.get(ar[0]).add(ar[1]);
        }
        List<Boolean>ans=new ArrayList<>();
        for(int aap[]:queries){
            boolean vis[]=new boolean[n];
            ans.add(fun(aap[0],aap[1],adj,vis));
        }
        return ans;
    }
}