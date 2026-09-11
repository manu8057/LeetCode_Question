class Solution {
    Integer dp[][][];
    public int fun(int id,int arr[],int buy,int k){
        if(k==0){
            return 0;
        }
        if(id==arr.length) return 0;
        if(dp[id][k][buy]!=null){
            return dp[id][k][buy];
        }
        if(buy==0){
            return dp[id][k][buy]=Math.max(-arr[id]+fun(id+1,arr,1,k),fun(id+1,arr,0,k));
        }
        else{
            return dp[id][k][buy]=Math.max(arr[id]+fun(id+1,arr,0,k-1),fun(id+1,arr,1,k));
        }
    }
    public int maxProfit(int k, int[] prices) {
        dp=new Integer[prices.length+1][k+1][2];
        return fun(0,prices,0,k);
    }
}