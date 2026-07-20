class Solution {
    Integer dp[][][];
    public int fun(int n,int id,int f){
        if(n==0){
            if(f==1){
                return 1;
            }
            return 0;
        }
        if(id==0) return 0;
        if(dp[n][id][f]!=null){
            return dp[n][id][f];
        }
        int a=1;
        int b=1;
        a=Math.max(a,fun(n,id-1,f));
        if(n-id>=0){
            a=Math.max(a,id*Math.max(fun(n-id,id,1),fun(n-id,id-1,1)));
        }
        return dp[n][id][f]=a;
    }
    public int integerBreak(int n) {
        dp=new Integer[n+1][n+1][2];
        return fun(n,n-1,0);
    }
}