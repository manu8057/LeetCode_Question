class Solution {
    // Boolean dp[][][][];
    public boolean fun(int i,int n,int nums[],int d,int r,int t){
        if(i>r){
            return d>=0;
        }
        // if(dp[i][d][r][t]!=null){
        //     return dp[][][][];
        // }
        if(t==0){
            return fun(i+1,n,nums,d+nums[i],r,1) || fun(i,n,nums,d+nums[r],r-1,1);
        }
        else{
            return fun(i+1,n,nums,d-nums[i],r,0) && fun(i,n,nums,d-nums[r],r-1,0);
        }
    }
    public boolean predictTheWinner(int[] nums){
        int n=nums.length;
        // dp=new Boolean[n+1][][][];
        return fun(0,nums.length,nums,0,nums.length-1,0);
    }
}