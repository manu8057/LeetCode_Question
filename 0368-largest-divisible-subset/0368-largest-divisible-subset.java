class Solution {
    List<Integer>[][] dp;
    public List<Integer> fun(int i,int n,int nums[],int pre){
        if(i>=n){
            return new ArrayList<>();
        }
        if(dp[i][pre+1]!=null){
            return new ArrayList<>(dp[i][pre+1]);
        }
        List<Integer>notTake=fun(i+1,n,nums,pre);
        List<Integer>take=new ArrayList<>();
        if(pre==-1 || nums[i]%nums[pre]==0){
            take=fun(i+1,n,nums,i);
            take=new ArrayList<>(take);
            take.add(0,nums[i]);
        }
        if(take.size()>=notTake.size()){
            dp[i][pre+1]=new ArrayList<>(take);
        }else{
            dp[i][pre+1]=new ArrayList<>(notTake);
        }
        return new ArrayList<>(dp[i][pre+1]);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        dp=new ArrayList[n][n+1];
        return fun(0,n,nums,-1);
    }
}