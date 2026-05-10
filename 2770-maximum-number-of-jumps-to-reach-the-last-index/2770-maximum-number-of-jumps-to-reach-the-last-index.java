class Solution {
    Integer dp[];
    public int fun(int id,int n,int tr,int nums[]){
        if(id==n-1){
            return 0;
        }
        if(id>=n){
            return -10000;
        }
        if(dp[id]!=null){
            return dp[id];
        }
        int a=-10000;
        for(int i=id+1;i<n;i++){
            int el=nums[i]-nums[id];
            if(el>=-tr && el<=tr){
                int x=fun(i,n,tr,nums);
                if(x!=-10000){
                     a=Math.max(a,1+x);
                } 
            }
        }
        return dp[id]=a;
    }
    public int maximumJumps(int[] nums, int target) {
        if(nums.length==1){
            return 0;
        }
        dp=new Integer[nums.length+1];
        int a=fun(0,nums.length,target,nums);
        if(a==-10000) return -1;
        return a;
    }
}