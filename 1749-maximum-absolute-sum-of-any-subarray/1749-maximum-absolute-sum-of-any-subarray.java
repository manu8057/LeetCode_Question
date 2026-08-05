class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum=0;
        int sum2=0;
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum=Math.max(nums[i],sum+nums[i]);
            sum2=Math.min(nums[i],sum2+nums[i]);
            max=Math.max(sum,max);
            min=Math.min(sum2,min);
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}