class Solution {
    int dp[][][];
    public int fun(int arr[],int id,int n,int turn,int m){
        if(id==n){
            return 0;
        }
        if(dp[id][turn][m]!=-1){
            return dp[id][turn][m];
        }
        int c=0;
        int a=0;
        int b=0;
        if(turn==1){
            int sum=0;
            for(int i=id;i<id+2*m && i<n;i++){
                c=i-id+1;
                sum+=arr[i];
                int nm=Math.max(c,m);
                a=Math.max(a,sum+fun(arr,i+1,n,0,nm));
            }
        }
        else{
            b=Integer.MAX_VALUE;
            for(int i=id;i<id+2*m && i<n;i++){
                c=i-id+1;
                int nm=Math.max(c,m);
                b=Math.min(b,fun(arr,i+1,n,1,nm));
            }
        }
        return dp[id][turn][m]=(turn==1)?a:b;
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        dp=new int[n+1][2][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<n+1;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return fun(piles,0,n,1,1);
    }
}