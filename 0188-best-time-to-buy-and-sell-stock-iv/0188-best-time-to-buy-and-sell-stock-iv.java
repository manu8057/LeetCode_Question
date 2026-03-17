class Solution {
    int dp[][][];
    public int fun(int i,int arr[],int buy,int tr,int k){
        if(tr==k){
            return 0;
        }
        if(i==arr.length){
            return 0;
        }
        if(dp[i][buy][tr]!=-1){
            return dp[i][buy][tr];
        }
        int in=0;
        int ex=0;
        if(buy==0){
            in=Math.max(-arr[i]+fun(i+1,arr,1,tr,k),fun(i+1,arr,0,tr,k));
        }
        else{
            ex=Math.max(arr[i]+fun(i+1,arr,0,tr+1,k),fun(i+1,arr,1,tr,k));
        }
        return dp[i][buy][tr]=Math.max(in,ex);
    }
    public int maxProfit(int k,int[] arr) {
        int n=arr.length;
        dp=new int[n+1][2][k+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                for(int lm=0;lm<k+1;lm++){
                    dp[i][j][lm]=-1;
                }
            }
        }
        return fun(0,arr,0,0,k);
    }
}