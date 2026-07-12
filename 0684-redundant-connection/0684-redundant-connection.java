class Solution {
    public int find(int i,int pr[]){
        if(pr[i]==i){
            return i;
        }
        return pr[i]=find(pr[i],pr);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int pr[]=new int[n+1];
        int fr[]=new int[n+1];
        for(int i=0;i<n+1;i++){
            pr[i]=i;
            fr[i]=1;
        }
        int ans[]=new int[2];
        for(int ar[]:edges){
            int a=ar[0];
            int b=ar[1];
            int ab=find(a,pr);
            int bb=find(b,pr);
            if(ab==bb){
                ans[0]=a;
                ans[1]=b;
            }
            else{
                if(fr[ab]>fr[bb]){
                    pr[bb]=pr[ab];
                    fr[ab]+=fr[bb];
                }
                else{
                    pr[ab]=pr[bb];
                    fr[bb]+=fr[ab];
                }
            }
        }
        return ans;
    }
}