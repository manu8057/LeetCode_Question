class Solution {
    public int find(int i,int pr[]){
        if(pr[i]==i){
            return i;
        }
        return pr[i]=find(pr[i],pr);
    }
    public int makeConnected(int n, int[][] connections) {
        int tt=connections.length;
        if(tt<n-1){
            return -1;
        }
        int pr[]=new int[n];
        int sz[]=new int[n];
        for(int i=0;i<n;i++){
            pr[i]=i;
            sz[i]=1;
        }
        for(int ar[]:connections){
            int a=find(ar[0],pr);
            int b=find(ar[1],pr);
            if(a!=b){
                if(sz[a]>sz[b]){
                    pr[b]=pr[a];
                    sz[a]+=sz[b];
                }
                else{
                    pr[a]=pr[b];
                    sz[b]+=sz[a];
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(pr[i]==i){
                ans+=1;
            }
        }
        return ans-1;
    }
}