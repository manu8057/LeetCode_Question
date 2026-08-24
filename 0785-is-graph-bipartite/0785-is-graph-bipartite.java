class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        Queue<int[]>q=new LinkedList<>();
        int vis[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]!=0) continue;
            q.add(new int[]{i,1});
            while(!q.isEmpty()){
                int ar[]=q.poll();
                int c=ar[1];
                if(vis[ar[0]]!=0){
                    if(vis[ar[0]]!=c) return false;
                    else continue;
                }
                vis[ar[0]]=c;
                for(int el:graph[ar[0]]){
                    if(vis[el]==0){
                        q.add(new int[]{el,c*-1});
                    }
                    else{
                        if(vis[el]==c){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}