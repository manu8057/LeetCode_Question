class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int j=0;
        int sum=0;
        int min=n+1;
        for(int i=0;i<n;i+=1){
            sum+=nums[i];
            while(sum>=target){
                sum-=nums[j];
                min=Math.min(min,i-j+1);
                j+=1;
            }
        }
        return min==n+1?0:min;
    }
}