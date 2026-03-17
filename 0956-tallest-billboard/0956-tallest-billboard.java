class Solution {
    int dp[][];
    int off=5000;
    public int fun(int i,int dif,int n,int[] rods){
        if(i==n){
            if(dif==0){
                return 0;
            }
            else{
                return -10001;
            }
        }
        if(dp[i][dif+off]!=-1){
            return dp[i][dif+off];
        }
        int a=fun(i+1,dif,n,rods);
        int b=rods[i]+fun(i+1,dif+rods[i],n,rods);
        int c=fun(i+1,dif-rods[i],n,rods);
        return dp[i][dif+off]=Math.max(a,Math.max(b,c));
    }
    public int tallestBillboard(int[] rods) {
        int n=rods.length;
        dp=new int[n+1][10001];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        int a=fun(0,0,n,rods);
        if(a<0){
            return 0;
        }
        return a;
    }
}