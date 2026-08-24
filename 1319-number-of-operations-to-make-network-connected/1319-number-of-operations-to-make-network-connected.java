class Solution {
    public int find(int pr[],int i){
        if(pr[i]==i){
            return i;
        }
        return pr[i]=find(pr,pr[i]);
    }
    public int makeConnected(int n, int[][] connections) {
        int pr[]=new int[n];
        int fr[]=new int[n];
        if(connections.length<n-1){
            return -1;
        }
        for(int i=0;i<n;i+=1){
            pr[i]=i;
            fr[i]=1;
        }
        for(int ar[]:connections){
            int a=find(pr,ar[0]);
            int b=find(pr,ar[1]);
            if(a!=b){
                if(fr[a]>fr[b]){
                    fr[a]+=fr[b];
                    pr[b]=pr[a];
                }
                else{
                    pr[a]=pr[b];
                    fr[b]+=fr[a];
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i+=1){
            if(find(pr,i)==i){
                ans+=1;
            }
        }
        return ans-1;
    }
}