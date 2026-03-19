class Solution {
    int min;
    int res;
    public void fun(ArrayList<ArrayList<Integer>>adj,int node,int quiet[],boolean vis[]){
        vis[node]=true;
        if(quiet[node]<min){
            min=quiet[node];
            res=node;
        }
        for(int x:adj.get(node)){
            if(!vis[x]){
                fun(adj,x,quiet,vis);
            }
        }
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int ar[]:richer){
            adj.get(ar[1]).add(ar[0]);
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(adj.get(i).size()==0){
                ans[i]=i;
            }
            else{
                boolean vis[]=new boolean[n];
                min=quiet[i];
                res=i;
                fun(adj,i,quiet,vis);
                ans[i]=res;
            }
        }
        return ans;
    }
}