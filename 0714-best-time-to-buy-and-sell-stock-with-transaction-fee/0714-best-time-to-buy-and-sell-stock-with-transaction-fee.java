class Solution {
    Integer dp[][];
    public int fun(int id,int buy,int n,int arr[],int f){
        if(id>=n){
            return 0;
        }
        if(dp[id][buy]!=null){
            return dp[id][buy];
        }
        int a=0;
        int b=0;
        if(buy==0){
            a=Math.max(-arr[id]+fun(id+1,1,n,arr,f),fun(id+1,0,n,arr,f));
        }
        else{
            b=Math.max(arr[id]-f+fun(id+1,0,n,arr,f),fun(id+1,1,n,arr,f));
        }
        return dp[id][buy]=Math.max(a,b);
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        dp=new Integer[n+1][2];
        return fun(0,0,n,prices,fee);
    }
}