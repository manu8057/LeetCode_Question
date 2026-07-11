class Solution {
    public void fun(int el,int[] vis,ArrayList<ArrayList<Integer>>adj,int id){
        vis[el]=id;
        for(int x:adj.get(el)){
            if(vis[x]==0){
                fun(x,vis,adj,id);
            }
        }
    }
    public int fun2(int key,HashMap<Integer,ArrayList<Integer>>map,ArrayList<ArrayList<Integer>>adj){
        int size=map.get(key).size();
        for(int el:map.get(key)){
            if(adj.get(el).size()!=(size-1)) return 0;
        }
        return 1;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int ar[]:edges){
            adj.get(ar[0]).add(ar[1]);
            adj.get(ar[1]).add(ar[0]);
        }
        int vis[]=new int[n];
        int id=1;
        int tt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                fun(i,vis,adj,id);
                tt++;
                id++;
            }
        }
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
             map.putIfAbsent(vis[i],new ArrayList<>());
             map.get(vis[i]).add(i);
        }
        int c=0;
        for(int u:map.keySet()){
            c+=fun2(u,map,adj);
        }
        return c;
    }
}