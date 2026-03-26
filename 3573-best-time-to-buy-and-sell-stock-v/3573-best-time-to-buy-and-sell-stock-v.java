class Solution {
    Long dp[][][];
    long inf=1000000000000000L;
    public long fun(int id,int buy,int n,int arr[],int k){
        if(id>=n){
            if(buy==0) return 0;
            return -inf;
        }
        if(k<=0){
            if(buy==0) return 0;
            return -inf;
        }
        if(dp[id][buy][k]!=null) return dp[id][buy][k];
        long a=-inf;
        long b=-inf;
        long c=-inf;
        if(buy==0){
            long a1=-(long)arr[id]+fun(id+1,1,n,arr,k);
            long b1=(long)arr[id]+fun(id+1,2,n,arr,k);
            long c1=fun(id+1,0,n,arr,k);
            a=Math.max(a1,Math.max(b1,c1));
        }
        else if(buy==1){
            b=Math.max((long)arr[id]+fun(id+1,0,n,arr,k-1),
                       fun(id+1,1,n,arr,k));
        }
        else{
            c=Math.max(-(long)arr[id]+fun(id+1,0,n,arr,k-1),
                       fun(id+1,2,n,arr,k));
        }
        return dp[id][buy][k]=Math.max(a,Math.max(b,c));
    }
    public long maximumProfit(int[] prices,int k){
        int n=prices.length;
        dp=new Long[n+2][3][k+1];
        return fun(0,0,n,prices,k);
    }
}