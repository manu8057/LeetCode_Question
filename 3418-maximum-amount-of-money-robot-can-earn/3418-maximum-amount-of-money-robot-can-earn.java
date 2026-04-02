class Solution {
    boolean vis[][];
    Integer dp[][][];
    public int fun(int r,int c,int n,int m,int coins[][],int neg){
        if(r<0 || c<0 || r>=n || c>=m || vis[r][c]){
            return Integer.MIN_VALUE;
        }
        if(dp[r][c][neg]!=null){
            return dp[r][c][neg];
        }
        if(r==n-1 && c==m-1){
            if(coins[r][c]<0 && neg<2){
                return 0;
            }
            else{
                return coins[r][c];
            }
        }
        vis[r][c]=true;
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        if(coins[r][c]<0){
            if(neg<2){
                a=Math.max(fun(r+1,c,n,m,coins,neg+1),fun(r,c+1,n,m,coins,neg+1));
            }
            a=Math.max(a,coins[r][c]+Math.max(fun(r+1,c,n,m,coins,neg),fun(r,c+1,n,m,coins,neg)));
        }
        else{
            b=coins[r][c]+Math.max(fun(r+1,c,n,m,coins,neg),fun(r,c+1,n,m,coins,neg));
        }
        vis[r][c]=false;
        return dp[r][c][neg]=Math.max(a,b);
    }
    public int maximumAmount(int[][] coins) {
        int n=coins.length;
        int m=coins[0].length;
        vis=new boolean[n][m];
        dp=new Integer[n+1][m+1][3];
        return fun(0,0,n,m,coins,0);
    }
}