class Solution {
    Integer dp[][];
    public int fun(int n,List<Integer>l,int target){
        if(n<0){
            if(target==0){
                return 0;
            }
            else{
                return -10001;
            }
        }
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        if(target>=l.get(n)){
            return dp[n][target]=Math.max(1+fun(n-1,l,target-l.get(n)),fun(n-1,l,target));
        }
        else{
            return dp[n][target]=fun(n-1,l,target);
        }
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();
        dp=new Integer[n+1][target+1];
        int a=fun(nums.size()-1,nums,target);
        if(a<=0){
            return -1;
        }
        return a;
    }
}