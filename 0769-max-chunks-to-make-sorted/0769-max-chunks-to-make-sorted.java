class Solution {
    public boolean fun(boolean vis[],int n){
        for(int i=0;i<=n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        boolean vis[]=new boolean[n+1];
        int i=0;
        int ans=0;
        int max=0;
        while(i<n){
            vis[arr[i]]=true;
            max=Math.max(arr[i],max);
            if(fun(vis,max)){
                ans+=1;
            }
            i+=1;
        }
        return ans;
    }
}