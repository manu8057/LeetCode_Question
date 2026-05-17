class Solution {
    Boolean dp[];
    public boolean fun(int arr[],int i,int n,boolean vis[]){
        if(arr[i]==0) return true;
        boolean a=false;
        boolean b=false;
        vis[i]=true;
        if(dp[i]!=null) return dp[i];
        if(i>=arr[i] && !vis[i-arr[i]]){
            a=fun(arr,i-arr[i],n,vis);
        }
        if(arr[i]+i<n && !vis[arr[i]+i]){
            b=fun(arr,i+arr[i],n,vis);
        }
        return dp[i]=a||b;
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean vis[]=new boolean[n];
        dp=new Boolean[n+1];
        return fun(arr,start,n,vis);
    }
}