class Solution {
    Long dp[][];
    public long fun(int id,int n,int nums[],int turn){
        if(id>=n){
            return 0;
        }
        if(dp[id][turn]!=null){
            return dp[id][turn];
        }
        long a=0;
        long b=0;
        if(turn==0){
            a=Math.max((long)nums[id]+fun(id+1,n,nums,1),fun(id+1,n,nums,0));
        }
        else{
            b=Math.max(-(long)nums[id]+fun(id+1,n,nums,0),fun(id+1,n,nums,1));
        }
        return dp[id][turn]=Math.max(a,b);
    }
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        dp=new Long[n+1][2];
        return fun(0,n,nums,0);
    }
}