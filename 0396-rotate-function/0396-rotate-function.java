class Solution {
    public int  maxRotateFunction(int[] nums) {
        int n=nums.length;
        long sum=0;
        long fl=0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            fl+=(long)i*nums[i];
        }
        long res=fl;
        for(int k=1;k<n;k++){
            fl=fl+sum-(long)n*nums[n-k];
            res=Math.max(res,fl);
        }
        return (int)res;
    }
}