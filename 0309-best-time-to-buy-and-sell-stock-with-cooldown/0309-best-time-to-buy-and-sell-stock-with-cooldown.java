class Solution {
    Integer dp[][];
    public int fun(int id,int buy,int n,int[] arr){
        if(id>=n){
            return 0;
        }
        if(dp[id][buy]!=null){
            return dp[id][buy];
        }
        int a=0;
        int b=0;
        if(buy==0){
            a=Math.max(-arr[id]+fun(id+1,1,n,arr),fun(id+1,0,n,arr));
        }
        else{
            b=Math.max(arr[id]+fun(id+2,0,n,arr),fun(id+1,1,n,arr));
        }
        return dp[id][buy]=Math.max(a,b);
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new Integer[n+1][2];
        return fun(0,0,n,prices);
    }
}