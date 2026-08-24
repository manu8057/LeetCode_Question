class Solution {
    public int find(int pr[],int i){
        if(pr[i]==i){
            return i;
        }
        return pr[i]=find(pr,pr[i]);
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int fr[]=new int[n];
        int pr[]=new int[n];
        for(int i=0;i<n;i+=1){
            pr[i]=i;
            fr[i]=1;
        }
        for(int id=0;id<n;id++){
            for(int i=0;i<n;i+=1){
                if(isConnected[id][i]==1 && id!=i){
                     int a=find(pr,id);
                     int b=find(pr,i);
                     if(a!=b){
                        if(fr[a]>fr[b]){
                            pr[b]=pr[a];
                            fr[a]+=fr[b];
                        }
                        else{
                            pr[a]=pr[b];
                            fr[b]+=fr[a];
                        }
                     }
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i+=1){
            if(find(pr,i)==i) ans++;
        }
        return ans;
    }
}